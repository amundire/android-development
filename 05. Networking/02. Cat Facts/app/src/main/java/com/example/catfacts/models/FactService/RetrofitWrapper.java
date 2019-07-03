package com.example.catfacts.models.FactService;

import android.content.Context;
import android.widget.Toast;

import com.example.catfacts.MainActivity;
import com.example.catfacts.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWrapper {
    private static final String BASE_URL = "https://cat-fact.herokuapp.com/";
    private static RetrofitWrapper wrapper;
    private RetrofitService service;

    private RetrofitWrapper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public static RetrofitWrapper getInstance() {
        if (wrapper == null) {
            return wrapper = new RetrofitWrapper();
        } else {
            return wrapper;
        }
    }

    public void getFact(final Context context, final ActivityMainBinding binding) {
        Call<Fact> call = service.getFact();
        call.enqueue(new Callback<Fact>() {
            @Override
            public void onResponse(Call<Fact> call, Response<Fact> response) {
                if (response.isSuccessful()) {
                    Fact responseFact = response.body();
                    binding.txtFact.setText(responseFact.toString());
                } else {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Fact> call, Throwable t) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

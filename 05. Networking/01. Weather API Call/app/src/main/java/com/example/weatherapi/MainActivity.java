package com.example.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.weatherapi.data.remote.WeatherModel;
import com.example.weatherapi.data.remote.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRetrofit();
    }

    private void setupRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        Call call = service.getCurrentWeather("Sofia", "ff1b0564553117c202c941eb4708c4d6");

        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response != null && response.isSuccessful()){
                    WeatherModel model = response.body();
                    Toast.makeText(MainActivity.this, model.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "onResponse Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

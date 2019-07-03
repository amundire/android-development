package com.example.catfacts.models.FactService;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("facts/random")
    Call<Fact> getFact();
}

package com.example.weatherapi.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    //github.com/users/amundire/repos
    //@GET("users/{user}/repos")
    //Call<List<Repos>> listRepos(@Path("user") String user);

    @GET("forecast")
    Call<WeatherModel> getCurrentWeather(@Query("q") String city,
                                               @Query("appid") String apiKey);
}

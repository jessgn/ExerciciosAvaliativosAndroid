package com.example.conversor.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;
    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://economia.awesomeapi.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public CurrencyService getCurrencyService() {
        return this.retrofit.create(CurrencyService.class);
    }
}

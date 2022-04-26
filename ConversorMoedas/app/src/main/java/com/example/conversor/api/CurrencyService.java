package com.example.conversor.api;

import com.example.conversor.model.Currency;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyService {
    @GET("last/{code}-{codeIn}")
        Call<HashMap<String, Currency>> getCurrentCurrency(@Path("code") String code, @Path("codeIn") String codeIn);
}
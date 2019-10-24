package com.scc.myrestaurant.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroConfig {
    private final static String API_KEY = "api_KEY";
    public static final String BASE_URL = "https://";
    public static Retrofit retrofit;

    public static String getApiKey(){
        return API_KEY;
    }

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}

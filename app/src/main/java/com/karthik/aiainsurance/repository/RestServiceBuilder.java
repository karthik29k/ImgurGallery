package com.karthik.aiainsurance.repository;

import com.karthik.aiainsurance.config.OkHttpClientCreator;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestServiceBuilder {
    private static String URL = "https://api.imgur.com/3/gallery/t/";

    public static Retrofit create() {
        Builder builder = new Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientCreator.create());

        return builder.build();
    }

}

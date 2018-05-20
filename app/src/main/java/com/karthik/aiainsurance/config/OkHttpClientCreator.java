package com.karthik.aiainsurance.config;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientCreator {

    @NonNull
    public static OkHttpClient create() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Builder builder = new Builder()
                .addInterceptor(interceptor);

        return builder.build();
    }

}

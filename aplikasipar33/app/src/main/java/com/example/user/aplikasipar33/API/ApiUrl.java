package com.example.user.aplikasipar33.API;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.aplikasipar33.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 2/13/2020.
 */

public class ApiUrl extends AppCompatActivity {
    public static final String ROOT_URL = "http://192.168.43.152/";
    //public static final String URLGAMBAR= "http://172.20.10.4/layanan/PhotoUploads/Uploads/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null){


            retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(ROOT_URL).create(ApiService.class);
    }
}


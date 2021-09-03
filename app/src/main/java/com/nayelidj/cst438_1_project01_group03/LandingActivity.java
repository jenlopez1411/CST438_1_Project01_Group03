package com.nayelidj.cst438_1_project01_group03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingActivity extends AppCompatActivity {
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // will prevent Patch from ignoring null
        Gson gson = new GsonBuilder().serializeNulls().create();

        //if you add v3 to baseurl has a backslash: /v3/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.adzuna.com/v1/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }
}
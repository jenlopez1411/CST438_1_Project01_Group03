package com.nayelidj.cst438_1_project01_group03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingActivity extends AppCompatActivity {
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        textViewResult = findViewById(R.id.text_view_result);


        // will prevent Patch from ignoring null
        Gson gson = new GsonBuilder().serializeNulls().create();

        //if you add v3 to baseurl has a backslash: /v3/
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://api.adzuna.com/v1/api/jobs/us/search/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //getJobSearchResults();
        textViewResult.setText("Test");
        getJobSearchResult();
    }

//    private void getJobSearchResults() {
//
//
//        Call<List<JobSearchResults>> call = jsonPlaceHolderApi.getJobSearchResults();
//
//        call.enqueue(new Callback<List<JobSearchResults>>() {
//            @Override
//            public void onResponse(Call<List<JobSearchResults>> call, Response<List<JobSearchResults>> response) {
//
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<JobSearchResults> results = response.body();
//
//                for (JobSearchResults result : results) {
//                    String content = "";
//                    content += "count: " + result.getCount() + "\n";
//                    content += "mean: " + result.getMean() + "\n";
//                    //content += "Result: " + result.getResults() + "\n";
//
//                    textViewResult.append(content);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<JobSearchResults>> call, Throwable t) {
//                textViewResult.setText("Message: " + t.getMessage());
//            }
//        });
//    }

    private void getJobSearchResult() {

        Call<JobSearchResults> call = jsonPlaceHolderApi.getJobSearchResult();

        call.enqueue(new Callback<JobSearchResults>() {
            @Override
            public void onResponse(Call<JobSearchResults> call, Response<JobSearchResults> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                JobSearchResults results = response.body();

                String content = "";

                content += "Count: " + String.valueOf(results.getCount()) + "\n";
                content += "Mean: " + String.valueOf(results.getMean()) + "\n";

                content += "Results: \n";
                for (Results result : results.getResults())
                {
                    //result values
                    Category category = result.getCategory();
                    Company company = result.getCompany();
                    Location location = result.getLocation();
                    String created = result.getCreated();
                    String description = result.getDescription();
                    String id = result.getId();
                    float latitude = result.getLatitude();
                    float longitude = result.getLongitude();
                    String redirect_url = result.getRedirect_url();
                    String salary_is_predicted = result.getSalary_is_predicted();
                    String title = result.getTitle();

                    //category values
                    String label = category.getLabel();
                    String tag = category.getTag();

                    //company values
                    String display_name = company.getDisplay_name();

                    //location values
                    ArrayList<String> area = location.getArea();
                    String location_display_name = location.getDisplay_name();

                    content += "Date posted: " + created + "\n";
                    content += "Company Name: " + display_name + "\n";
                    content += "Job title: " + title + "\n";
                    content += "Job Label: " + label + "\n";
                    content += "Job Tag: " + tag + "\n";
                    content += "Job Id: " + id + "\n";
                    content += "Description: " + description + "\n";
                    content += "Is salary predicted: " + salary_is_predicted + "\n";
                    content += "Locations: \n";
                    for (String place : area)
                    {
                        content += "    " + place + "\n";
                    }
                    content += "Location Display Name: " + location_display_name + "\n";
                    content += "Latitude: " + latitude + "\n";
                    content += "Longitude: " + longitude + "\n";
                    content += "Redirect URL: " + redirect_url + "\n";
                    textViewResult.append(content);
                    content = "";
                }

            }

            @Override
            public void onFailure(Call<JobSearchResults> call, Throwable t) {
                textViewResult.setText("Message: " + t.getMessage());
            }
        });
    }
//        Call<List<String>> call = jsonPlaceHolderApi.getJobSearchResults();
//
//        call.enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                if (!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<String> results = response.body();
//
//                for (String result : results)
//                {
//                    String content = "";
//                    content += "Output! " + result + "\n";
//
//                    textViewResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//                textViewResult.setText("Message: " + t.getMessage());
//            }
//        });
    //  }
    }
package com.nayelidj.cst438_1_project01_group03;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchPage extends AppCompatActivity {
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private Button searchButton;

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
    }
    public void searchB(View view){
        Context context = getApplicationContext();

        EditText userInput = findViewById(R.id.searchBar);
        EditText pageNumber = findViewById(R.id.pageNum);

        searchButton = findViewById(R.id.searchPagebtn);

        textViewResult = findViewById(R.id.text_view_result);

        // will prevent Patch from ignoring null
        Gson gson = new GsonBuilder().serializeNulls().create();

        //if you add v3 to baseurl has a backslash: /v3/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.adzuna.com/v1/api/jobs/us/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        final String userInputV = String.valueOf(userInput.getText());
        final int pageNumberInput = Integer.parseInt(String.valueOf(pageNumber.getText()));

        getJobSearchResult(userInputV, pageNumberInput);
    }

    private void getJobSearchResult(String s, int page) {

        textViewResult.setText("");
        Call<JobSearchResults> call = jsonPlaceHolderApi.getJobSearchResult(page, 10, s);

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

                content += "Results: \n";
                for (Results result : results.getResults())
                {
                    //result values
                    Category category = result.getCategory();
                    Company company = result.getCompany();
                    Location location = result.getLocation();
                    String created = result.getCreated();
                    String description = result.getDescription();
                    String redirect_url = result.getRedirect_url();
                    String title = result.getTitle();

                    //category values
                    String label = category.getLabel();

                    //company values
                    String display_name = company.getDisplay_name();

                    //location values
                    ArrayList<String> area = location.getArea();
                    String location_display_name = location.getDisplay_name();

                    content += "Date posted: " + created + "\n";
                    content += "Company Name: " + display_name + "\n";
                    content += "Job title: " + title + "\n";
                    content += "Job Label: " + label + "\n";
                    content += "Description: " + description + "\n";
                    content += "Location: \n";
                    for (String place : area)
                    {
                        content += "    " + place + "\n";
                    }
                    content += "Location Display Name: " + location_display_name + "\n";
                    content += "Redirect URL: " + redirect_url + "\n";
                    content += "\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<JobSearchResults> call, Throwable t) {
                textViewResult.setText("Message: " + t.getMessage());
            }
        });
    }




}

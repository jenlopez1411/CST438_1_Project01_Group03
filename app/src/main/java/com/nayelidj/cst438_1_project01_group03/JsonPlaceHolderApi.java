package com.nayelidj.cst438_1_project01_group03;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {


    @GET("?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
    Call<List<JobSearchResults>> getJobSearchResults();

    @GET("?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
    Call<JobSearchResults> getJobSearchResult();

    @GET("{page}/?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
    Call<JobSearchResults> getJobSearchResult(
            @Path("page") int page,
            @Query("results_per_page") int results,
            @Query("what_and") String words
            );

    //make an API caller to gather the following
//    Count,
//    Job Title,
//    Job Label,
//    Company Name,
//    When it was Posted,
//    City Name, County Name, State Name,
//    Redirect URL
}

package com.nayelidj.cst438_1_project01_group03;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {


    @GET("?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
    Call<List<JobSearchResults>> getJobSearchResults();

    @GET("?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
    Call<JobSearchResults> getJobSearchResult();

//    @GET("?app_id=652fe145&app_key=28982e37348e7c4b3b188b30ef6f5181")
//    Call<List<String>> getJobSearchResults();

}

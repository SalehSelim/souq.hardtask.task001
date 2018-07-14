package com.task001.Api;


import com.task001.Model.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ssasa on 07-Jul-18.
 */

public interface ApiInterface {

    @GET("GetCategories?categoryId=0&countryId=1")
    Call<ArrayList<Category>> getCategories();


    @GET("GetCategories")
    Call<ArrayList<Category>> getSubCategories(@Query("categoryId") String categoryId,@Query("countryId") String countryId);
}

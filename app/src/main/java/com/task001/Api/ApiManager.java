package com.task001.Api;

import com.task001.Model.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private static ApiInterface apiInterface = null;

    private static ApiInterface getApiInterface() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        return apiInterface;
    }

    public static void getCategories(final ApiResponse callBack) {
        Call<ArrayList<Category>> call = getApiInterface().getCategories();
        call.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                callBack.onFailure(t);
            }
        });
    }


    public static void getSubCategories(final ApiResponse callBack , String categoryId) {
        Call<ArrayList<Category>> call = getApiInterface().getSubCategories(categoryId,"1");
        call.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                callBack.onFailure(t);
            }
        });
    }
}
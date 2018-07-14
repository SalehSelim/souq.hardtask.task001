package com.task001.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ssasa on 07-Jul-18.
 */

public class ApiClient {
    public static String Base_URL = ApiConstants.BASE_URL;
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit ;
    }
}

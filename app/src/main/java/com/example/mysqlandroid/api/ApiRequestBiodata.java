package com.example.mysqlandroid.api;

import com.example.mysqlandroid.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiRequestBiodata {

    @GET("view_data.php")
    Call<ResponsModel> getBiodata();
}

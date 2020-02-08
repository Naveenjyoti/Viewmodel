package com.ceyes.sd.co.viewmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://gupshup.site/apisv1/";

    @GET("indexproduct.php/")
    Call<List<SectionDataModel>> getdata();
}
package com.ceyes.sd.co.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datamodel extends ViewModel {
    private MutableLiveData<List<SectionDataModel>> heroList;

    public LiveData<List<SectionDataModel>> getdata() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<SectionDataModel>>();
            //we will load it asynchronously from server in this method
            loaddata();
        }

        //finally we will return the list
        return heroList;
    }

    @SuppressLint("NewApi")
    private void loaddata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<SectionDataModel>> call = api.getdata();


        call.enqueue(new Callback<List<SectionDataModel>>() {
            @Override
            public void onResponse(Call<List<SectionDataModel>> call, Response<List<SectionDataModel>> response) {

                //finally we are setting the list to our MutableLiveData
               heroList.setValue(response.body());
                try {
                    System.out.println(response.body());
                    System.out.println("Number :"+response.body());
                    List<SectionDataModel> heroList = response.body();
                    for (int i = 0; i < heroList.size(); i++) {
                        System.out.println(heroList.get(i).getName());

                        List<SingleItemModel> heroList1=heroList.get(i).getValues();
                        for (int ii = 0; ii < heroList1.size(); ii++) {
                            System.out.println(heroList1.get(ii).getId());
                        }

                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<SectionDataModel>> call, Throwable t) {

            }
        });
    }
}

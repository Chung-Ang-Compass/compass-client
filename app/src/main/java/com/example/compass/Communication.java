package com.example.compass;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Communication {
    private static ServiceApi service;

    public static void updateGuides(){
        service = RetrofitClient.getClient().create(ServiceApi.class);
        GuidesData data = new GuidesData(1);
        service.fetchGuides(data).enqueue(new Callback<GuidesResponse[]>() {
            @Override
            public void onResponse(Call<GuidesResponse[]> call, Response<GuidesResponse[]> response) {
                GuidesResponse[] result = response.body();

                for(int i =0; i<result.length; i++){
                    if (result[i].getCode() == 200) {
                        Guide guide = new Guide(result[i].getGuideName(), result[i].getCountry(), result[i].getCity(), result[i].getTheme(), null, null);
                        Guides.addGuide(guide);
                    }
                }
            }

            @Override
            public void onFailure(Call<GuidesResponse[]> call, Throwable t) {
                Log.e("가이드 조회 에러 발생", t.getMessage());
            }
        });
    }
}

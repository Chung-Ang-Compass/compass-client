package com.example.compass;

//import com.example.compass.JoinData;
//import com.example.compass.JoinResponse;
//import com.example.compass.LoginData;
//import com.example.compass.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
        @POST("/user/login")
        Call<LoginResponse> userLogin(@Body LoginData data);

        @POST("/user/join")
        Call<JoinResponse> userJoin(@Body JoinData data);

        @POST("/guide")
        Call<GuidesResponse[]> fetchGuides(@Body GuidesData data);

}

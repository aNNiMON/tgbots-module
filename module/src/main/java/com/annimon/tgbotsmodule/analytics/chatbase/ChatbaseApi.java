package com.annimon.tgbotsmodule.analytics.chatbase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface ChatbaseApi {

    String API_URL = "https://chatbase.com/api/";

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("message")
    Call<GenericResponse> message(@Body GenericMessage body);
}

package com.github.tenx.volleyassignment.Api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.tenx.volleyassignment.Api.models.UserResponse;
import com.github.tenx.volleyassignment.ui.main.callbacks.ResponseHandler;
import com.google.gson.Gson;

public class ApiService {



//    singleton instance
    private static ApiService instance;


//    required params
    private Context context;

//    constants
    private String url = "https://randomuser.me/api/?results=20";
    private static final String USER_GET = "ApiService_USER_GET";


    private RequestQueue requestQueue;

    public ApiService(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public void initiateRequest(final ResponseHandler callback){
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            callback.onSuccess(new Gson().fromJson(response, UserResponse.class).getResults());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    callback.onError(error.getMessage());
            }
        });
        request.setTag(USER_GET);
        requestQueue.add(request);
    }


    public void stopRequestQueue(){
//        gonna ignore this for this project || usually you might want to pass this to the presenter
        if(requestQueue != null){
            requestQueue.cancelAll(USER_GET);
        }
    }

//    function to provide  a single instance of api service

    public static   ApiService getInstance(Context context){
        if(instance == null){
            synchronized (ApiService.class){
                if(instance == null){
                    instance = new ApiService(context);
                }
            }
        }
        return instance;
    }


}

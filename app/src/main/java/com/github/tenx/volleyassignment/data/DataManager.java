package com.github.tenx.volleyassignment.data;

import android.content.Context;

import com.github.tenx.volleyassignment.Api.ApiService;
import com.github.tenx.volleyassignment.Api.models.UserResponse;
import com.github.tenx.volleyassignment.ui.main.callbacks.ResponseHandler;

import java.util.List;

public class DataManager implements  DataManagerHelper {

    private static final String TAG = "DataManager";

    private Context context;
    private ApiService apiInstance;

//    self instance
    private static DataManager instance;

    public DataManager(Context context) {
        this.context = context;
        apiInstance = ApiService.getInstance(context);
    }


    @Override
    public void getUsers(final ResponseHandler callback) {
        apiInstance.getUsers(new ResponseHandler() {
            @Override
            public void onSuccess(List<UserResponse.User> data) {
                callback.onSuccess(data);
            }
            @Override
            public void onError(String data) {
                callback.onError(data);
            }
        });
    }

    @Override
    public void stopUserRequestQueue() {
        apiInstance.stopUserRequestQueue();
    }

    //    function to provide  a single instance of Datamanager

    public static  DataManager getInstance(Context context){
        if(instance == null){
                synchronized (DataManager.class){
                    if(instance == null){
                        instance = new DataManager(context);
                    }
                }
        }
        return instance;
    }


}

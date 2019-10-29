package com.github.tenx.volleyassignment.ui.main;

import android.content.Context;

import com.github.tenx.volleyassignment.Api.models.UserResponse;
import com.github.tenx.volleyassignment.data.DataManager;
import com.github.tenx.volleyassignment.ui.main.callbacks.ResponseHandler;

import java.util.List;

public class MainPresenter {
    private Context context;
    private DataManager dataManager;
    private View view;

    public MainPresenter(Context context, View view) {
        this.context = context;
        this.dataManager = DataManager.getInstance(context);
        this.view = view;

    }


    public void getUsers(){
        this.dataManager.fetchUsers(new ResponseHandler() {
            @Override
            public void onSuccess(List<UserResponse.User> data) {
                view.onSuccess(data);
            }

            @Override
            public void onError(String data) {
                view.onFailure(data);
            }
        });
    }


    interface View {
        void onSuccess(List<UserResponse.User> data);
        void onFailure(String text);
    }
}

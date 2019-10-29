package com.github.tenx.volleyassignment.ui.main.callbacks;

import com.github.tenx.volleyassignment.Api.models.UserResponse;

import java.util.List;

public interface ResponseHandler {

     void onSuccess(List<UserResponse.User> data);
     void onError(String data);
}

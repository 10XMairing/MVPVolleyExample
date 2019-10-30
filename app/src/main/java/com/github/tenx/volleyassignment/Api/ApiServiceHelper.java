package com.github.tenx.volleyassignment.Api;

import com.github.tenx.volleyassignment.ui.main.callbacks.ResponseHandler;

public interface ApiServiceHelper {
    void getUsers(final ResponseHandler callback);
    void stopUserRequestQueue();


}

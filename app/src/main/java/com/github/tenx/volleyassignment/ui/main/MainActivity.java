package com.github.tenx.volleyassignment.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.github.tenx.volleyassignment.R;
import com.github.tenx.volleyassignment.Api.models.UserResponse;
import com.github.tenx.volleyassignment.ui.main.adapter.UserAdapter;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainPresenter.View {





    private static final String TAG = "MainActivity";

//    views
    private RecyclerView mRecyclerUser;
    private UserAdapter mAdapter;

//    presenter
    private MainPresenter presenter;

//    initialize views

    private void initViews(){
        mRecyclerUser = findViewById(R.id.rec_users);
    }

//    initialize adapters

    private void initAdapters(Context context){
        mAdapter = new UserAdapter(context);
    }

    private void initPresenter(Context context, MainPresenter.View callback){
        presenter = new MainPresenter(context, callback);
    }

//    setup adapters

    private void setUpAdapter(RecyclerView.Adapter adapter , RecyclerView recyclerView, Context context){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
//        initiate get users
        presenter.getUsers();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//initialization
        initViews();
        initAdapters(this);
        setUpAdapter(mAdapter, mRecyclerUser, this);
        initPresenter(this, this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    fetch user callback

    @Override
    public void onSuccess(List<UserResponse.User> data) {
        mAdapter.updateList(data);
    }

    @Override
    public void onFailure(String text) {
//        ignore

    }
}

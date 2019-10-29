package com.github.tenx.volleyassignment.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tenx.volleyassignment.R;
import com.github.tenx.volleyassignment.Api.models.UserResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {



    private Context context;
    private List<UserResponse.User> mList;

    public UserAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem_user, parent , false);

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserResponse.User currentData = mList.get(position);
        String first = currentData.getName().get("first").toString();
        String last = currentData.getName().get("last").toString();

        holder.tvUsername.setText("name : "+first + " "+last);



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



//    custom functions
    public void updateList(List<UserResponse.User> users){
        this.mList = users;
        notifyDataSetChanged();
    }




    public class UserViewHolder extends  RecyclerView.ViewHolder {

        private TextView tvUsername;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tv_main_username);
        }
    }
}

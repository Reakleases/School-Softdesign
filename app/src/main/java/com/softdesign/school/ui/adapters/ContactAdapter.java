package com.softdesign.school.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<UserViewHolder> {


    private ArrayList<User> mDataSet;

    public ContactAdapter(ArrayList<User> mDataSet) {
        this.mDataSet = mDataSet;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mDataSet.get(position);
        holder.fullName.setText(user.getmFirstName() + " " + user.getmLastName());
        holder.avatar.setImageDrawable(user.getmImage());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }









}

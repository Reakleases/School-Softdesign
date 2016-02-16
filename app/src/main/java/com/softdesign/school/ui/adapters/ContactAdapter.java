package com.softdesign.school.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.UserOld;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.UserViewHolder> {


    private ArrayList<UserOld> mDataSet;

    public ContactAdapter(ArrayList<UserOld> mDataSet) {
        this.mDataSet = mDataSet;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user_old, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserOld user = mDataSet.get(position);
        holder.fullName.setText(user.getmFirstName() + " " + user.getmLastName());
        holder.avatar.setImageDrawable(user.getmImage());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {

        protected TextView fullName;
        protected ImageView avatar;

        public UserViewHolder(View convertView) {
            super(convertView);
            fullName = (TextView) convertView.findViewById(R.id.user_full_name);
            avatar = (ImageView) convertView.findViewById(R.id.user_avatar);
        }
    }









}

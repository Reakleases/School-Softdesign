package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;

import java.util.List;

public class RecycleUserAdapter extends RecyclerView.Adapter<RecycleUserAdapter.UserViewHolder> {


    private List<User> mDataSet;

    public RecycleUserAdapter(List<User> mDataSet) {
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
        holder.fullName.setText(user.getFirstName() + " " + user.getLastName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        protected TextView fullName;

        public UserViewHolder(View convertView) {
            super(convertView);
            fullName = (TextView) convertView.findViewById(R.id.user_full_name);
        }
    }

}

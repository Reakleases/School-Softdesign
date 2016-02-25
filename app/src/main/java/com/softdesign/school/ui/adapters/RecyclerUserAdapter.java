package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;

import java.util.List;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.UserViewHolder> {


    private List<User> mDataSet;

    public RecyclerUserAdapter(List<User> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_contact, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mDataSet.get(position);
        holder.mUser = user;
        holder.fullName.setText(user.getFirstName() + " " + user.getLastName());
        holder.teamName.setText(user.getTeam().getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        protected TextView fullName;
        protected TextView teamName;
        private User mUser;

        public UserViewHolder(View convertView) {
            super(convertView);
            fullName = (TextView) convertView.findViewById(R.id.user_full_name);
            teamName = (TextView) convertView.findViewById(R.id.user_team);

        }

        public User getUser() {
            return mUser;
        }
    }

}

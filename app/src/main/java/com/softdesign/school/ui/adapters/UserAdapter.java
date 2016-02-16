package com.softdesign.school.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    Context mContext;
    List<User> mUsers;
    LayoutInflater mInflater;

    public UserAdapter(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<User> users) {
        this.mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null)
            itemView = mInflater.inflate(R.layout.item_list_user, parent, false);
        User user = (User) getItem(position);

        TextView fullname = (TextView) itemView.findViewById(R.id.user_full_name);
        fullname.setText(user.getFirstName() + " " + user.getLastName());

        TextView team = (TextView) itemView.findViewById(R.id.user_team);
        team.setText(user.team.name);

        return itemView;
    }
}

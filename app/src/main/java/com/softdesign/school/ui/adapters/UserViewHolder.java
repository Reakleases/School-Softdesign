package com.softdesign.school.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    protected TextView fullName;
    protected ImageView avatar;

    public UserViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.user_avatar);
        fullName = (TextView) itemView.findViewById(R.id.user_full_name);

    }
}

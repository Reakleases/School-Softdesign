package com.softdesign.school.ui.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;


public class TeamFragmentAdd extends android.support.v4.app.DialogFragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_team, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().setTitle(R.string.dialog_add_team);
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Lg.e("dialog", "team add: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Lg.e("dialog", "team add: onCancel");
    }


}

package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

/**
 * Created by Remapper on 28.01.2016.
 */
public class ContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_contacts, null);
        getActivity().setTitle(R.string.drawer_contacts);
        ((MainActivity)getActivity()).checkMenu(R.id.drawer_contacts);
        return convertView;
    }
}

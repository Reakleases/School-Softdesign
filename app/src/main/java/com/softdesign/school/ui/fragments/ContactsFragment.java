package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.ContactAdapter;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {

    ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView listContacts;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        mAdapter = new ContactAdapter(mUsers);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_contacts, container, false);
        getActivity().setTitle(R.string.drawer_contacts);
        ((MainActivity) getActivity()).checkMenu(R.id.drawer_contacts);
        ((MainActivity) getActivity()).collapseAppBar(true);
        listContacts = (RecyclerView) convertView.findViewById(R.id.users_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(mLayoutManager);

        return convertView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listContacts.setAdapter(mAdapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.coordinator_container);
        params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_add_black);
        fab.show();


    }


    private void generateData() {
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new User(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
    }
}

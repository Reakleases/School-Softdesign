package com.softdesign.school.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.UserOld;
import com.softdesign.school.ui.adapters.ContactAdapter;

import java.util.ArrayList;

public class UserFragmentAdd extends Fragment{

    ArrayList<UserOld> mUsers = new ArrayList<>();
    private RecyclerView.Adapter userAdapter;
    RecyclerView listContacts;
    View mView;
    Spinner mSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return mView = inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        userAdapter = new ContactAdapter(mUsers);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.drawer_contacts);
        listContacts = (RecyclerView) mView.findViewById(R.id.users_list);
        listContacts.setHasFixedSize(true);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(LayoutManager);
        listContacts.setAdapter(userAdapter);


        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();


    }


    private void generateData() {
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsers.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
    }

}

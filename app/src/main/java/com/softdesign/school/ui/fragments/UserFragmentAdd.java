package com.softdesign.school.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.RecycleUserAdapter;
import com.softdesign.school.ui.adapters.UserAdapter;

import java.util.List;


public class UserFragmentAdd extends Fragment{

    //ArrayList<UserOld> mUsersOld = new ArrayList<>();
    //private RecyclerView.Adapter userAdapterOld;
    private RecyclerView.Adapter mRecycleUserAdapter;
    RecyclerView listContacts;
    View mView;
    List<User> mUsers;
    UserAdapter userAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mView = inflater.inflate(R.layout.fragment_contacts, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //generateData();
        //userAdapterOld = new ContactAdapter(mUsersOld);

        mUsers = User.getDataListUsers();
        mRecycleUserAdapter = new RecycleUserAdapter(mUsers);

        //userAdapter = new UserAdapter(getContext());
        //userAdapter.setData(mUsers);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.drawer_contacts);
        listContacts = (RecyclerView) mView.findViewById(R.id.users_list);
        //listContacts.setHasFixedSize(true);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(LayoutManager);
        listContacts.setAdapter(mRecycleUserAdapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();




    }





    /*private void generateData() {
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Иван", "Иванов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Петр", "Петров"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Семен", "Семенов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Василий", "Козлов"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Изя", "Васерман"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Руслан", "Урмеев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Константин", "Пожидаев"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Инга", "Инжир"));
        mUsersOld.add(new UserOld(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_circle_24dp), "Анна", "Пожидаева"));
    }*/



}

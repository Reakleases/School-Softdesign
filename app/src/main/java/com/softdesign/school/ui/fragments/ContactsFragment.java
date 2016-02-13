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
import com.softdesign.school.utils.Lg;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {


    ArrayList<User> mUsers = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    RecyclerView listContacts;
    View mainView;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        mAdapter = new ContactAdapter(mUsers);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mainView == null) {
            mainView = inflater.inflate(R.layout.fragment_contacts, container, false);
            Lg.e("Contact fragment", "inflating new fragment");
        }









        getActivity().setTitle(R.string.drawer_contacts);

        listContacts = (RecyclerView) mainView.findViewById(R.id.users_list);
        listContacts.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(mLayoutManager);
        listContacts.setAdapter(mAdapter);
        ((MainActivity) getActivity()).collapseAppBar(true);



        return mainView;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).checkMenu(R.id.drawer_contacts);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.coordinator_container);
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_add);
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

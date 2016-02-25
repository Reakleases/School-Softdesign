package com.softdesign.school.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.activities.TeamActivity;
import com.softdesign.school.ui.adapters.RecyclerUserAdapter;

import java.util.List;


public class ContactsFragmentAdd extends Fragment implements LoaderManager.LoaderCallbacks<List<User>> {

    private RecyclerView.Adapter mRecyclerUserAdapter;
    RecyclerView listContacts;
    View mView;
    List<User> mUsers;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mView = inflater.inflate(R.layout.fragment_add_contacts, container, false);
    }


    public void reloadFragment() {
        getLoaderManager().initLoader(0, null, this).forceLoad();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mUsers = User.getDataListUsers();
        mRecyclerUserAdapter = new RecyclerUserAdapter(mUsers);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.drawer_contacts);
        ((TeamActivity) getActivity()).checkMenu(R.id.drawer_contacts);
        getLoaderManager().initLoader(0, null, this);
        listContacts = (RecyclerView) mView.findViewById(R.id.users_list);
        listContacts.setHasFixedSize(true);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(LayoutManager);
        listContacts.setAdapter(mRecyclerUserAdapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();



        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        User user = mUsers.get(position);
                        user.delete();
                        getLoaderManager().getLoader(0).forceLoad();
                        listContacts.getAdapter().notifyItemRemoved(position);
                        getLoaderManager().getLoader(0).forceLoad();
                        listContacts.getAdapter().notifyItemRemoved(position);

                        //((RecyclerUserAdapter.UserViewHolder) viewHolder).getUser().delete();

                    }
                });
        itemTouchHelper.attachToRecyclerView(listContacts);


    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<User>>(getContext()) {
            @Override
            public List<User> loadInBackground() {
                return User.getDataListUsers();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<User>> loader, List<User> data) {
        mRecyclerUserAdapter = new RecyclerUserAdapter(data);
        listContacts.setAdapter(mRecyclerUserAdapter);
        mUsers.clear();
        mUsers.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<User>> loader) {

    }


}

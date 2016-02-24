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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.Team;
import com.softdesign.school.ui.activities.TeamActivity;
import com.softdesign.school.ui.adapters.RecyclerTeamAdapter;

import java.util.List;


public class TeamFragmentAdd extends Fragment implements LoaderManager.LoaderCallbacks<List<Team>> {


    private RecyclerView.Adapter mRecyclerTeamAdapter;
    RecyclerView listTeam;
    View mView;
    List<Team> mTeams;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTeams = Team.getDataListTeams();
        mRecyclerTeamAdapter = new RecyclerTeamAdapter(mTeams);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return mView = inflater.inflate(R.layout.fragment_add_team, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.drawer_team);
        ((TeamActivity) getActivity()).checkMenu(R.id.drawer_team);
        getLoaderManager().initLoader(0, null, this);
        listTeam = (RecyclerView) mView.findViewById(R.id.team_list);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getActivity());
        listTeam.setLayoutManager(LayoutManager);
        listTeam.setAdapter(mRecyclerTeamAdapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();

    }


    @Override
    public Loader<List<Team>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<Team>>(getContext()) {
            @Override
            public List<Team> loadInBackground() {
                return Team.getDataListTeams();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<Team>> loader, List<Team> data) {

        mRecyclerTeamAdapter = new RecyclerTeamAdapter(data);
        listTeam.setAdapter(mRecyclerTeamAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<Team>> loader) {

    }

    public void reloadFragment() {
        getLoaderManager().initLoader(0, null, this).forceLoad();
    }
}

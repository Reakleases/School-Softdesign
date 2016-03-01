package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.utils.BlockToolbar;

public class TasksFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tasks, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).checkMenu(R.id.drawer_tasks);
        getActivity().setTitle(R.string.drawer_tasks);

        AppBarLayout mAppbar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);
        mAppbar.setExpanded(false,false);
        BlockToolbar.setDrag(false,mAppbar);
        //((MainActivity) getActivity()).collapseAppBar(true);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.main_frame_container);
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_add);
        fab.show();
    }
}

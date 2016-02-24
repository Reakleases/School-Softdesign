package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.Team;

import java.util.List;

public class RecyclerTeamAdapter extends RecyclerView.Adapter<RecyclerTeamAdapter.TeamViewHolder> {


    private List<Team> mDataSet;

    public class TeamViewHolder extends RecyclerView.ViewHolder {

        protected TextView teamName;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.user_team);

        }
    }

    public RecyclerTeamAdapter(List<Team> DataSet) {
        this.mDataSet = DataSet;
    }


    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_team, parent, false);
        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        Team team = mDataSet.get(position);
        holder.teamName.setText(team.getName());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}

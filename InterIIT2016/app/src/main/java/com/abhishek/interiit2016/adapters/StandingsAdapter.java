package com.abhishek.interiit2016.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.model.ScheduleDTO;
import com.abhishek.interiit2016.model.StandingsDTO;

import java.util.List;

/**
 * Created by GUNDA ABHISHEK on 29-06-2016.
 */
public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.VersionViewHolder> {
    Boolean isHomeList = false;
    Context context;
    OnItemClickListener clickListener;
    private List<StandingsDTO> standingsDTOList;

    public StandingsAdapter(Context context,List<StandingsDTO> standingsDTOList){
        isHomeList=true;
        this.context=context;
        this.standingsDTOList=standingsDTOList;
    }
    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (isHomeList){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_list_item, parent, false);
            VersionViewHolder viewHolder = new VersionViewHolder(view);
            return viewHolder;
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_list_item, parent, false);
            VersionViewHolder viewHolder = new VersionViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(VersionViewHolder versionViewHolder, int i) {
        if (isHomeList) {
            versionViewHolder.standings_points.setText(standingsDTOList.get(i).getStandings_points());
            versionViewHolder.position.setText(standingsDTOList.get(i).getPosition());
            versionViewHolder.college_name.setText(standingsDTOList.get(i).getCollege_name());
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return standingsDTOList == null ? 0 : standingsDTOList.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView position,college_name,standings_points;
        public VersionViewHolder(View itemView) {
            super(itemView);
            position=(TextView)itemView.findViewById(R.id.position);
            college_name=(TextView)itemView.findViewById(R.id.college_name);
            standings_points=(TextView)itemView.findViewById(R.id.standings_points);
            if (!isHomeList) {
                itemView.setOnClickListener(this);
            } else {
            }

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}

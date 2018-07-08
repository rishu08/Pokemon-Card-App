package com.example.rishabh.pokepoke;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterStats extends RecyclerView.Adapter<ListAdapterStats.ViewHolder> {

    ArrayList<stats> statsitems;
    Context ctx;

    public ListAdapterStats(ArrayList<stats> statsitems, Context ctx) {
        this.statsitems = statsitems;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final stats stats = statsitems.get(position);

        holder.tvitem.setText(stats.getStat().getName()+":"+stats.getEffort()+":"+stats.getBase_stat());


    }

    @Override
    public int getItemCount() {
        return statsitems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvitem;


        public ViewHolder(View itemView) {
            super(itemView);
            tvitem = itemView.findViewById(R.id.content);

        }
    }
}

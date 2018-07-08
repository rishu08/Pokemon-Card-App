package com.example.rishabh.pokepoke;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterAbilities extends RecyclerView.Adapter<ListAdapterAbilities.ViewHolder>{

    ArrayList<Abilities> abilitiesitems;
    Context ctx;

    public ListAdapterAbilities(ArrayList<Abilities> abilitiesitems, Context ctx) {
        this.abilitiesitems = abilitiesitems;
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

        final Abilities abilities = abilitiesitems.get(position);
        holder.tvitem.setText(abilities.getAbility().getName()+":"+abilities.getSlot());
    }

    @Override
    public int getItemCount() {
        return abilitiesitems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvitem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvitem = itemView.findViewById(R.id.content);
        }
    }

}

package com.example.rishabh.pokepoke;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterTypes extends RecyclerView.Adapter<ListAdapterTypes.ViewHolder> {

    ArrayList<types> typesitems;
    Context ctx;

    public ListAdapterTypes(ArrayList<types> typesitems, Context ctx) {
        this.typesitems = typesitems;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final types types= typesitems.get(position);
        holder.tvitem.setText(types.getType().getName()+":"+types.getSlot());
    }

    @Override
    public int getItemCount() {
        return typesitems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvitem;


        public ViewHolder(View itemView) {
            super(itemView);
            tvitem = itemView.findViewById(R.id.content);

        }
    }

}

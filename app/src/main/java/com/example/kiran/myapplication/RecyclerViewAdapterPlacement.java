package com.example.kiran.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kiran on 10-02-2018.
 */

public class RecyclerViewAdapterPlacement extends RecyclerView.Adapter<RecyclerViewAdapterPlacement.ViewHolder>{

    private List<List_items_placement> listItems;
    Context context;


    public RecyclerViewAdapterPlacement(List<List_items_placement> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewAdapterPlacement.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final List_items_placement listItem = listItems.get(position);
        holder.textViewname.setText(List_items_placement.getHead());
        holder.textViewdate.setText(List_items_placement.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,Placement_display_desc.class);
                String head = List_items_placement.getHead().toString();
                String body = List_items_placement.getBody().toString();
                Bundle bb = new Bundle();
                bb.putString("1",head);
                bb.putString("2",body);
                i.putExtras(bb);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView textViewname;
        public TextView textViewdate;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewname = (TextView)itemView.findViewById(R.id.textviewday);
            textViewdate = (TextView)itemView.findViewById(R.id.textviewdate);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearlayout);


        }

    }


}
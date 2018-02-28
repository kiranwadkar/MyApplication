package com.example.kiran.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kiran on 11-02-2018.
 */

public class RecyclerViewAdapterCommiteeAcm extends RecyclerView.Adapter<RecyclerViewAdapterCommiteeAcm.ViewHolder>{


    private List<List_items_commitee_acm> listItems;
    Context context;

    public RecyclerViewAdapterCommiteeAcm(List<List_items_commitee_acm> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterCommiteeAcm.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewAdapterCommiteeAcm.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterCommiteeAcm.ViewHolder holder, int position) {
        final List_items_commitee_acm listItem = listItems.get(position);
        holder.textViewname.setText(listItem.getHead());
        holder.textViewdate.setText(listItem.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,Commitee_acm_registerevent.class);
                String head = listItem.getHead().toString();
                String body = listItem.getBody().toString();
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewname;
        public TextView textViewdate;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewname = (TextView)itemView.findViewById(R.id.textviewday);
            textViewdate = (TextView)itemView.findViewById(R.id.textviewdate);

        }
    }
}
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
 * Created by Kiran on 10-03-2018.
 */

public class RecyclerViewAdapterCommiteeOther extends RecyclerView.Adapter<RecyclerViewAdapterCommiteeOther.ViewHolder> {
    private List<List_items_commitee_other> listItems;
    Context context;

    public RecyclerViewAdapterCommiteeOther(List<List_items_commitee_other> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterCommiteeOther.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewAdapterCommiteeOther.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterCommiteeOther.ViewHolder holder, int position) {
        final List_items_commitee_other listItem = listItems.get(position);
        holder.textViewname.setText(listItem.getHead());
        holder.textViewdate.setText(listItem.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,Commitee_other_registerevent.class);
                String head = listItem.getHead().toString();
                String body = listItem.getBody().toString();
                String price = listItem.getPrice().toString();
                String contact = listItem.getContact().toString();
                String id = listItem.getId().toString();
                String filename = listItem.getFilename().toString();
                String origfilename = listItem.getOrigfilename().toString();
                Bundle bother = new Bundle();
                bother.putString("1",head);
                bother.putString("2",body);
                bother.putString("3",price);
                bother.putString("4",contact);
                bother.putString("5",id);
                bother.putString("6",filename);
                bother.putString("7",origfilename);
                i.putExtras(bother);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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

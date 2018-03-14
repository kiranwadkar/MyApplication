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
 * Created by Kiran on 10-02-2018.
 */

public class RecyclerViewAdapterAnnouncement extends RecyclerView.Adapter<RecyclerViewAdapterAnnouncement.ViewHolder> {

    private List<List_items_announcement> listItems;
    Context context;

    public RecyclerViewAdapterAnnouncement(List<List_items_announcement> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewAdapterAnnouncement.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // List_items_announcement listItem = listItems.get(position);
       // holder.textViewname.setText(List_items_announcement.getHead());
       // holder.textViewdate.setText(List_items_announcement.getBody());


        final List_items_announcement listItem = listItems.get(position);
        holder.textViewname.setText(listItem.getHead());
        holder.textViewdate.setText(listItem.getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,Announcement_display_desc.class);
                String head = listItem.getHead().toString();
                String body = listItem.getBody().toString();
                String id = listItem.getId().toString();
                Bundle bannouncement = new Bundle();
                bannouncement.putString("1",head);
                bannouncement.putString("2",body);
                bannouncement.putString("3",id);
                i.putExtras(bannouncement);
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

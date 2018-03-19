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

public class RecyclerViewAdapterCommiteeIeee extends RecyclerView.Adapter<RecyclerViewAdapterCommiteeIeee.ViewHolder> {

    private List<List_items_commitee_ieee> listItems;
    Context context;

    public RecyclerViewAdapterCommiteeIeee(List<List_items_commitee_ieee> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterCommiteeIeee.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewAdapterCommiteeIeee.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterCommiteeIeee.ViewHolder holder, int position) {
        final List_items_commitee_ieee listItem = listItems.get(position);
        holder.textViewname.setText(listItem.getHead());
        holder.textViewdate.setText(listItem.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,Commitee_ieee_registerevent.class);
                String head = listItem.getHead().toString();
                String body = listItem.getBody().toString();
                String price = listItem.getPrice().toString();
                String contact = listItem.getContact().toString();
                String id = listItem.getId().toString();
                String filename = listItem.getFilename().toString();
                String origfilename = listItem.getOrigfilename().toString();
                Bundle bb = new Bundle();
                bb.putString("1",head);
                bb.putString("2",body);
                bb.putString("3",price);
                bb.putString("4",contact);
                bb.putString("5",id);
                bb.putString("6",filename);
                bb.putString("7",origfilename);
                i.putExtras(bb);
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

package com.example.kiran.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kiran on 10-02-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private List<List_items> listItems;
    Context context;

    public RecyclerViewAdapter(List<List_items> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        List_items listItem = listItems.get(position);
        holder.textViewname.setText(listItem.getName());
        holder.textViewdate.setText(listItem.getDate());

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

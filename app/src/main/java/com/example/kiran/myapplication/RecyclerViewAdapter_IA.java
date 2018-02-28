package com.example.kiran.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kiran on 27-02-2018.
 */

public class RecyclerViewAdapter_IA extends RecyclerView.Adapter<RecyclerViewAdapter_IA.ViewHolder> {

    private List<List_items_ia_tt> listItems;
    Context context;

    public RecyclerViewAdapter_IA(List<List_items_ia_tt> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter_IA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ia_tt,parent,false);
        return new RecyclerViewAdapter_IA.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter_IA.ViewHolder holder, int position) {
        //List_items_ia_tt listItem = listItems.get(position);
        //holder.tv1.setText(listItem.getSubject());
        //holder.tv2.setText(listItem.getDate());
        //holder.tv3.setText(listItem.getStart_time());
        //holder.tv4.setText(listItem.getEnd_time());
        List_items_ia_tt listItem = listItems.get(position);
        holder.tv1.setText(listItem.getSubject());
        holder.tv2.setText(listItem.getDate());
        holder.tv3.setText(listItem.getStart_time());
        holder.tv4.setText(listItem.getEnd_time());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.textView2);
            tv2 = (TextView)itemView.findViewById(R.id.textView4);
            tv3 = (TextView)itemView.findViewById(R.id.textView6);
            tv4 = (TextView)itemView.findViewById(R.id.textView8);

        }
    }
}

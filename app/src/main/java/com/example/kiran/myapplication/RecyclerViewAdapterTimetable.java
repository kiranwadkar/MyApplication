package com.example.kiran.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kiran on 02-03-2018.
 */

public class RecyclerViewAdapterTimetable extends RecyclerView.Adapter<RecyclerViewAdapterTimetable.ViewHolder> {
    private List<List_items_timetable> listItems;
    Context context;

    public RecyclerViewAdapterTimetable(List<List_items_timetable> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapterTimetable.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_timetable,parent,false);
        return new RecyclerViewAdapterTimetable.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterTimetable.ViewHolder holder, int position) {
        List_items_timetable  listItem = listItems.get(position);
        holder.tv1.setText(listItem.getSubject());
        holder.tv2.setText(listItem.getTeacher());
        holder.tv3.setText(listItem.getStart_time());
        holder.tv4.setText(listItem.getEnd_time());
        holder.tv5.setText(listItem.getBlock());

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
        TextView tv5;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.textView2);
            tv2 = (TextView)itemView.findViewById(R.id.textView4);
            tv3 = (TextView)itemView.findViewById(R.id.textView6);
            tv4 = (TextView)itemView.findViewById(R.id.textView8);
            tv5 = (TextView)itemView.findViewById(R.id.textView10);
        }
    }
}

package com.example.kiran.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.text.*;
import java.util.Date;

public class Timetable extends AppCompatActivity {
    RequestQueue requestQueue;
    //String server_url="http://192.168.43.57:80/api/timetable";
    String timetableurl;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_timetable> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        listItems = new ArrayList<>();

        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");


        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String sem = m.getString("Sem","");
        final String branch =m.getString("Branch","");
        final String div =m.getString("Division","");




        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String day = sdf.format(d);

        //String day = "THURSDAY";


        Log.i("day",day);

        timetableurl = url+"/"+"timetable"+"/"+sem+"/"+branch+"/"+div+"/"+day;
        Log.i("tt_testing",timetableurl);
        jsonparse();
    }

    private void jsonparse() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, timetableurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("timetable");
                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject a1 = jsonArray.getJSONObject(i);
                        String sub = a1.getString("subject");
                        //JSONObject a2 = jsonArray.getJSONObject(i);
                        String teacher = a1.getString("teacher");
                        //JSONObject a3 = jsonArray.getJSONObject(i);
                        String start = a1.getString("start_time");
                        //JSONObject a4 = jsonArray.getJSONObject(i);
                        String end = a1.getString("end_time");
                        String block = a1.getString("block");
                        Log.i("Subject",sub);
                        Log.i("Teacher",teacher);
                        Log.i("start time",start);
                        Log.i("end time",end);
                        Log.i("Block",block);

                        List_items_timetable item =new List_items_timetable(sub,teacher,start,end,block);
                        listItems.add(item);
                    }
                    adapter = new RecyclerViewAdapterTimetable(listItems,getBaseContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}

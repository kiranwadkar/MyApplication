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

public class IA_timetable extends AppCompatActivity {


    RequestQueue requestQueue;
    //String server_url="http://192.168.43.57:80/api/ia_timetable";
    String iatturl;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_ia_tt> listItems;
    //Button parse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ia_timetable);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        //parse = (Button)findViewById(R.id.parse);

        listItems = new ArrayList<>();
        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
       // final String year = m.getString("Year","");
        final String sem = m.getString("Sem","");
        final String branch =m.getString("Branch","");
        iatturl = url+"/"+"ia_timetable"+"/"+branch+"/"+sem;
        Log.i("ia_testing",iatturl);
       jsonparse();
    }

    private void jsonparse() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, iatturl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("ia_timetable");
                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject a1 = jsonArray.getJSONObject(i);
                        String sub = a1.getString("subject");
                       //JSONObject a2 = jsonArray.getJSONObject(i);
                        String date1 = a1.getString("date");
                        //JSONObject a3 = jsonArray.getJSONObject(i);
                        String start = a1.getString("start_time");
                       //JSONObject a4 = jsonArray.getJSONObject(i);
                        String end = a1.getString("end_time");
                        Log.i("Subject",sub);
                        Log.i("date",date1);
                        Log.i("start time",start);
                        Log.i("end time",end);

                        List_items_ia_tt item =new List_items_ia_tt(sub,date1,start,end);
                        listItems.add(item);
                    }
                    adapter = new RecyclerViewAdapter_IA(listItems,getBaseContext());
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

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

public class Announcements extends AppCompatActivity {
   /*
    TextView tv1;
    Button parse;

    RequestQueue requestQueue;
    String server_url="http://192.168.0.102:80/api/announcements";
    */
  // String server_url="http://192.168.43.57:80/api/announcements";
   String announcementurl;
   private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_announcement> listItems;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);

        listItems = new ArrayList<>();
        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");


        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        //String name = m.getString("Name","");
        final String year = m.getString("Year","");
        final String branch =m.getString("Branch","");
        final String div = m.getString("Division","");
        //server_url = server_url+"/"+year+"/"+branch+"/"+div;
        announcementurl = url+"/"+"announcements"+"/"+year+"/"+branch+"/"+div;
        loadRecyclerView();
/*
        tv1 = (TextView)findViewById(R.id.tv1);
        parse = (Button) findViewById(R.id.btn);

        requestQueue = Volley.newRequestQueue(this);


        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonparse();
            }

            private void jsonparse() {
                server_url = server_url+"/"+year+"/"+branch+"/"+div;

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("announcement");
                            //JSONObject jsonObject = response.getJSONObject("announcement");
                            for(int i =0;i<jsonArray.length();i++){
                                JSONObject a1 = jsonArray.getJSONObject(i);
                                String head = a1.getString("head");
                                String body = a1.getString("body");
                                tv1.append(head+"\n" +body+"\n");

                            }
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

            final String div = m.getString("Division","");

        });



*/


    }

    private void loadRecyclerView() {

        Log.i("announcementurl",announcementurl);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, announcementurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("announcement");
                    //JSONObject jsonObject = response.getJSONObject("announcement");
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject a1 = jsonArray.getJSONObject(i);
                        String head = a1.getString("head");
                       // JSONObject a2 = jsonArray.getJSONObject(i);
                        String body = a1.getString("body");
                        Log.i("Head",head);
                        Log.i("Body",body);
                        List_items_announcement item =new  List_items_announcement(head,body);
                        listItems.add(item);
                        //tv1.append(head+"\n" +body+"\n");

                    }
                    adapter = new RecyclerViewAdapterAnnouncement(listItems,getBaseContext());
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

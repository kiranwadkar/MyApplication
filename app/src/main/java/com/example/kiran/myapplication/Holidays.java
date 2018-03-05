package com.example.kiran.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class Holidays extends AppCompatActivity {

    //Button show;
   // TextView tv1;
   // Button btn;
   // String data;
    //RequestQueue requestQueue;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items> listItems;
    RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);

        listItems = new ArrayList<>();
        loadRecyclerView();
        /*
        tv1 = (TextView) findViewById(R.id.tv1);
        btn = (Button) findViewById(R.id.btn);

        requestQueue = Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonparse();
            }
        });
        */
    }

    private void loadRecyclerView() {
        //String jsonurl="http://192.168.43.57:80/api/holidays";
        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String jsonurl = s.getString("Server","");
        String holidayurl = jsonurl+"/"+"holidays";
        Log.i("holidayurl",holidayurl);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,holidayurl , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("holiday");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject holiday1 = jsonArray.getJSONObject(i);
                        String name = holiday1.getString("name");
                        // i = holiday1.getInt("date");
                        String date =holiday1.getString("date");
                        Log.i("Date", date);

                        List_items item = new List_items(name,date);

                        listItems.add(item);
                    }
                    adapter = new RecyclerViewAdapter(listItems,getBaseContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }
    /*
    private void jsonparse(){
        String jsonurl="http://192.168.0.102:80/api/holidays";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, jsonurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("holiday");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject holiday1 = jsonArray.getJSONObject(i);
                        String name = holiday1.getString("name");
                       // i = holiday1.getInt("date");
                        String date =holiday1.getString("date");
                        tv1.append(name+date+"\n\n");




                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }
    */
}

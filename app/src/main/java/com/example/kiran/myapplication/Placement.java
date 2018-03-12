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

public class Placement extends AppCompatActivity {
    /*
    TextView tv1;
    Button parse;
     */
    //RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_placement> listItems;
    RequestQueue requestQueue;
    String placementurl;
    //String server_url="http://192.168.43.57:80/api/placements";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement);


       // tv1 = (TextView)findViewById(R.id.tv1);
       // parse = (Button) findViewById(R.id.btn);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
         recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        listItems = new ArrayList<>();
        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String year = m.getString("Year","");
        final String branch =m.getString("Branch","");
        placementurl = url+"/"+"placements"+"/"+year+"/"+branch;
        Log.i("placementurl",placementurl);
        loadRecyclerView();

    }

    private void loadRecyclerView() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, placementurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("placement");
                    //JSONObject jsonObject = response.getJSONObject("announcement");
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject a1 = jsonArray.getJSONObject(i);
                        String head = a1.getString("head");
                        String body = a1.getString("body");
                        Log.i("Head",head);
                        Log.i("Body",body);

                        int id = a1.getInt("id");
                        String id1 = String.valueOf(id);
                        Log.i("id",id1);



                        List_items_placement item =new List_items_placement(head,body,id1);
                        listItems.add(item);
                        //tv1.append(head+"\n" +body+"\n");

                    }
                    adapter = new RecyclerViewAdapterPlacement(listItems,getBaseContext());
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

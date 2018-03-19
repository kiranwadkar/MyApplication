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

public class Commitee_ieee extends AppCompatActivity {
    String ieeeurl;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_commitee_ieee> listItems;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee_ieee);

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

        ieeeurl = url+"/"+"events"+"/"+year+"/"+branch+"/"+"IEEE";
        Log.i("eventurl",ieeeurl);
        loadRecyclerView();
    }

    private void loadRecyclerView() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ieeeurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("events");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject o1 = jsonArray.getJSONObject(i);
                        String head = o1.getString("name");
                        String body = o1.getString("details");
                        Log.i("Head22",head);
                        int p = o1.getInt("price");
                        String price = String.valueOf(p);
                        Log.i("price",price);

                        int id = o1.getInt("id");
                        String id1 = String.valueOf(id);
                        Log.i("id",id1);
                        String contact_name = o1.getString("contact_name");
                        String file_name = o1.getString("file_name");
                        String orig_filename = o1.getString("original_filename");

                        Log.i("Head22",head);
                        Log.i("Body22",body);
                        Log.i("file_name",file_name);
                        Log.i("orig_filename",orig_filename);


                        List_items_commitee_ieee item =new List_items_commitee_ieee(head,body,price,contact_name,id1,file_name,orig_filename);
                        listItems.add(item);

                    }
                    adapter = new RecyclerViewAdapterCommiteeIeee(listItems,getBaseContext());
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

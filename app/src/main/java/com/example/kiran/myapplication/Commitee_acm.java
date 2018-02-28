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

public class Commitee_acm extends AppCompatActivity {
    String server_url="http://192.168.0.103:80/api/events";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<List_items_commitee_acm> listItems;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee_acm);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(this);
        listItems = new ArrayList<>();
        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String year = m.getString("Year","");
        final String branch =m.getString("Branch","");
        server_url = server_url+"/"+year+"/"+branch+"/"+"ACM";
        Log.i("kiran_testing",server_url);
        loadRecyclerView();
    }

    private void loadRecyclerView() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
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

                        Log.i("Head22",head);
                        Log.i("Body22",body);

                        SharedPreferences sharedPreferences = getSharedPreferences("Myevent", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        //editor.putString("Head",head);
                        //editor.putString("Body",body);
                        editor.putString("Price", price);
                        editor.putString("Contact", contact_name);
                        editor.putString("Id",id1);
                        editor.commit();

                        List_items_commitee_acm item =new List_items_commitee_acm(head,body);
                        listItems.add(item);
                    }
                    adapter = new RecyclerViewAdapterCommiteeAcm(listItems,getBaseContext());
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

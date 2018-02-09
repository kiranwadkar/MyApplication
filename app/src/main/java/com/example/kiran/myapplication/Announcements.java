package com.example.kiran.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Announcements extends AppCompatActivity {
   TextView tv1;
    Button parse;

    RequestQueue requestQueue;
    String server_url="http://192.168.0.102:80/api/announcements";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);
        tv1 = (TextView)findViewById(R.id.tv1);
        parse = (Button) findViewById(R.id.btn);

        requestQueue = Volley.newRequestQueue(this);

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        //String name = m.getString("Name","");
        final String year = m.getString("Year","");
        final String branch =m.getString("Branch","");
        final String div = m.getString("Division","");



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
        });






    }

}

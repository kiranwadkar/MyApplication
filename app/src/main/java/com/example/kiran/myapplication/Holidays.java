package com.example.kiran.myapplication;

import android.os.Bundle;
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

public class Holidays extends AppCompatActivity {

    //Button show;
    TextView tv1;
    Button btn;
    String data;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        tv1 = (TextView) findViewById(R.id.tv1);
        btn = (Button) findViewById(R.id.btn);

        requestQueue = Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonparse();
            }
        });
    }
    private void jsonparse(){
        String jsonurl="http://172.16.18.71:80/api/holidays";

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
}

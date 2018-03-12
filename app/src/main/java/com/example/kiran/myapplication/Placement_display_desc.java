package com.example.kiran.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Placement_display_desc extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    Button submit;
    String place_register_url;
    RequestQueue requestQueue;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_display_desc);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);
        tv3 = (TextView) findViewById(R.id.tvid);
        submit = (Button) findViewById(R.id.submit);

        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");
        Log.i("server",url);

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String studid = m.getString("Id","");
        Log.i("studid",studid);





        Bundle bplace = getIntent().getExtras();
        String s1= bplace.getString("1");
        String s2 = bplace.getString("2");
        final String placeid = bplace.getString("3");

        tv1.setText(s1);
        tv2.setText(s2);
        tv3.setText("ID:"+placeid);
        Log.i("placeid",placeid);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place_register_url = url+"/"+"placements_registration"+"/"+placeid+"/"+studid;
                Log.i("Register_place_url",place_register_url);
                register();;
            }
        });

    }

    private void register() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, place_register_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String msg = response.getString("MESSAGE");
                    Log.i("message",msg);
                    Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
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

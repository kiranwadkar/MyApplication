package com.example.kiran.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Announcement_display_desc extends AppCompatActivity {
    TextView tv1,tv2;
    String announcementdispurl;
    RequestQueue requestQueue;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_display_desc);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);


        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");
        Log.i("server",url);

        Bundle bannouncement = getIntent().getExtras();
        // s1= bannouncement.getString("1");
        //String s2 = bannouncement.getString("2");
        final String id = bannouncement.getString("3");


        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        //String name = m.getString("Name","");
        final String year = m.getString("Year","");
        final String branch =m.getString("Branch","");
        final String div = m.getString("Division","");
        //server_url = server_url+"/"+year+"/"+branch+"/"+div;
        announcementdispurl = url+"/"+"announcements"+"/"+year+"/"+branch+"/"+div+"/"+id;
        Log.i("announcement_disp",announcementdispurl);

        Display();
    }

    private void Display() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, announcementdispurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray jsonArray = response.getJSONArray("announcement");
                    JSONObject jsonObject = response.getJSONObject("announcement");

                        String head = jsonObject.getString("head");
                        String body = jsonObject.getString("body");
                        Log.i("Head",head);
                        Log.i("Body",body);
                        tv1.setText(head);
                        tv2.setText(body);




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

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

public class Commitee_ieee_registerevent extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    Button register;
    String reg_server_url;
    RequestQueue requestQueue;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee_ieee_registerevent);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);
        tv3 = (TextView) findViewById(R.id.tvprice);
        tv4 = (TextView) findViewById(R.id.tvcontact);
        register = (Button)findViewById(R.id.register);

        Bundle bb = getIntent().getExtras();
        String head= bb.getString("1");
        String body = bb.getString("2");
        String price = bb.getString("3");
        String contact = bb.getString("4");
        final String idevent = bb.getString("5");


        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");



        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String idstudent = m.getString("Id","");

        Log.i("IDstudent",idstudent);
        Log.i("IDevent",idevent);

        tv1.setText(head);
        tv2.setText(body);
        tv3.setText("Fees:"+price);
        tv4.setText("Contact person:"+contact);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg_server_url = url+"/"+"events_registration"+"/"+idevent+"/"+idstudent;
                //Log.i("kiran_testing",server_url);
                Log.i("Register_url",reg_server_url);
                //Log.i("Server_url","Full url "+final_server_url1);
                parsecode();

            }
        });
    }

    private void parsecode() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, reg_server_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // JSONObject jsonObject = response.getJSONObject("");
                    String msg = response.getString("MESSAGE");
                    Log.i("message",msg);
                    Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(),error.toString(),Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
        requestQueue.add(request);

    }

}

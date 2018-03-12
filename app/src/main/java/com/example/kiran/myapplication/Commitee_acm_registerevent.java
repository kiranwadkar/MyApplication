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

public class Commitee_acm_registerevent extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    Button register;
    String reg_server_url;
    RequestQueue requestQueue;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee_acm_registerevent);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);
        tv3 = (TextView) findViewById(R.id.tvprice);
        tv4 = (TextView) findViewById(R.id.tvcontact);
        tv5 = (TextView)findViewById(R.id.tvid);
        register = (Button)findViewById(R.id.register);

        Bundle bb = getIntent().getExtras();
        String s1= bb.getString("1");
        String s2 = bb.getString("2");

        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");

        Bundle bacm = getIntent().getExtras();
        String head= bacm.getString("1");
        String body = bacm.getString("2");
        String price = bacm.getString("3");
        String contact = bacm.getString("4");
        final String idevent = bacm.getString("5");



        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String idstudent = m.getString("Id","");


        Log.i("IDstudent",idstudent);
        Log.i("IDevent",idevent);


        tv1.setText(head);
        tv2.setText(body);
        tv3.setText("Fees:"+price);
        tv4.setText("Contact person:"+contact);
        tv5.setText("ID:"+idevent);

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

        //events_registration/{event_id}/{student_id}', 'APIsController@registerToEvent');
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, reg_server_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                   // JSONObject jsonObject = response.getJSONObject("");
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

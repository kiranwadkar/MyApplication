package com.example.kiran.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//import static android.os.Build.ID;
public class Dashboard extends AppCompatActivity {

   // ImageView holidays,event,announcement,placement,ia,timetable,feedback;

    CardView cardtt,cardevent,cardia,cardplacement,cardholiday,cardannouncement,cardfeedback;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuprofile:
                Intent iprofile = new Intent(getBaseContext(),User_profile.class);
                startActivity(iprofile);
               
                break;
            case R.id.menulogout:
                SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = m.edit();
                storetoken();
                editor.clear();
                editor.commit();
                finish();
                Intent i100 = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i100);
                break;

            case R.id.menusettings:
                Toast.makeText(getBaseContext(),"Settings is selected",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void storetoken() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");
        Log.i("server",url);
        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        String stud_id = m.getString("Id","");
        Log.i("stud_id",stud_id);
        String savetokenurl = url+"/logout/"+stud_id;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, savetokenurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String msg = response.getString("MESSAGE");
                    Log.i("response_token_msg",msg);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardtt = (CardView)findViewById(R.id.cardtimetable);
        cardevent = (CardView)findViewById(R.id.cardviewevent);
        cardia = (CardView) findViewById(R.id.cardviewia);
        cardplacement = (CardView)findViewById(R.id.cardviewplacement);
        cardholiday = (CardView)findViewById(R.id.cardviewholiday);
        cardannouncement =(CardView)findViewById(R.id.cardviewannouncement);
        cardfeedback = (CardView)findViewById(R.id.cardviewfeedback);



        cardtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),Timetable.class);
                startActivity(i1);
            }
        });

        cardevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getBaseContext(),Commitees.class);
                startActivity(i2);
            }
        });

        cardia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getBaseContext(),IA_timetable.class);
                startActivity(i3);
            }
        });

        cardholiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getBaseContext(),Holidays.class);
                startActivity(i4);
            }
        });

        cardannouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getBaseContext(),Announcements.class);
                startActivity(i5);
            }
        });

        cardfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(getBaseContext(),Feedback.class);
                startActivity(i6);
            }
        });

        cardplacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 =new Intent(getBaseContext(),Placement.class);
                startActivity(i7);
            }
        });


    }
}

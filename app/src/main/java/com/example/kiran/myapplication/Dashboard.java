package com.example.kiran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//import static android.os.Build.ID;
public class Dashboard extends AppCompatActivity {
    TextView tv1;
    ImageView holidays,event,announcement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        holidays = (ImageView) findViewById(R.id.holidays);
        event = (ImageView)findViewById(R.id.event);
        announcement = (ImageView)findViewById(R.id.annoucements);
        tv1 = (TextView)findViewById(R.id.response);


        //SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
      //  String mResponse = m.getString("Response", "");
        //tv1.setText(mResponse);
        //Log.i("test",mResponse);


        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),Commitees.class);
                startActivity(i1);
            }
        });

        holidays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),Holidays.class);
                startActivity(i);
            }
        });

        announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getBaseContext(),Announcements.class);
                startActivity(i2);
            }
        });

    }
}

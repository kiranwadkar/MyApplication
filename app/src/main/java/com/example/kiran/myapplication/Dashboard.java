package com.example.kiran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
//import static android.os.Build.ID;
public class Dashboard extends AppCompatActivity {

    ImageView holidays,event,announcement,placement,ia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        holidays = (ImageView) findViewById(R.id.holidays);
        event = (ImageView)findViewById(R.id.event);
        announcement = (ImageView)findViewById(R.id.annoucements);
        placement = (ImageView)findViewById(R.id.placement);
        ia = (ImageView)findViewById(R.id.ia);



        //SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
      //  String mResponse = m.getString("Response", "");
        //tv1.setText(mResponse);
        //Log.i("test",mResponse);

        ia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getBaseContext(),IA_timetable.class);
                startActivity(i5);
            }
        });
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

        placement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getBaseContext(),Placement.class);
                startActivity(i4);
            }
        });

    }
}

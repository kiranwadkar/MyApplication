package com.example.kiran.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
            case R.id.menulogout:
                SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = m.edit();
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
        /*
        holidays = (ImageView) findViewById(R.id.holidays);
        event = (ImageView)findViewById(R.id.event);
        announcement = (ImageView)findViewById(R.id.annoucements);
        placement = (ImageView)findViewById(R.id.placement);
        ia = (ImageView)findViewById(R.id.ia);
        timetable = (ImageView)findViewById(R.id.timetable);
        feedback = (ImageView)findViewById(R.id.feedback);


        Log.i("dashboard calling","testing");
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

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(getBaseContext(),Timetable.class);
                startActivity(i6);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent i3 = new Intent(getBaseContext(),Feedback.class);
                startActivity(i3);
            }
        });
        */

    }
}

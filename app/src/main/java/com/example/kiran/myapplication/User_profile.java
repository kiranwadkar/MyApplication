package com.example.kiran.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class User_profile extends AppCompatActivity {
    TextView roll,name,email,year,branch,div,sem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        roll = (TextView)findViewById(R.id.rollno);
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        year = (TextView)findViewById(R.id.year);
        branch = (TextView)findViewById(R.id.branch);
        div = (TextView)findViewById(R.id.division);
        sem = (TextView)findViewById(R.id.semester);

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        String sroll = m.getString("Roll","");
        String sname = m.getString("Name","");
        String semail = m.getString("Email","");
        String syear = m.getString("Year","");
        String sbranch =m.getString("Branch","");
        String sdiv = m.getString("Division","");
        String ssem = m.getString("Sem","");

        roll.setText(sroll);
        name.setText(sname);
        email.setText(semail);
        year.setText(syear);
        branch.setText(sbranch);
        div.setText(sdiv);
        sem.setText(ssem);

    }
}

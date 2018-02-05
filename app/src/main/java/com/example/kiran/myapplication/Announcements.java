package com.example.kiran.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Announcements extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        String name = m.getString("Name","");
        String year = m.getString("Year","");
        tv1.setText(name);
        tv2.setText(year);



        //tv1.setText(s);
       // String s= m.getString






    }
}

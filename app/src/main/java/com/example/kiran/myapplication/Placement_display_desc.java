package com.example.kiran.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Placement_display_desc extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_display_desc);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);


        Bundle bb = getIntent().getExtras();
        String s1= bb.getString("1");
        String s2 = bb.getString("2");

        tv1.setText(s1);
        tv2.setText(s2);

    }
}

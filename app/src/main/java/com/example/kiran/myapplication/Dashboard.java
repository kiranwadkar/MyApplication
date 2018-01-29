package com.example.kiran.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    TextView tv1;
    ImageView holidays;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        holidays = (ImageView) findViewById(R.id.holidays);

       // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
      //  String name = preferences.getString("Name", "");
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        tv1.setText(restoredText);

        holidays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),Holidays.class);
                startActivity(i);
            }
        });

    }
}

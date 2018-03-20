package com.example.kiran.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        final Splash_Screen activityReference = this;

        Thread background = new Thread(){
            public void run(){
                try{

                    sleep(5*1000);
                    SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(activityReference);
                    SharedPreferences.Editor editor = m.edit();
                    String s = m.getString("Id","");
                    if(s.equals("")){
                        Intent i11 = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(i11);
                        finish();
                    }
                    else{
                        Intent i12 = new Intent(getBaseContext(),Dashboard.class);
                        startActivity(i12);
                        finish();
                    }
                }
                catch(Exception e){}
            }
        };
        background.start();
    }
}

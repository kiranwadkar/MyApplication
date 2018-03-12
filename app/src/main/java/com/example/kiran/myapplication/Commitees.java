package com.example.kiran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Commitees extends AppCompatActivity {
    ImageView acm,csi,eesa,ieee,iete,itsa,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitees);
        acm = (ImageView) findViewById(R.id.acm);
        csi = (ImageView) findViewById(R.id.csi);
        eesa = (ImageView) findViewById(R.id.eesa);
        ieee = (ImageView) findViewById(R.id.ieee);
        iete = (ImageView) findViewById(R.id.iete);
        itsa = (ImageView) findViewById(R.id.itsa);
        other = (ImageView) findViewById(R.id.other);




        acm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),Commitee_acm.class);
                startActivity(i1);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getBaseContext(),Commitee_other.class);
                startActivity(i2);
            }
        });

        ieee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(getBaseContext(),Commitee_ieee.class);
                startActivity(i3);
            }
        });
    }
}

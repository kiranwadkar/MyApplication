package com.example.kiran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class Commitees extends AppCompatActivity {
    //ImageView acm,csi,eesa,ieee,iete,itsa,other;

    CardView cardacm,cardcsi,carditsa,cardieee,cardiete,cardbmsa,cardother;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitees);

        cardacm = (CardView)findViewById(R.id.cardacm);
        cardcsi = (CardView)findViewById(R.id.cardcsi);
        carditsa = (CardView)findViewById(R.id.carditsa);
        cardieee = (CardView)findViewById(R.id.cardieee);
        cardiete = (CardView) findViewById(R.id.cardiete);
        cardbmsa = (CardView)findViewById(R.id.cardbmsa);
        cardother = (CardView)findViewById(R.id.cardother);

        cardacm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),Commitee_acm.class);
                startActivity(i1);
            }
        });

        cardieee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getBaseContext(),Commitee_ieee.class);
                startActivity(i2);
            }
        });

        cardother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getBaseContext(),Commitee_other.class);
                startActivity(i3);
            }
        });

        /*
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
        */
    }
}

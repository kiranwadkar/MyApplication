package com.example.kiran.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Feedback extends AppCompatActivity {

    RadioGroup rdrgp1,rdrgp2,rdrgp3,rdrgp4,rdrgp5,rdrgp6;

    EditText edsub1,edsub2,edsub3,edsub4,edsub5,edsub6;
    EditText edlect1,edlect2,edlect3,edlect4,edlect5,edlect6;
    EditText edtuto1,edtuto2,edtuto3,edtuto4,edtuto5,edtuto6;
    EditText lect1rating,lect2rating,lect3rating,lect4rating,lect5rating,lect6rating;
    EditText tuto1rating,tuto2rating,tuto3rating,tuto4rating,tuto5rating,tuto6rating;

    EditText cet1,cet2,cet3,cet4,cet5,cet6,cet7,cet8,cet9;

    EditText det1,det2,det3,det4,det5,det6,det7;

    Button submit;
    String section_a,section_b,section_c,section_d;
    String feedback_send;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        requestQueue = Volley.newRequestQueue(this);

        //section A mcq type que
        rdrgp1 = (RadioGroup)findViewById(R.id.rdrgp1);
        String ques1 = ((RadioButton)findViewById(rdrgp1.getCheckedRadioButtonId())).getText().toString();
        rdrgp2 = (RadioGroup)findViewById(R.id.rdrgp2);
        String ques2 = ((RadioButton)findViewById(rdrgp2.getCheckedRadioButtonId())).getText().toString();
        rdrgp3 = (RadioGroup)findViewById(R.id.rdrgp3);
        String ques3 = ((RadioButton)findViewById(rdrgp3.getCheckedRadioButtonId())).getText().toString();
        rdrgp4 = (RadioGroup)findViewById(R.id.rdrgp4);
        String ques4 = ((RadioButton)findViewById(rdrgp4.getCheckedRadioButtonId())).getText().toString();
        rdrgp5 = (RadioGroup)findViewById(R.id.rdrgp5);
        String ques5 = ((RadioButton)findViewById(rdrgp5.getCheckedRadioButtonId())).getText().toString();
        rdrgp6 = (RadioGroup)findViewById(R.id.rdrgp6);
        String ques6 = ((RadioButton)findViewById(rdrgp6.getCheckedRadioButtonId())).getText().toString();

        section_a = ques1+"/"+ques2+"/"+ques3+"/"+ques4+"/"+ques5+"/"+ques6;
        Log.i("section_a",section_a);


        //section 2 subject teacher grade
        edsub1 = (EditText)findViewById(R.id.edsub1);
        edsub2 = (EditText)findViewById(R.id.edsub2);
        edsub3 = (EditText)findViewById(R.id.edsub3);
        edsub4 = (EditText)findViewById(R.id.edsub4);
        edsub5 = (EditText)findViewById(R.id.edsub5);
        edsub6 = (EditText)findViewById(R.id.edsub6);

        String sedsub1= edsub1.getText().toString();
        String sedsub2= edsub2.getText().toString();
        String sedsub3= edsub3.getText().toString();
        String sedsub4= edsub4.getText().toString();
        String sedsub5= edsub5.getText().toString();
        String sedsub6= edsub6.getText().toString();

        edlect1 = (EditText)findViewById(R.id.edlect1);
        edlect2 = (EditText)findViewById(R.id.edlect2);
        edlect3 = (EditText)findViewById(R.id.edlect3);
        edlect4 = (EditText)findViewById(R.id.edlect4);
        edlect5 = (EditText)findViewById(R.id.edlect5);
        edlect6 = (EditText)findViewById(R.id.edlect6);

        String sedlect1 = edlect1.getText().toString();
        String sedlect2 = edlect2.getText().toString();
        String sedlect3 = edlect3.getText().toString();
        String sedlect4 = edlect4.getText().toString();
        String sedlect5 = edlect5.getText().toString();
        String sedlect6 = edlect6.getText().toString();


        edtuto1 = (EditText)findViewById(R.id.edtuto1);
        edtuto2 = (EditText)findViewById(R.id.edtuto2);
        edtuto3 = (EditText)findViewById(R.id.edtuto3);
        edtuto4 = (EditText)findViewById(R.id.edtuto4);
        edtuto5 = (EditText)findViewById(R.id.edtuto5);
        edtuto6 = (EditText)findViewById(R.id.edtuto6);

        String sedtuto1 = edtuto1.getText().toString();
        String sedtuto2 = edtuto2.getText().toString();
        String sedtuto3 = edtuto3.getText().toString();
        String sedtuto4 = edtuto4.getText().toString();
        String sedtuto5 = edtuto5.getText().toString();
        String sedtuto6 = edtuto6.getText().toString();

        lect1rating = (EditText)findViewById(R.id.lect1rating);
        lect2rating = (EditText)findViewById(R.id.lect2rating);
        lect3rating = (EditText)findViewById(R.id.lect3rating);
        lect4rating = (EditText)findViewById(R.id.lect4rating);
        lect5rating = (EditText)findViewById(R.id.lect5rating);
        lect6rating = (EditText)findViewById(R.id.lect6rating);

        String slect1rating = lect1rating.getText().toString();
        String slect2rating = lect2rating.getText().toString();
        String slect3rating = lect3rating.getText().toString();
        String slect4rating = lect4rating.getText().toString();
        String slect5rating = lect5rating.getText().toString();
        String slect6rating = lect6rating.getText().toString();

        tuto1rating = (EditText)findViewById(R.id.tuto1rating);
        tuto2rating = (EditText)findViewById(R.id.tuto2rating);
        tuto3rating = (EditText)findViewById(R.id.tuto3rating);
        tuto4rating = (EditText)findViewById(R.id.tuto4rating);
        tuto5rating = (EditText)findViewById(R.id.tuto5rating);
        tuto6rating = (EditText)findViewById(R.id.tuto6rating);

        String stuto1rating = tuto1rating.getText().toString();
        String stuto2rating = tuto2rating.getText().toString();
        String stuto3rating = tuto3rating.getText().toString();
        String stuto4rating = tuto4rating.getText().toString();
        String stuto5rating = tuto5rating.getText().toString();
        String stuto6rating = tuto6rating.getText().toString();
        //section_b =


        //section c
        cet1 = (EditText)findViewById(R.id.cet1);
        cet2 = (EditText)findViewById(R.id.cet2);
        cet3 = (EditText)findViewById(R.id.cet3);
        cet4 = (EditText)findViewById(R.id.cet4);
        cet5 = (EditText)findViewById(R.id.cet5);
        cet6 = (EditText)findViewById(R.id.cet6);
        cet7 = (EditText)findViewById(R.id.cet7);
        cet8 = (EditText)findViewById(R.id.cet8);
        cet9 = (EditText)findViewById(R.id.cet9);

        String scet1 = cet1.getText().toString();
        String scet2 = cet2.getText().toString();
        String scet3 = cet3.getText().toString();
        String scet4 = cet4.getText().toString();
        String scet5 = cet5.getText().toString();
        String scet6 = cet6.getText().toString();
        String scet7 = cet7.getText().toString();
        String scet8 = cet8.getText().toString();
        String scet9 = cet9.getText().toString();
        section_c = scet1+"/"+scet2+"/"+scet3+"/"+scet4+"/"+scet5+"/"+scet6+"/"+scet7+"/"+scet8+"/"+scet9;
        Log.i("section_c",section_c);


        //section d
        det1 = (EditText)findViewById(R.id.det1);
        det2 = (EditText)findViewById(R.id.det2);
        det3 = (EditText)findViewById(R.id.det3);
        det4 = (EditText)findViewById(R.id.det4);
        det5 = (EditText)findViewById(R.id.det5);
        det6 = (EditText)findViewById(R.id.det6);
        det7 = (EditText)findViewById(R.id.det7);

        String sdet1 = det1.getText().toString();
        String sdet2 = det2.getText().toString();
        String sdet3 = det3.getText().toString();
        String sdet4 = det4.getText().toString();
        String sdet5 = det5.getText().toString();
        String sdet6 = det6.getText().toString();
        String sdet7 = det7.getText().toString();
        section_d = sdet1+"/"+sdet2+"/"+sdet3+"/"+sdet4+"/"+sdet5+"/"+sdet6+"/"+sdet7;
        Log.i("section_d",section_d);

        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        String url = s.getString("Server","");

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String student_id =m.getString("Id","");
        final String sem =m.getString("Sem","");
        final String branch =m.getString("Branch","");
        final String division =m.getString("Division","");



        feedback_send = url+"/"+student_id+"/"+sem+"/"+division+"/"+branch+"/"+section_a+"/"+section_b+"/"+section_c+"/"+section_d;

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gofeedback();
            }

            private void gofeedback() {
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, feedback_send, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                requestQueue.add(request);

            }
        });
    }
}

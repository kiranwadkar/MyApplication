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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Feedback extends AppCompatActivity {

    RadioGroup rdrgp1, rdrgp2, rdrgp3, rdrgp4, rdrgp5, rdrgp6;

    EditText edsub1, edsub2, edsub3, edsub4, edsub5, edsub6;
    EditText edlect1, edlect2, edlect3, edlect4, edlect5, edlect6;
    EditText edtuto1, edtuto2, edtuto3, edtuto4, edtuto5, edtuto6;
    EditText lect1rating, lect2rating, lect3rating, lect4rating, lect5rating, lect6rating;
    EditText tuto1rating, tuto2rating, tuto3rating, tuto4rating, tuto5rating, tuto6rating;

    EditText cet1, cet2, cet3, cet4, cet5, cet6, cet7, cet8, cet9;

    EditText det1, det2, det3, det4, det5, det6, det7, det8;

    Button submit;
    String section_a, section_b, section_c, section_d;
    String feedback_send;
    RequestQueue requestQueue;

    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        requestQueue = Volley.newRequestQueue(this);
/*
        rdrgp1=(RadioGroup)findViewById(R.id.rdrgp1);
        rdrgp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                String text = checked1.getText().toString();
                Toast.makeText(getBaseContext(),text,Toast.LENGTH_LONG).show();
            }
        });

*/
        final String ques1 = "1";
        final String ques2 = "2";
        final String ques3 = "3";
        final String ques4 = "4";
        final String ques5 = "5";
        final String ques6 = "6";

        //section 2 subject teacher grade
        edsub1 = (EditText) findViewById(R.id.edsub1);
        edsub2 = (EditText) findViewById(R.id.edsub2);
        edsub3 = (EditText) findViewById(R.id.edsub3);
        edsub4 = (EditText) findViewById(R.id.edsub4);
        edsub5 = (EditText) findViewById(R.id.edsub5);
        edsub6 = (EditText) findViewById(R.id.edsub6);

        final String subject1 = edsub1.getText().toString();
        final String subject2 = edsub2.getText().toString();
        final String subject3 = edsub3.getText().toString();
        final String subject4 = edsub4.getText().toString();
        final String subject5 = edsub5.getText().toString();
        final String subject6 = edsub6.getText().toString();

        edlect1 = (EditText) findViewById(R.id.edlect1);
        edlect2 = (EditText) findViewById(R.id.edlect2);
        edlect3 = (EditText) findViewById(R.id.edlect3);
        edlect4 = (EditText) findViewById(R.id.edlect4);
        edlect5 = (EditText) findViewById(R.id.edlect5);
        edlect6 = (EditText) findViewById(R.id.edlect6);

        final String lecture1 = edlect1.getText().toString();
        final String lecture2 = edlect2.getText().toString();
        final String lecture3 = edlect3.getText().toString();
        final String lecture4 = edlect4.getText().toString();
        final String lecture5 = edlect5.getText().toString();
        final String lecture6 = edlect6.getText().toString();


        edtuto1 = (EditText) findViewById(R.id.edtuto1);
        edtuto2 = (EditText) findViewById(R.id.edtuto2);
        edtuto3 = (EditText) findViewById(R.id.edtuto3);
        edtuto4 = (EditText) findViewById(R.id.edtuto4);
        edtuto5 = (EditText) findViewById(R.id.edtuto5);
        edtuto6 = (EditText) findViewById(R.id.edtuto6);

        final String practical1 = edtuto1.getText().toString();
        final String practical2 = edtuto2.getText().toString();
        final String practical3 = edtuto3.getText().toString();
        final String practical4 = edtuto4.getText().toString();
        final String practical5 = edtuto5.getText().toString();
        final String practical6 = edtuto6.getText().toString();

        lect1rating = (EditText) findViewById(R.id.lect1rating);
        lect2rating = (EditText) findViewById(R.id.lect2rating);
        lect3rating = (EditText) findViewById(R.id.lect3rating);
        lect4rating = (EditText) findViewById(R.id.lect4rating);
        lect5rating = (EditText) findViewById(R.id.lect5rating);
        lect6rating = (EditText) findViewById(R.id.lect6rating);

        final String lgrade1 = lect1rating.getText().toString();
        final String lgrade2 = lect2rating.getText().toString();
        final String lgrade3 = lect3rating.getText().toString();
        final String lgrade4 = lect4rating.getText().toString();
        final String lgrade5 = lect5rating.getText().toString();
        final String lgrade6 = lect6rating.getText().toString();

        tuto1rating = (EditText) findViewById(R.id.tuto1rating);
        tuto2rating = (EditText) findViewById(R.id.tuto2rating);
        tuto3rating = (EditText) findViewById(R.id.tuto3rating);
        tuto4rating = (EditText) findViewById(R.id.tuto4rating);
        tuto5rating = (EditText) findViewById(R.id.tuto5rating);
        tuto6rating = (EditText) findViewById(R.id.tuto6rating);

        final String pgrade1 = tuto1rating.getText().toString();
        final String pgrade2 = tuto2rating.getText().toString();
        final String pgrade3 = tuto3rating.getText().toString();
        final String pgrade4 = tuto4rating.getText().toString();
        final String pgrade5 = tuto5rating.getText().toString();
        final String pgrade6 = tuto6rating.getText().toString();
        //section_b =


        //section c
        cet1 = (EditText) findViewById(R.id.cet1);
        cet2 = (EditText) findViewById(R.id.cet2);
        cet3 = (EditText) findViewById(R.id.cet3);
        cet4 = (EditText) findViewById(R.id.cet4);
        cet5 = (EditText) findViewById(R.id.cet5);
        cet6 = (EditText) findViewById(R.id.cet6);
        cet7 = (EditText) findViewById(R.id.cet7);
        cet8 = (EditText) findViewById(R.id.cet8);
        cet9 = (EditText) findViewById(R.id.cet9);

        final String completeness1 = cet1.getText().toString();
        final String completeness2 = cet2.getText().toString();
        final String systematic_approach1 = cet3.getText().toString();
        final String systematic_approach2 = cet4.getText().toString();
        final String comprehend1 = cet5.getText().toString();
        final String comprehend2 = cet6.getText().toString();
        final String relevance1 = cet7.getText().toString();
        final String relevance2 = cet8.getText().toString();
        final String suggestion = cet9.getText().toString();
        //section_c = scet1+"/"+scet2+"/"+scet3+"/"+scet4+"/"+scet5+"/"+scet6+"/"+scet7+"/"+scet8+"/"+scet9;
        //Log.i("section_c",section_c);


        //section d
        det1 = (EditText) findViewById(R.id.det1);
        det2 = (EditText) findViewById(R.id.det2);
        det3 = (EditText) findViewById(R.id.det3);
        det4 = (EditText) findViewById(R.id.det4);
        det5 = (EditText) findViewById(R.id.det5);
        det6 = (EditText) findViewById(R.id.det6);
        det7 = (EditText) findViewById(R.id.det7);
        det8 = (EditText) findViewById(R.id.det8);

        final String administrative_office = det1.getText().toString();
        final String examination_cell = det2.getText().toString();
        final String institute_library = det3.getText().toString();
        final String department_laboratory = det4.getText().toString();
        final String classrooms = det5.getText().toString();
        final String water_facility = det6.getText().toString();
        final String restroom = det7.getText().toString();
        final String canteen = det8.getText().toString();
        //section_d = administrative_office+"/"+examination_cell+"/"+institute_library+"/"+department_laboratory+"/"+classrooms+"/"+water_facility+"/"+restroom+"/"+canteen;
        //Log.i("section_d",section_d);

        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        final String url = s.getString("Server", "");

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String student_id = m.getString("Id", "");
        final String sem = m.getString("Sem", "");
        final String branch = m.getString("Branch", "");
        final String division = m.getString("Division", "");


        feedback_send = url + "/" + "feedback";
        Log.i("feedback_url", feedback_send);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback();
            }

            private void feedback() {

                try {
                    JSONObject params = new JSONObject();
                    params.put("student_id",student_id);
                    params.put("sem",sem);
                    params.put("division",division);
                    params.put("branch",branch);
                    params.put("subject1",subject1);
                    params.put("lecture1",lecture1);
                    params.put("lgrade1",lgrade1);
                    params.put("practical1",practical1);
                    params.put("pgrade1",pgrade1);

                    params.put("subject",subject2);
                    params.put("lecture2",lecture2);
                    params.put("lgrade2",lgrade2);
                    params.put("practical2",practical2);
                    params.put("pgrade2",pgrade2);

                    params.put("subject3",subject3);
                    params.put("lecture3",lecture3);
                    params.put("lgrade3",lgrade3);
                    params.put("practical3",practical3);
                    params.put("pgrade3",pgrade3);

                    params.put("subject4",subject4);
                    params.put("lecture4",lecture4);
                    params.put("lgrade4",lgrade4);
                    params.put("practical4",practical4);
                    params.put("pgrade4",pgrade4);

                    params.put("subject5",subject5);
                    params.put("lecture5",lecture5);
                    params.put("lgrade5",lgrade5);
                    params.put("practical5",practical5);
                    params.put("pgrade5",pgrade5);

                    params.put("subject6",subject6);
                    params.put("lecture6",lecture6);
                    params.put("lgrade6",lgrade6);
                    params.put("practical6",practical6);
                    params.put("pgrade6",pgrade6);

                    params.put("administrative_office",administrative_office);
                    params.put("examination_cell",examination_cell);
                    params.put("institute_library",institute_library);
                    params.put("department_laboratory",department_laboratory);
                    params.put("classrooms",classrooms);
                    params.put("water_facility",water_facility);
                    params.put("restroom",restroom);
                    params.put("canteen",canteen);

                    params.put("suggestion",suggestion);

                    params.put("completeness1",completeness1);
                    params.put("systematic_approach1",systematic_approach1);
                    params.put("comprehend1",comprehend1);
                    params.put("relevance1",relevance1);
                    params.put("completeness2",completeness2);
                    params.put("systematic_approach2",systematic_approach2);
                    params.put("comprehend2",comprehend2);
                    params.put("relevance2",relevance2);

                    params.put("ques1",ques1);
                    params.put("ques2",ques2);
                    params.put("ques3",ques3);
                    params.put("ques4",ques4);
                    params.put("ques5",ques5);
                    params.put("ques6",ques6);

                    final String reqBody = params.toString();

                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, feedback_send,null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                String msg = response.getString("MESSAGE");
                                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }){

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset?utf-8";
                        }
                    };
                    requestQueue.add(request);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

}
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    String ques1,ques2,ques3,ques4,ques5,ques6;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        requestQueue = Volley.newRequestQueue(this);


        rdrgp1=(RadioGroup)findViewById(R.id.rdrgp1);
        rdrgp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques1 = String.valueOf(pos+1);
               // Toast.makeText(getBaseContext(),ques1,Toast.LENGTH_LONG).show();
            }
        });

        rdrgp2=(RadioGroup)findViewById(R.id.rdrgp2);
        rdrgp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques2 = String.valueOf(pos+1);
               // Toast.makeText(getBaseContext(),ques2,Toast.LENGTH_LONG).show();
            }
        });

        rdrgp3=(RadioGroup)findViewById(R.id.rdrgp3);
        rdrgp3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques3 = String.valueOf(pos+1);
               // Toast.makeText(getBaseContext(),ques3,Toast.LENGTH_LONG).show();
            }
        });

        rdrgp4=(RadioGroup)findViewById(R.id.rdrgp4);
        rdrgp4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques4 = String.valueOf(pos+1);
               // Toast.makeText(getBaseContext(),ques4,Toast.LENGTH_LONG).show();
            }
        });

        rdrgp5=(RadioGroup)findViewById(R.id.rdrgp5);
        rdrgp5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques5 = String.valueOf(pos+1);
              //  Toast.makeText(getBaseContext(),ques5,Toast.LENGTH_LONG).show();
            }
        });

        rdrgp6=(RadioGroup)findViewById(R.id.rdrgp6);
        rdrgp6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checked1 = (RadioButton)findViewById(i);
                int pos = radioGroup.indexOfChild(checked1);
                ques6 = String.valueOf(pos+1);
                //Toast.makeText(getBaseContext(),ques6,Toast.LENGTH_LONG).show();
            }
        });



        //section 2 subject teacher grade
        edsub1 = (EditText) findViewById(R.id.edsub1);
        edsub2 = (EditText) findViewById(R.id.edsub2);
        edsub3 = (EditText) findViewById(R.id.edsub3);
        edsub4 = (EditText) findViewById(R.id.edsub4);
        edsub5 = (EditText) findViewById(R.id.edsub5);
        edsub6 = (EditText) findViewById(R.id.edsub6);



        edlect1 = (EditText) findViewById(R.id.edlect1);
        edlect2 = (EditText) findViewById(R.id.edlect2);
        edlect3 = (EditText) findViewById(R.id.edlect3);
        edlect4 = (EditText) findViewById(R.id.edlect4);
        edlect5 = (EditText) findViewById(R.id.edlect5);
        edlect6 = (EditText) findViewById(R.id.edlect6);




        edtuto1 = (EditText) findViewById(R.id.edtuto1);
        edtuto2 = (EditText) findViewById(R.id.edtuto2);
        edtuto3 = (EditText) findViewById(R.id.edtuto3);
        edtuto4 = (EditText) findViewById(R.id.edtuto4);
        edtuto5 = (EditText) findViewById(R.id.edtuto5);
        edtuto6 = (EditText) findViewById(R.id.edtuto6);



        lect1rating = (EditText) findViewById(R.id.lect1rating);
        lect2rating = (EditText) findViewById(R.id.lect2rating);
        lect3rating = (EditText) findViewById(R.id.lect3rating);
        lect4rating = (EditText) findViewById(R.id.lect4rating);
        lect5rating = (EditText) findViewById(R.id.lect5rating);
        lect6rating = (EditText) findViewById(R.id.lect6rating);



        tuto1rating = (EditText) findViewById(R.id.tuto1rating);
        tuto2rating = (EditText) findViewById(R.id.tuto2rating);
        tuto3rating = (EditText) findViewById(R.id.tuto3rating);
        tuto4rating = (EditText) findViewById(R.id.tuto4rating);
        tuto5rating = (EditText) findViewById(R.id.tuto5rating);
        tuto6rating = (EditText) findViewById(R.id.tuto6rating);



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


        //section d
        det1 = (EditText) findViewById(R.id.det1);
        det2 = (EditText) findViewById(R.id.det2);
        det3 = (EditText) findViewById(R.id.det3);
        det4 = (EditText) findViewById(R.id.det4);
        det5 = (EditText) findViewById(R.id.det5);
        det6 = (EditText) findViewById(R.id.det6);
        det7 = (EditText) findViewById(R.id.det7);
        det8 = (EditText) findViewById(R.id.det8);


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
                    params.put("subject1",edsub1.getText().toString());
                    params.put("lecture1",edlect1.getText().toString());
                    params.put("lgrade1",lect1rating.getText().toString());
                    params.put("practical1",edtuto1.getText().toString());
                    params.put("pgrade1",tuto1rating.getText().toString());

                    params.put("subject2",edsub2.getText().toString());
                    params.put("lecture2",edlect2.getText().toString());
                    params.put("lgrade2",lect2rating.getText().toString());
                    params.put("practical2",edtuto2.getText().toString());
                    params.put("pgrade2",tuto2rating.getText().toString());

                    params.put("subject3",edsub3.getText().toString());
                    params.put("lecture3",edlect3.getText().toString());
                    params.put("lgrade3",lect3rating.getText().toString());
                    params.put("practical3",edtuto3.getText().toString());
                    params.put("pgrade3",tuto3rating.getText().toString());

                    params.put("subject4",edsub4.getText().toString());
                    params.put("lecture4",edlect4.getText().toString());
                    params.put("lgrade4",lect4rating.getText().toString());
                    params.put("practical4",edtuto4.getText().toString());
                    params.put("pgrade4",tuto4rating.getText().toString());

                    params.put("subject5",edsub5.getText().toString());
                    params.put("lecture5",edlect5.getText().toString());
                    params.put("lgrade5",lect5rating.getText().toString());
                    params.put("practical5",edtuto5.getText().toString());
                    params.put("pgrade5",tuto5rating.getText().toString());

                    params.put("subject6",edsub6.getText().toString());
                    params.put("lecture6",edlect6.getText().toString());
                    params.put("lgrade6",lect6rating.getText().toString());
                    params.put("practical6",edtuto6.getText().toString());
                    params.put("pgrade6",tuto6rating.getText().toString());

                    params.put("administrative_office",det1.getText().toString());
                    params.put("examination_cell",det2.getText().toString());
                    params.put("institute_library",det3.getText().toString());
                    params.put("department_laboratory",det4.getText().toString());
                    params.put("classrooms",det5.getText().toString());
                    params.put("water_facility",det6.getText().toString());
                    params.put("restroom",det7.getText().toString());
                    params.put("canteen",det8.getText().toString());

                    params.put("suggestion",cet9.getText().toString());

                    params.put("completeness1",cet1.getText().toString());
                    params.put("systematic_approach1",cet3.getText().toString());
                    params.put("comprehend1",cet5.getText().toString());
                    params.put("relevance1",cet7.getText().toString());
                    params.put("completeness2",cet2.getText().toString());
                    params.put("systematic_approach2",cet4.getText().toString());
                    params.put("comprehend2",cet6.getText().toString());
                    params.put("relevance2",cet8.getText().toString());

                    params.put("ques1",ques1);
                    params.put("ques2",ques2);
                    params.put("ques3",ques3);
                    params.put("ques4",ques4);
                    params.put("ques5",ques5);
                    params.put("ques6",ques6);
                    final String reqBody = params.toString();

                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, feedback_send,new JSONObject(reqBody), new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                //JSONObject json = new JSONObject("MESSAGE");

                               //JSONArray jsarr = json.toJSONArray();
                                String msg = response.getString("MESSAGE");
                                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("Error_coming",error.toString());
                            if(error.toString().contains("You already submitted your both feedbacks for this sem.")) {
                                Toast.makeText(getBaseContext(),"You already submitted your both feedbacks for this sem." , Toast.LENGTH_LONG).show();
                            }
                        }
                    }){
                        /*
                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset?utf-8";
                        }
                        */

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();

                            headers.put("Content-Type", "application/json; charset=utf-8");
                            return headers;
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
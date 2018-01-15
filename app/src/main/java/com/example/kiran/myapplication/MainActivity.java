package com.example.kiran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    RequestQueue requestQueue;
    String server_url="http://192.168.1.103/select.php";
   // AlertDialog.Builder builder;
   // String susername;
  //  String spassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button login = (Button)findViewById(R.id.login);
        //builder = new AlertDialog.Builder(MainActivity.this);
       // requestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String  susername = username.getText().toString();
               String spassword = password.getText().toString();
                if((susername).equals("admin")&&(spassword).equals("admin123")){
                    Toast.makeText(getBaseContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(),"Please enter correct creaditials",Toast.LENGTH_SHORT).show();
                }
/*
                susername = username.getText().toString();
                spassword = password.getText().toString();

                if(isValidEmail(susername)){
                    if(isValidPassword(spassword)){
                        validate();//change kelay
                        // Toast.makeText(getBaseContext(),"valid",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        password.setError("Password should contain 7 characters");
                    }

                }
                else{
                    username.setError("Invalid Email");
                }*/
/*
                JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.104/select.php",

                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                JSONArray jsonArray = response.getJSONArray()
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                String strusername = String.valueOf(username.getText());
                String strpassword = String.valueOf(password.getText());

*/
            }

        });
    }

}


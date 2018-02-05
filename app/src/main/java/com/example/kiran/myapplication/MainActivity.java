package com.example.kiran.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    Button login;
    RequestQueue requestQueue;
    String server_url="http://192.168.0.101:80/api/login";
    AlertDialog.Builder builder;
    String  semail;
    String spassword;
   // public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText email = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button login = (Button)findViewById(R.id.login);
        builder = new AlertDialog.Builder(MainActivity.this);
        requestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




               semail = email.getText().toString();
               spassword = password.getText().toString();

                if(isValidEmail(semail)){
                    if(isValidPassword(spassword)){
                        validate();//change kelay
                        // Toast.makeText(getBaseContext(),"valid",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        password.setError("Password should atleast 5 characters");
                    }

                }
                else{
                    email.setError("Invalid Email");
                }


/*
                if((susername).equals("admin")&&(spassword).equals("admin123")){
                    Toast.makeText(getBaseContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(),"Please enter correct creaditials",Toast.LENGTH_SHORT).show();
                }
*/

            }

            private void validate() {
                server_url = server_url+"/"+semail+"/"+spassword;
                Log.i("Server url","Full url "+server_url);

                JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.GET,server_url,null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{

                            JSONObject jsonObject2 = response.getJSONObject("Profile");
                            String name = jsonObject2.getString("name");
                            String roll = jsonObject2.getString("roll");
                            String email1 = jsonObject2.getString("email");
                            String branch = jsonObject2.getString("branch");
                            String year = jsonObject2.getString("year");
                            String division = jsonObject2.getString("division");

                            SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                            SharedPreferences.Editor editor = m.edit();
                            editor.putString("Name",name);
                            editor.putString("Roll",roll);
                            editor.putString("Email",email1);
                            editor.putString("Branch",branch);
                            editor.putString("Year",year);
                            editor.putString("Division",division);
                            editor.commit();

                           // Log.i("Name",name);
                           /* builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    email.setText("");
                                    password.setText("");
                                }
                            });*/
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            String s = response.getString("MESSAGE");
                            Log.i("msg",s);
                            if(s.contains("success")){
                                //contains("success")
                                email.setText("");
                                password.setText("");
                                Intent i11 = new Intent(getBaseContext(),Dashboard.class);
                                startActivity(i11);


                            }
                            else{
                                Log.i("Invalid","Testing");
                                Toast.makeText(getBaseContext(),"Invalid Input",Toast.LENGTH_SHORT).show();;
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                requestQueue.add(jsonObject);






                /*
                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("server responses");
                        builder.setMessage("Responses:" + response);

                        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                        SharedPreferences.Editor editor = m.edit();
                        //Gson gson = new Gson();
                        //String json = gson.toJson(response);

                        //editor.putString("MyObject",json);

                        //String json = gson.toJson(response);
                        //editor.putString("Response", "");
                        editor.commit();



                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                email.setText("");
                                password.setText("");
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        if(response.contains("success")){
                            Intent i11 = new Intent(getBaseContext(),Dashboard.class);
                            startActivity(i11);


                        }
                        else{
                            // response.setShouldCache(false);
                            Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();

                        params.put("email",semail);
                        params.put("password",spassword);
                        return params;
                    }

                };

                // RequestQueue queue;
                //queue = MySingleton.getmInstance(this.getApplicationContext()).getRequestQueue();
                //RequestQueue requestQueue = Volley.newRequestQueue(this);
                // requestQueue.add(stringRequest);
                //queue.getCache().clear();
                //stringRequest.setShouldCache(false);
                //requestQueue.getCache().clear();
                //queue.add(stringRequest);
                //MySingleton.getmInstance(getBaseContext()).addToRequestQueue(stringRequest);
                requestQueue.add(stringRequest);
                 */
            }


            private boolean isValidPassword(String pass) {
                if (pass != null && pass.length() > 5) {
                    return true;
                }
                return false;
            }

            private boolean isValidEmail(String semail) {
                String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                Matcher matcher = pattern.matcher(semail);
                return matcher.matches();
            }

        });

    }

}


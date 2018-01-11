package com.example.kiran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        Button login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strusername = String.valueOf(username.getText());
                String strpassword = String.valueOf(password.getText());
                if((strusername).equals("admin")&&(strpassword).equals("admin123")){
                    Toast.makeText(getBaseContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(),"Please enter correct creaditials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


package com.example.kiran.myapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Commitee_other_registerevent extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    Button register,attachments;
    String reg_server_url;
    RequestQueue requestQueue;
    String url;
    String filenm,origfilenm,idevent;
    DownloadManager downloadManager;
    Uri uri;
    URL downurl;
    ArrayList<Long> list = new ArrayList<>();
    long refid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commitee_other_registerevent);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);
        tv3 = (TextView) findViewById(R.id.tvprice);
        tv4 = (TextView) findViewById(R.id.tvcontact);
        register = (Button)findViewById(R.id.register);
        tv5 = (TextView)findViewById(R.id.tvid);
        attachments = (Button)findViewById(R.id.attachment);
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);


        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");

        Bundle bother = getIntent().getExtras();
        String head= bother.getString("1");
        String body = bother.getString("2");
        String price = bother.getString("3");
        String contact = bother.getString("4");
        idevent = bother.getString("5");
        filenm = bother.getString("6");
        origfilenm = bother.getString("7");

        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        final String idstudent = m.getString("Id","");


        Log.i("IDstudent",idstudent);
        Log.i("IDevent",idevent);


        tv1.setText(head);
        tv2.setText(body);
        tv3.setText("Fees:"+price);
        tv4.setText("Contact person:"+contact);
        tv5.setText("id"+idevent);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg_server_url = url+"/"+"events_registration"+"/"+idevent+"/"+idstudent;
                //Log.i("kiran_testing",server_url);
                Log.i("Register_url",reg_server_url);
                //Log.i("Server_url","Full url "+final_server_url1);
                parsecode();

            }
        });

        attachments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download_attachments();
            }
        });

    }

    private void download_attachments() {
        String []items = filenm.split(",");
        int noofitems = items.length;
        String []ogfilenm = origfilenm.split(",");

        for(int i=0;i<noofitems;i++){
            // String []ogfilenm = original_filename.split(",");
            String download_url = url+"/"+"events_donwload"+"/"+"download"+"/"+idevent+"/"+items[i];
            Log.i("download_url",download_url);
            try {
                downurl = new URL(download_url);
                uri = Uri.parse(downurl.toURI().toString());
                DownloadManager.Request request1 = new DownloadManager.Request(uri);
                request1.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request1.setAllowedOverRoaming(false);
                request1.setTitle("Downloading " + items);
                request1.setDescription("Downloading " +ogfilenm[i]);
                request1.setVisibleInDownloadsUi(true);
                request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/vbuddy/" +"/event/" +"/" + ogfilenm[i]);
                long refid = downloadManager.enqueue(request1);

                // add the refid into an arraylist

                list.add(refid);



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        }

    }

    private void parsecode() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, reg_server_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // JSONObject jsonObject = response.getJSONObject("");
                    String msg = response.getString("MESSAGE");
                    Log.i("message",msg);
                    Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);

    }

}

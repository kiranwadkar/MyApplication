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

public class Announcement_display_desc extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    String announcementdispurl;
    RequestQueue requestQueue;
    String url;
    Button download;
    DownloadManager downloadManager;
    String year,branch,div;
    Uri uri;
    URL downurl;
    ArrayList<Long> list = new ArrayList<>();
    long refid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_display_desc);
        requestQueue = Volley.newRequestQueue(this);
        tv1 = (TextView) findViewById(R.id.tvhead);
        tv2 = (TextView) findViewById(R.id.tvbody);
        tv3 = (TextView)findViewById(R.id.tvissue);
        download =(Button)findViewById(R.id.download);
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);



        SharedPreferences s = getSharedPreferences("Myserver", Context.MODE_PRIVATE);
        url = s.getString("Server","");
        Log.i("server",url);

        Bundle bannouncement = getIntent().getExtras();
        // s1= bannouncement.getString("1");
        //String s2 = bannouncement.getString("2");
        final String id = bannouncement.getString("3");


        SharedPreferences m = PreferenceManager.getDefaultSharedPreferences(this);
        //String name = m.getString("Name","");
         year = m.getString("Year","");
        branch =m.getString("Branch","");
         div = m.getString("Division","");
        //server_url = server_url+"/"+year+"/"+branch+"/"+div;
        announcementdispurl = url+"/"+"announcements"+"/"+year+"/"+branch+"/"+div+"/"+id;
        Log.i("announcement_disp",announcementdispurl);

        Display();

    }



    private void Display() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, announcementdispurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray jsonArray = response.getJSONArray("announcement");
                    JSONObject jsonObject = response.getJSONObject("announcement");

                        String head = jsonObject.getString("head");
                        String body = jsonObject.getString("body");
                        String issue = jsonObject.getString("issued_by");

                        final String file_name = jsonObject.getString("file_name");
                       final String original_filename = jsonObject.getString("original_filename");
                        final String fid = jsonObject.getString("id");

                        Log.i("Head",head);
                        Log.i("Body",body);
                        Log.i("issue",issue);
                        Log.i("file_name",file_name);
                        Log.i("original_filename",original_filename);
                        Log.i("id",fid);
                        tv1.setText(head);
                        tv2.setText(body);
                        //tv3.setText(issue);

                        JSONObject jsonobj2 = jsonObject.getJSONObject("user");
                        String name = jsonobj2.getString("name");
                        tv3.setText(name);
                        Log.i("Name",name);

                    download.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //comma ne separate karaychay file la
                            String []items = file_name.split(",");
                            int noofitems = items.length;
                           String []ogfilenm = original_filename.split(",");

                            for(int i=0;i<noofitems;i++){
                               // String []ogfilenm = original_filename.split(",");
                                String download_url = url+"/"+"announcements_donwload"+"/"+"download"+"/"+fid+"/"+items[i];
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
                                    request1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/vbuddy/" + "/" + ogfilenm[i]);

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
                    });


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

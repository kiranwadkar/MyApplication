package com.example.kiran.myapplication;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{
    private static final String TAG = "MyFirebaseInsIDService";



    public void getRefreshtoken() {
        //get updated token
        String refreshtoken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"refresh token:"+refreshtoken);

    }
}


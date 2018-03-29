package com.example.kiran.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Kiran on 28-03-2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    private static final String TAG ="MyFirebaseMsgService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"FROM:"+remoteMessage.getFrom());
        //check if the message contain
        if(remoteMessage.getData().size()>0){
            Log.d(TAG,"Message Data"+remoteMessage.getData());
        }
        //check if msg contains notification
        if(remoteMessage.getNotification()!=null){
            Log.d(TAG,"Message Body"+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }
    }


    private void sendNotification(String title,String body) {
        Intent i1 = new Intent(this,Dashboard.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0/*request code*/,i1,PendingIntent.FLAG_ONE_SHOT);
        Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification.Builder notibuilder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationsound)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationManager.notify(0/*id of notification*/,notibuilder.build());
        }
    }
}

package com.example.lab5;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyPushNotification {
    private static String CHANNEL_ID="Base channel";
    private static String CHANNEL_DESCRIPTION="it's a base channel";
    private static final int NOTIFY_ID=123;
    private final NotificationManager notificationManager;
    private final Context context;

    public MyPushNotification(Context context, NotificationManager manager){
        notificationManager=manager;
        this.context=context;
        createNotificationChannel();
    }

    public void sendNotify(String title,String text){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp);
        notificationManager.notify(NOTIFY_ID,builder.build());
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_ID,importance);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }
}

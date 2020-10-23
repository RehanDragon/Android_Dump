package com.pramod.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.google.android.gms.common.api.Response;
import com.pramod.firebase.services.NotificationReceiver;

public class custom_notification extends AppCompatActivity {
    public static final String CHANNEL_ID = "Notification";
    public static final String CHANNEL_NAME = "Notification";
    public static final String CHANNEL_DESC = "Notification";
    private static int notification_id;
    public static final String NotificationMSG = "Click on download button to download";
    public static final String NotificationTITLE = "You have a new item to download";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_notification);
        //seekDownloadPermission();
    }



    public static void displayNotification(Context context, String clipContent, String msgType) {

/*

        remoteViews = new RemoteViews(context.getPackageName(),R.layout.activity_custom_notification);
        remoteViews.setImageViewResource(R.id.notif_icon,R.drawable.ic_launcher_background);
        remoteViews.setTextViewText(R.id.notif_title,"TEXT");
        remoteViews.setProgressBar(R.id.progressBar,100,40,true);


        Intent button_intent = new Intent("button_click");
        button_intent.putExtra("id",notification_id);
        button_intent.putExtra("Url",clipContent);
        PendingIntent button_pending_event = PendingIntent.getBroadcast(context,notification_id,
                button_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.button,button_pending_event);


       Intent notification_intent = new Intent(context,GlobalHomeActivity.class);  // just check passing no inente
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notification_intent,0);
*/


        notification_id = (int) System.currentTimeMillis();
        Intent downloadIntent = new Intent(context, NotificationReceiver.class);
        downloadIntent.putExtra("url",clipContent);
        downloadIntent.putExtra("id", notification_id);
        downloadIntent.putExtra("type", msgType);
        downloadIntent.setAction( Constants.DOWNLOAD_ACTION);


        Intent cancelIntent = new Intent(context, NotificationReceiver.class);
        cancelIntent.putExtra("url",clipContent);
        cancelIntent.putExtra("id", notification_id);
        cancelIntent.putExtra("type", msgType);
        //cancelIntent.putExtra("action", Constants.CANCEL_ACTION);
        cancelIntent.setAction( Constants.CANCEL_ACTION);
        PendingIntent downloadPendingIntent =
                PendingIntent.getBroadcast(context,notification_id, downloadIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        PendingIntent cancelPendingIntent =
                PendingIntent.getBroadcast(context,notification_id, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setContentTitle(NotificationTITLE)
                        .setColor(Color.BLUE)
                        .setSmallIcon(R.drawable.app_icon)
                        .setContentText(NotificationMSG)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(R.drawable.download_icon, "Download", downloadPendingIntent)
                        .addAction(R.drawable.cancel_icon, "cancel", cancelPendingIntent)
                        .setAutoCancel(true);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(context);
        mNotificationMgr.notify(notification_id, mBuilder.build());


    }

    public static void createNotificationChannel(NotificationManager manager) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = CHANNEL_NAME;
            String description = CHANNEL_DESC;
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            manager.createNotificationChannel(channel);
        }
    }




}

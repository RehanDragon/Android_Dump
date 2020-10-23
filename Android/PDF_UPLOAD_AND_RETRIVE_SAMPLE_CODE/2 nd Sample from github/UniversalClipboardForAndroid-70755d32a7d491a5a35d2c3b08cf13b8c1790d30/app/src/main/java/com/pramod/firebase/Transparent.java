package com.pramod.firebase;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.shweta.shareFile.FirebaseFileHandler;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;


public class Transparent extends Activity {

    public static final String CHANNEL_ID = "Notification";
    public static final String CHANNEL_NAME = "Notification";
    public static final String CHANNEL_DESC = "Notification";
    public static Transparent instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        setUpIntent();
        setUpNotificationChannel();
        instance = this;
        
        new LovelyStandardDialog(this,R.style.EditTextTintTheme)
                .setTopColorRes(R.color.teal)
                .setTitle("Share to Clip It")
                .setMessage("Sharing....")
                .setIcon(R.drawable.ic_star_border_white_36dp)
                .setPositiveButton(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Transparent.instance.finish();
                    }
                })
                .setCancelable(true)
                .show();
    }

    void setUpIntent() {
        Intent intent = getIntent();
        FirebaseFileHandler.getINSTANCE().sendIntentHandler(this, intent);
    }

    void setUpNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            custom_notification.createNotificationChannel(manager);
        }
    }
}

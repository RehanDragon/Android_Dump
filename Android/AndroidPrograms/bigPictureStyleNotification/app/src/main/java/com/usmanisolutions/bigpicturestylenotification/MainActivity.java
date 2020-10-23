package com.usmanisolutions.bigpicturestylenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notify= (Button)findViewById(R.id.nottify);




        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this is for   higher version or oreo mentaning compatibility

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
                {
                    NotificationChannel channel = new  NotificationChannel("Notifications","My notification", NotificationManager.IMPORTANCE_DEFAULT);

                    NotificationManager manager = getSystemService(NotificationManager.class);

                } // till here it is for compatibility








//this is for the versions below Oreo version
                NotificationCompat.BigPictureStyle bigPictureStyle =new NotificationCompat.BigPictureStyle();

                        bigPictureStyle
                                .bigPicture(BitmapFactory
                                        .decodeResource(getResources(),R.mipmap.ic_launcher   )).build();
                       // .setContentTitle("Notification").setSmallIcon(R.drawable.ic_launcher_background)
                        //.setAutoCancel(true)
                      //  .setContentText("This is my text")



                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                NotificationCompat.Builder builder = (NotificationCompat.Builder) new   NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Big Picture Notification")
                        .setContentText("This is my text for big picture notification")
                        .setStyle(bigPictureStyle) ;

// manager.notify(0,builder.build());


                // Notification Manager ka jo variable ha aus pa notify lagyain ga




//this line is responsible for showing the notification if you will not write this line notification will not come
                notificationManager.notify(0,builder.build()); /* jub tk ya wale line nai likho ga
                                                                      na tum  jub tak notification nai dikhye ga
                                                                      ya wale line responsible ha notifiaction
                                                                      dikhane ka lia
                                                                                                               */


            }
        });

    }
}

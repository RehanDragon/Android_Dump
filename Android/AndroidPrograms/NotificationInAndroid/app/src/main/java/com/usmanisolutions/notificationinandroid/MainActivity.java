package com.usmanisolutions.notificationinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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

                }








//this is for the versions below Oreo version
                NotificationCompat.Builder builder =new NotificationCompat.Builder(MainActivity.this,"My Notification")
                        .setContentTitle("Notification").setSmallIcon(R.drawable.ic_launcher_background)
                        .setAutoCancel(true)
                        .setContentText("This is my text")

                        ;

                NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);

                manager.notify(0,builder.build());

            }
        });




    }
}

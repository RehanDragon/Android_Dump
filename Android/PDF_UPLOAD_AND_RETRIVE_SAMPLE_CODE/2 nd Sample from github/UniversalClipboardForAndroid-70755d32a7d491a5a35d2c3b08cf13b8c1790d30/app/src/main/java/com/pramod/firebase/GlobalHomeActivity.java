package com.pramod.firebase;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pramod.firebase.clipboard.ClipboardHandler;
import com.pramod.firebase.services.ClipboardMonitorService;
import com.pramod.firebase.services.DeviceMonitorService;
import com.pramod.firebase.util.KeyStore;
import com.pramod.firebase.util.RDBHandler;
import com.ruchika.device.DeviceActivity;
import com.shweta.shareFile.FirebaseFileHandler;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import jai.clipboard.ClipboardDetails;

public class GlobalHomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static int int_items = 2;
    public static final String CHANNEL_ID = "Notification";
    public static final String CHANNEL_NAME = "Notification";
    public static final String CHANNEL_DESC = "Notification";
    private static int STORAGE_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_globalhome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        setupElements();

       /* setUpIntent();
        setUpNotificationChannel();
*/
        //seekWritePermission();

        findViewById(R.id.btnShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSendButton();
            }
        });

    }

    void handleSendButton() {
        new LovelyTextInputDialog(this, R.style.EditTextTintTheme)
                .setTopColorRes(R.color.teal)
                .setTitle("Quick Send content to other devices")
                .setMessage("Share content with all connected devices with a single go. Enter the text you want to send here. ")
                .setIcon(R.drawable.ic_star_border_white_36dp)
                .setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String text) {
                        if (text != null && !text.isEmpty()) {
                            sendText(text);
                        }
                    }
                })
                .setCancelable(true)
                .show();
    }

    void sendText(String text) {
        ClipboardHandler.setInClipboard(text, this);
        Toast.makeText(GlobalHomeActivity.this, "Sent Data to all devices!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logoutBtn:
                logoutUser();
                return true;
        }

        return true;

    }


    void logoutUser() {
        RDBHandler.getInstance().delete(KeyStore.getDevicesKeyForCurrentDevice(getContentResolver()));
        FirebaseAuth.getInstance().signOut();
        navigateLoginPage();
    }

    void navigateLoginPage() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    void setupElements() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                String token = task.getResult().getToken();
                Log.d(Constants.TAG, token);
            }
        });

        startServices();
        startDeviceServices();
    }

    public void stopService() {
        if (!isMyServiceRunning(ClipboardMonitorService.class)) {
            stopService(new Intent(this, ClipboardMonitorService.class));
        }
    }

    public void startServices() {
        if (!isMyServiceRunning(ClipboardMonitorService.class)) {
            startService(new Intent(this, ClipboardMonitorService.class));
        }
    }

    public void startDeviceServices() {
        if (!isMyServiceRunning(DeviceMonitorService.class)) {
            startService(new Intent(this, DeviceMonitorService.class));
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("isMyServiceRunning?", true + "");
                return true;
            }
        }
        Log.i("isMyServiceRunning?", false + "");
        return false;
    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */
        @Override

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DeviceActivity();
                case 1:
                    return new ClipboardDetails();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        /**
         * This method returns the title of the tab according to the position.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Devices";
                case 1:
                    return "Clipboard";
            }
            return null;
        }
    }

    /*void setUpIntent(){
        Intent intent = getIntent();
        FirebaseFileHandler.getINSTANCE().sendIntentHandler(getApplicationContext(), intent);
        //FirebaseFileHandler.gsendIntentHandler(getApplicationContext(), intent);
    }

    void setUpNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            custom_notification.createNotificationChannel(manager);
        }
    }

    /*public void seekWritePermission(){
        if (ContextCompat.checkSelfPermission(GlobalHomeActivity.this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(GlobalHomeActivity.this, "You have already granted this permission!",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission();
        }
    }


    public void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(GlobalHomeActivity.this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(GlobalHomeActivity.this,
                                    new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(GlobalHomeActivity.this,
                    new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }


    @Override
    public  void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }*/


}


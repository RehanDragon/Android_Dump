package com.pramod.firebase;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import jai.clipboard.ClipboardDetails;


/**
 * A simple {@link Fragment} subclass.
 */
public class GlobalHomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton btnShare;
    public static int int_items = 2;
    private static int STORAGE_PERMISSION_CODE = 1;

    public GlobalHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setupElements();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_global_home, container, false);
        btnShare = (FloatingActionButton) v.findViewById(R.id.btnShare);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSendButton();
            }
        });


//        getActivity().findViewById(R.id.btnShare).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                handleSendButton();
//            }
//        });

        return v;
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

    void handleSendButton() {
        new LovelyTextInputDialog(getContext(), R.style.EditTextTintTheme)
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
        ClipboardHandler.setInClipboard(text, getContext());
        Toast.makeText(getContext(), "Sent Data to all devices!", Toast.LENGTH_SHORT).show();
    }

    public void stopService() {
        if (!isMyServiceRunning(ClipboardMonitorService.class)) {
            getActivity().stopService(new Intent(this.getActivity(), ClipboardMonitorService.class));
        }
    }

    public void startServices() {
        if (!isMyServiceRunning(ClipboardMonitorService.class)) {
            getActivity().startService(new Intent(this.getActivity(), ClipboardMonitorService.class));
        }
    }

    public void startDeviceServices() {
        if (!isMyServiceRunning(DeviceMonitorService.class)) {
            getActivity().startService(new Intent(this.getActivity(), DeviceMonitorService.class));
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
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
}

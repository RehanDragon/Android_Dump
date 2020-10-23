package com.ruchika.device;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pramod.firebase.R;
import com.pramod.firebase.storage.Device;
import com.pramod.firebase.util.KeyStore;

import java.util.ArrayList;
import java.util.Map;

import static com.facebook.FacebookSdk.getApplicationContext;


public class DeviceActivity extends Fragment {

    ListView deviceList;
    DeviceCustomAdapter deviceCustomAdapter;
    ArrayList<Device> deviceArray = new ArrayList<Device>();
    FirebaseDatabase fdb = FirebaseDatabase.getInstance();
    //   private static final String key = "devices/" +FirebaseAuth.getInstance().getCurrentUser().getUid();
    private static final String key = KeyStore.getDevicesKeyForUser();

    String value;
    String deviceName, ipName;

    public DeviceActivity() {
        // Required empty public constructor
        //    setupElements();
        //  getElements();
    }





/*    void getElements(){
        DatabaseReference dbReference = fdb.getReference(key);
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DeviceStore val = DeviceStore.fromObject(dataSnapshot.getValue());
           //     deviceArray = DeviceStore.getDeviceArray(val);

                Map<String, Device> map = val.getDevices();
                for (String key : map.keySet()) {
                    Device deviceObj = map.get(key);
                    deviceName = deviceObj.getDeviceName();
                    ipName = deviceObj.getIpName();
                    deviceArray.add(new Device(deviceName, ipName));
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    } */

    public void childActivity() {
        DatabaseReference dbReference = fdb.getReference(key);
        dbReference.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("added", dataSnapshot.getValue().toString());
                Device device = new Device((Map<String, String>) dataSnapshot.getValue());

//                for(Device d : deviceArray){
//                    if(!d.getDeviceId().equals(device.deviceId)){
//                        deviceArray.add(device);
//                    }
//                }
                deviceArray.add(device);
                deviceCustomAdapter.notifyDataSetChanged();

                //     deviceArray = DeviceStore.getDeviceArray(val);
                try {

                    /*DeviceStore val = DeviceStore.fromObject(dataSnapshot.getValue());

                    Map<String, Device> map = val.getDevices();
                    for (String key : map.keySet()) {
                        Device deviceObj = map.get(key);
                        deviceName = deviceObj.getDeviceName();
                        ipName = deviceObj.getIpName();
                        deviceArray.add(new Device(deviceName, ipName));
                    }
*/
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                deviceArray = DeviceStore.getDeviceArray(val);
//                Log.d("changed",dataSnapshot.getValue().toString());
//
                Device device = new Device((Map<String, String>) dataSnapshot.getValue());
                String deviceId = dataSnapshot.getKey();
                String state = device.getState();
                for (Device d : deviceArray) {
                    if (d.getDeviceId().equals(device.getDeviceId())) {
                        int index = deviceArray.indexOf(d);
                        deviceArray.set(index, device);
                    }
                }
//
//                for(Device d : deviceArray){
//                    if(d.getDeviceName().equals(deviceName) && d.getDeviceState().equals(state)){
//                         int index = deviceArray.indexOf(d);
//                         Log.d("removed", index+"");
//                         deviceArray.remove(index);
//                         break;
//                    }
//                }
//                deviceArray.add(device);


/*
                DeviceStore val = DeviceStore.fromObject(dataSnapshot.getValue());
                Map<String, Device> map = val.getDevices();
                for (String key : map.keySet()) {
                    Device deviceObj = map.get(key);
                    deviceName = deviceObj.getDeviceName();
                    ipName = deviceObj.getIpName();
                    deviceArray.add(new Device(deviceName, ipName));
                }
*/

                deviceCustomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                Log.d("deleted", dataSnapshot.getValue().toString());

                Device device = new Device((Map<String, String>) dataSnapshot.getValue());
                String deviceId = dataSnapshot.getKey();
                for (Device d : deviceArray) {
                    if (d.getDeviceId().equals(deviceId)) {
                        int index = deviceArray.indexOf(d);
                        Log.d("removed", index + "");
                        deviceArray.remove(index);
                        break;
                    }
                }
                deviceCustomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        childActivity();

        View view = inflater.inflate(R.layout.device_list, container, false);
        deviceCustomAdapter = new DeviceCustomAdapter(this.getActivity(), R.layout.device_details, deviceArray);
        deviceList = (ListView) view.findViewById(R.id.devicelist);
        // deviceList.setItemsCanFocus(false);
        deviceList.setAdapter(deviceCustomAdapter);
        deviceList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Device Name");
                alertDialog.setMessage("Enter new device name:");

                final EditText input = new EditText(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String newDeviceName = input.getText().toString();
                                if (!newDeviceName.isEmpty()) {
                                    Device device = (Device) parent.getItemAtPosition(position);
                                    DatabaseReference dbReference = fdb.getReference(key).child(device.deviceId).child("deviceName");
                                    dbReference.setValue(newDeviceName);
                                    Toast.makeText(getApplicationContext(), "Device Name Changed", Toast.LENGTH_SHORT).show();
                                }
//                                if (password.compareTo("") == 0) {
//                                        Toast.makeText(getApplicationContext(),
//                                                "Password Matched", Toast.LENGTH_SHORT).show();

                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
                return true;
            }
        });
        return view;
    }

}


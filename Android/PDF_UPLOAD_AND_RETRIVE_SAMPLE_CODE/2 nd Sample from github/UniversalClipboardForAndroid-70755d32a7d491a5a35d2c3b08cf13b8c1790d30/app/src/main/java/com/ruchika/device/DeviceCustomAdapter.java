package com.ruchika.device;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pramod.firebase.Constants;
import com.pramod.firebase.GlobalHomeActivity;
import com.pramod.firebase.LoginActivity;
import com.pramod.firebase.R;
import com.pramod.firebase.storage.Device;
import com.pramod.firebase.storage.DeviceStore;
import com.pramod.firebase.util.KeyStore;

import java.util.ArrayList;
import java.util.Map;

import static com.facebook.FacebookSdk.getApplicationContext;

public class DeviceCustomAdapter extends ArrayAdapter<Device> {
    Context context;
    int layoutResourceId;

    ArrayList<Device> data = new ArrayList<Device>();
    FirebaseDatabase fdb = FirebaseDatabase.getInstance();
    //  private static final String key = "devices/" + FirebaseAuth.getInstance().getUid();
    private static final String key = KeyStore.getDevicesKeyForUser();
    TextView textDeviceName;
    TextView textIPAddress;
    Switch btnSwitch;
    ImageButton btnDelete;

    LinearLayout linearLayout = new LinearLayout(getContext());
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        layoutParams.setMargins(6, 1, 6, 1);
        linearLayout.setLayoutParams(layoutParams);
    }

    EditText editText = new EditText(getContext());


    public void setEditText(EditText editText) {
        this.editText = editText;
        editText.setTextSize(15);
        editText.setLayoutParams(layoutParams);
        linearLayout.setGravity(Gravity.CENTER);
        //   editText.setText("None");
        linearLayout.addView(editText);
    }


    public DeviceCustomAdapter(Context context, int layoutResourceId, ArrayList<Device> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        View row = view;
        Device device = data.get(position);

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        textDeviceName = (TextView) row.findViewById(R.id.device_name);
        textIPAddress = (TextView) row.findViewById(R.id.ip_name);
        btnSwitch = (Switch) row.findViewById(R.id.btnSwitch);
        btnDelete = (ImageButton) row.findViewById(R.id.delete);
        //   row.setTag(details);
        //  details =(DeviceDetails)row.getTag();


        textDeviceName.setText(device.getDeviceName());
        textIPAddress.setText(device.getIpName());
        //Log.d("currentState",device.getState());

        if (device.getState().equals("0")) {
            btnSwitch.setChecked(false);
        }

        //   details.btnSwitch.setText(device.getState());

//        textDeviceName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                AlertDialog.Builder builder = new AlertDialog.Builder(context);
////                builder.setTitle("Device Name");
////                builder.setMessage("Enter new device name:");
////                builder.setView(editText);
////                builder.show();
////                String deviceName = editText.getText().toString();
////                if (!deviceName.isEmpty()){
////
////                }
//
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//                alertDialog.setTitle("Device Name");
//                alertDialog.setMessage("Enter new device name:");
//
//                final EditText input = new EditText(context);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
//                input.setLayoutParams(lp);
//                alertDialog.setView(input);
//      //          alertDialog.setIcon(R.drawable.key);
//                alertDialog.setPositiveButton("YES",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                              String password = input.getText().toString();
//                              if(!password.isEmpty()) {
//                                  Device device = data.get(position);
//                                  DatabaseReference dbReference = fdb.getReference(key).child(device.deviceName).child("deviceName");
//                                  dbReference.setValue(password);
//                                  Toast.makeText(getApplicationContext(),"Device Name Changed",Toast.LENGTH_SHORT).show();
//                              }
////                                if (password.compareTo("") == 0) {
////                                        Toast.makeText(getApplicationContext(),
////                                                "Password Matched", Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//
//                alertDialog.setNegativeButton("NO",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.cancel();
//                            }
//                        });
//
//                alertDialog.show();
//            }
//
//        });

        btnSwitch.setFocusable(false);
        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Device device = data.get(position);
                    device.state = Constants.STATE_ON;
                    Log.d("stateON", device.state);
                    String mapKey = device.deviceId;
                    DatabaseReference dbReference = fdb.getReference(key).child(mapKey).child("state");
                    Log.d("dbreference1", dbReference.toString());
                    dbReference.setValue("1");

                } else {
                    // The toggle is disabled
                    Device device = data.get(position);
                    device.state = Constants.STATE_OFF;
                    Log.d("stateOFF", device.state);
                    String mapKey = device.deviceId;
                    DatabaseReference dbReference = fdb.getReference(key).child(mapKey).child("state");
                    Log.d("dbreference2", dbReference.toString());
                    dbReference.setValue("0");

                }
                notifyDataSetChanged();
            }
        });

        btnDelete.setFocusable(false);
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "Delete button Clicked", Toast.LENGTH_LONG).show();
//                Device device = data.get(position);
//                DeviceStore storeObject = new DeviceStore();
//                Map<String,Device> map = storeObject.getDevices();
//                String mapKey = device.deviceId;
//                map.remove(mapKey);
//                data.remove(position);
//
//                DatabaseReference dbReference = fdb.getReference(key).child(mapKey);
//                dbReference.removeValue();
//
//                notifyDataSetChanged();

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Are you sure you want delete?");
                builder.setCancelable(false);
                builder.getContext().getContentResolver();
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Device device = data.get(position);
                        DeviceStore storeObject = new DeviceStore();
                        Map<String, Device> map = storeObject.getDevices();
                        String mapKey = device.deviceId;
                        if (device.getDeviceId().equals(KeyStore.getDeviceId(builder.getContext().getContentResolver()))) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            context.startActivity(intent);
                        }
                        map.remove(mapKey);
                        data.remove(position);

                        DatabaseReference dbReference = fdb.getReference(key).child(mapKey);
                        dbReference.removeValue();

                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "You've changed your mind to delete the device", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

        return row;
    }


}

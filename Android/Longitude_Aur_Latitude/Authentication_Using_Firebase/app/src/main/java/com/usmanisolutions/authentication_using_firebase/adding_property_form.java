package com.usmanisolutions.authentication_using_firebase;
/*
GUIDE TAKEN FROM = https://javapapers.com/android/get-current-location-in-android/
* */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class adding_property_form extends AppCompatActivity  {

    private TextView locationsetter;

    private static final int REQUEST_CODE_LOCATION_PERMISION=1;
    protected Context context;
    /*String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_property_form);
        //ALL FBC here

        locationsetter = (TextView) findViewById(R.id.location_setter);


       locationsetter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               if(ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION
               ) != PackageManager.PERMISSION_GRANTED){

                   ActivityCompat.requestPermissions(adding_property_form.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION_PERMISION);

               }
               else
               {
                   getCurrentLocation();
               }



               /* if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                   // TODO: Consider calling
                   //    Activity#requestPermissions
                   // here to request the missing permissions, and then overriding
                   //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                   //                                          int[] grantResults)
                   // to handle the case where the user grants the permission. See the documentation
                   // for Activity#requestPermissions for more details.
                   ActivityCompat.requestPermissions(adding_property_form.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION_PERMISION);
                   return;
               }else {getCurrentLocation}*/
             //  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, adding_property_form.this);
               //yad rekhna humesha jub bhe kise chez pa on click listener lgao ga to aus k ander (aus_class_ka_nam_jis_main_mojude_hain.this  ) aye ga
           }
       });







              //  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
        /*work for current location finder starts from here */


/*work for current location finder ends here */
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_LOCATION_PERMISION && grantResults.length >0)
        {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                getCurrentLocation();
            }
            else{
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void getCurrentLocation()
    {
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.getFusedLocationProviderClient(adding_property_form.this)
        .requestLocationUpdates(locationRequest,new LocationCallback(){

            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                LocationServices.getFusedLocationProviderClient(adding_property_form.this)
                        .removeLocationUpdates(this);
                if(locationRequest != null && locationResult.getLocations().size() >0 ){
                    int latestlocationIndex = locationResult.getLocations().size() -1;
                    double latitude=locationResult.getLocations().get(latestlocationIndex).getLatitude();
                    double longitude = locationResult.getLocations().get(latestlocationIndex).getLongitude();

                    locationsetter.setText(
                            String.format("Latitude: %s Longitude: %s",latitude,longitude)
                    );

                }
            }
        }, Looper.getMainLooper());



    }

}

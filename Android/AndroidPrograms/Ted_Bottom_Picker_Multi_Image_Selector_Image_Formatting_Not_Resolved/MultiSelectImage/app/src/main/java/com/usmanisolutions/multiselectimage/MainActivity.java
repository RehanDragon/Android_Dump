package com.usmanisolutions.multiselectimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity {

    private Button btnSelectImage;
    private RecyclerView rcvPhoto;
    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectImage = findViewById(R.id.btn_select_image);
        rcvPhoto = findViewById(R.id.rcv_photo);

        photoAdapter = new PhotoAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false);
        rcvPhoto.setLayoutManager(/*gridLayoutManager*/linearLayoutManager);
        rcvPhoto.setFocusable(false);
        rcvPhoto.setAdapter(photoAdapter);


        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();
            }
        });

    }

    private void requestPermission()
    {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

                openBottomPicker();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();

    }

    private void openBottomPicker()
    {
        TedBottomPicker.OnMultiImageSelectedListener listener = new TedBottomPicker.OnMultiImageSelectedListener() {
            @Override
            public void onImagesSelected(ArrayList<Uri> uriList) {
                photoAdapter.setData(uriList);
            }
        };



        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(/*jis activity main mojude hain.this*/MainActivity.this)
                .setOnMultiImageSelectedListener(listener)
                .setCompleteButtonText("DONE")
                .setEmptySelectionText("No Image")
                .create();
        tedBottomPicker.show(getSupportFragmentManager());
    }
}

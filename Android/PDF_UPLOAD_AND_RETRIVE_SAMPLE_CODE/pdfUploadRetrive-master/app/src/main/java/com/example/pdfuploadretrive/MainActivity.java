package com.example.pdfuploadretrive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    final static int PICK_PDF_CODE=2342;
    TextView textViewStatus,textViewUploads;
    EditText editTextFileName;
    ProgressBar progressBar;
    Button buttonUploadFile;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus=findViewById(R.id.textViewStatus);
        editTextFileName=findViewById(R.id.editTextFileName);
        progressBar=findViewById(R.id.progressbar);
        buttonUploadFile=findViewById(R.id.buttonUploadFile);
        textViewUploads=findViewById(R.id.textViewUpload);


        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);


        buttonUploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPDF();
            }
        });
        textViewUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewUploadsActivity.class));
            }
        });


    }

    private void getPDF(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M&& ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:"+getPackageName()));
            startActivity(intent);
            return;
        }

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_PDF_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==PICK_PDF_CODE && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            if (data.getData()!=null)
            {
                uploadFile(data.getData());
            }else
            {
                Toast.makeText(this, "No file chosen", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadFile(Uri data) {
        progressBar.setVisibility(View.VISIBLE);
        final StorageReference sRef = storageReference.child(Constants.STORAGE_PATH_UPLOADS+System.currentTimeMillis()+".pdf");
        sRef.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressBar.setVisibility(View.GONE);
                        textViewStatus.setText("File Uploaded SuccessFully");

                        Upload upload=new Upload(editTextFileName.getText().toString(),sRef.getDownloadUrl().toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(upload);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress= (100.0 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        textViewStatus.setText((int)progress+"% Uploading...");
                    }
                });
    }

}


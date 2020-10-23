package com.usmanisolutions.pdf_upload_anrd_retrive_try_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewUploadsActivity extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<Upload> uploadPDFS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_uploads);


        listView = findViewById(R.id.listView);
        uploadPDFS = new ArrayList<>();

        viewAllFiles();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Upload pdf = uploadPDFS.get(i);

                Intent intent = new Intent();
                intent.setData(Uri.parse(/*pdf.getUrl()*/"gs://login-integratio-1583644536788.appspot.com/uploads"));
                startActivity(intent);

            }
        });

    }



    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload pdf = postSnapshot.getValue(Upload.class);
                    uploadPDFS.add(pdf);
                }
                String[] uploads = new String[uploadPDFS.size()];
                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

package com.usmanisolutions.filemanager;
//GUIDE : http://www.christophbrill.de/en/posts/how-to-create-a-android-file-browser-in-15-minutes/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ListActivity {
    private String path;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        button=(Button) findViewById(R.id.button);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Use the current directory as title
                path = "application/pdf";

                if (getIntent().hasExtra("path")) {
                    path = getIntent().getStringExtra("path");
                }
                setTitle(path);

                // Read all files sorted into the values-array
                List values = new ArrayList();
                File dir = new File(path);
                if (!dir.canRead()) {
                    setTitle(getTitle() + " (inaccessible)");
                }
                String[] list = dir.list();
                if (list != null) {
                    for (String file : list) {
                        if (!file.startsWith(".")) {
                            values.add(file);
                        }
                    }
                }
                Collections.sort(values);

                // Put the data into the list
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_2, android.R.id.text1, values);
                setListAdapter(adapter);


            }
        });
    }





    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String filename = (String) getListAdapter().getItem(position);
        if (path.endsWith(File.separator)) {
            filename = path + filename;
        } else {
            filename = path + File.separator + filename;
        }
        if (new File(filename).isDirectory()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("path", filename);
            startActivity(intent);
        } else {
            Toast.makeText(this, filename + " is not a directory", Toast.LENGTH_LONG).show();
        }
    }



}



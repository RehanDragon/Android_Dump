package com.usmanisolutions.pdf_file_uploader_try_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//Uri.parse(upload.getUrl())
public class ViewUploadsActivity extends AppCompatActivity {

   public ListView myPDfListView;
    public DatabaseReference databaseReference;
    public PDFView pdfView;
    public  List</*helper class ke type set ho ge*/Upload> uploadPDFS;


    //the listview
    ListView listView;

    //database reference to get uploads data
    DatabaseReference mDatabaseReference;

    //list to store uploads data
    List<Upload> uploadList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_uploads);

        myPDfListView=(ListView)findViewById(R.id.listView);
          pdfView=(PDFView)findViewById(R.id.pdfView);
        uploadPDFS=new ArrayList<>();

        viewAllFiles();

        uploadList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);


        //adding a clicklistener on listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the upload
                Upload upload = uploadList.get(i);

                //Opening the upload file in browser using the upload url
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(upload.getUrl()));
                try {
                    startActivity(intent); // OVER HERE  APP IS CRASHING
                }catch(Exception e)
                {
                    //e.printStackTrace();
                    Log.d("ya_reha_error", e.toString());
                    //Toast.makeText(ViewUploadsActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        //getting the database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploadList.add(upload);
                }

                String[] uploads = new String[uploadList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadList.get(i).getName();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ViewUploadsActivity.this,databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void viewAllFiles() {
databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        /*Upload upload = new Upload();
        pdfView.fromUri(Uri.parse(upload.getUrl()));*/


        for(DataSnapshot postSnapshot : dataSnapshot.getChildren() )
        {
            // Helper (Model ) class ka object bne ga
            Upload uploadPDF = postSnapshot.getValue(Upload.class);
        uploadPDFS.add(uploadPDF);

        }

        String[] uploads = new String[uploadPDFS.size()];
        for (int i =0;i<uploads.length;i++)
        {
// ais sa file ka nam aye ga text pa
            //uploads[i]=uploadPDFS.get(i).getName();
            //just for testing ais sa file ka link view  ho ga Text view pa
            uploads[i]=uploadPDFS.get(i).getUrl();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads)
        {

            @Override
            public View getView(int position,  View convertView, ViewGroup parent) {


                View view = super.getView(position, convertView, parent);

                TextView myText =(TextView) view.findViewById(android.R.id.text1);

                myText.setTextColor(Color.BLACK);

                return view;

            }
        };
        myPDfListView.setAdapter(adapter);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

        Toast.makeText(ViewUploadsActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
    }
});
    }



    

}

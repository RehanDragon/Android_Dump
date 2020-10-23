package jai.clipboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.pramod.firebase.R;
import com.pramod.firebase.storage.ClipHistory;
import com.pramod.firebase.storage.ClipHistoryStore;
import com.pramod.firebase.util.KeyStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class ClipboardAdapter extends ArrayAdapter<ClipHistory> {

    Activity context;
    int layoutId;
    ArrayList<ClipHistory> clipContents = new ArrayList<ClipHistory>();
    FirebaseDatabase fdb = FirebaseDatabase.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static String key = KeyStore.getClipboardHistoryKeyForUser();

    public ClipboardAdapter(Activity context, int layoutId, ArrayList<ClipHistory> clipContents) {
        super(context, layoutId, clipContents);
        this.context = context;
        this.layoutId = layoutId;
        this.clipContents = clipContents;
    }

    public View getView(final int position, View view, ViewGroup parent) {

        View row = view;

        ClipHistory clipDetails = clipContents.get(position);

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutId, parent, false);

        TextView device_title_txt = (TextView) row.findViewById(R.id.device_title);
        device_title_txt.setText(clipDetails.getDeviceName());

        if (clipDetails.getMessageType().equals("1")) {
            RelativeLayout single_clip_layout = row.findViewById(R.id.single_clip_layout);
            TextView clip_content_txt = new TextView(this.getContext());
            clip_content_txt.setId(R.id.clipboard_content);
            clip_content_txt.setTextSize(15);
            clip_content_txt.setText(clipDetails.getClipContent());

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(400, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.RIGHT_OF, R.id.img_device);
            lp.addRule(RelativeLayout.BELOW, R.id.device_title);

            clip_content_txt.setLayoutParams(lp);
            single_clip_layout.addView(clip_content_txt);

        } else if (clipDetails.getMessageType().equals("2")) {

            RelativeLayout single_clip_layout = row.findViewById(R.id.single_clip_layout);
            final ImageView clip_content_img = new ImageView(this.getContext());
            clip_content_img.setId(R.id.clipboard_content);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(400, 200);
            lp.addRule(RelativeLayout.RIGHT_OF, R.id.img_device);
            lp.addRule(RelativeLayout.BELOW, R.id.device_title);
            clip_content_img.setLayoutParams(lp);


            StorageReference storageRef = storage.getReferenceFromUrl(clipDetails.getClipContent());

            try {
                final File localFile = File.createTempFile("images", "jpg");

                /*String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());

                final File localFile = new File(DOWNLOAD_DIR, fileName);
                localFile.createNewFile();*/
                storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                        clip_content_img.setImageBitmap(bitmap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                    }
                });
            } catch (IOException e) {
            }

            single_clip_layout.addView(clip_content_img);
        }

        else if (clipDetails.getMessageType().equals("5")) {


            RelativeLayout single_clip_layout = row.findViewById(R.id.single_clip_layout);
            final ImageView clip_content_img = new ImageView(this.getContext());
            clip_content_img.setId(R.id.img1);
            clip_content_img.setImageResource(R.drawable.pdf_img);

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(50, 50);
            lp.addRule(RelativeLayout.RIGHT_OF, R.id.img_device);
            lp.addRule(RelativeLayout.BELOW, R.id.device_title);
            clip_content_img.setLayoutParams(lp);

            StorageReference storageRef = storage.getReferenceFromUrl(clipDetails.getClipContent());
            TextView txt_pdf = new TextView(this.getContext());
            txt_pdf.setText(storageRef.getName());

            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp1.addRule(RelativeLayout.RIGHT_OF, R.id.img1);
            lp1.addRule(RelativeLayout.BELOW, R.id.device_title);
            txt_pdf.setTextSize(12);
            txt_pdf.setTypeface(txt_pdf.getTypeface(),Typeface.BOLD);
            txt_pdf.setLayoutParams(lp1);

            single_clip_layout.addView(clip_content_img);
            single_clip_layout.addView(txt_pdf);
        }



        ImageButton del_btn = (ImageButton) row.findViewById(R.id.btn_delete);

        del_btn.setFocusable(false);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Are you sure you want to delete?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClipHistory clipHistory = clipContents.get(position);
                        ClipHistoryStore storeObject = new ClipHistoryStore();
                        Map<String, ClipHistory> map = storeObject.getClipContents();
                        String mapKey = clipHistory.getTimestamp();
                        map.remove(mapKey);
                        clipContents.remove(position);
                        DatabaseReference dbReference = fdb.getReference(key).child(mapKey);
                        dbReference.removeValue();
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "You've changed your mind to delete the clip", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();

            }
        });


        return row;
    }

}

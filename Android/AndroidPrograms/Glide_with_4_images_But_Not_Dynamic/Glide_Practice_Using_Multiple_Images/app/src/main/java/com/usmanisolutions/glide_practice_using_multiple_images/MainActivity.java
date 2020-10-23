package com.usmanisolutions.glide_practice_using_multiple_images;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;


    private static final int REQUEST_OPEN_RESULT_CODE_1 =0;
    private static final int REQUEST_OPEN_RESULT_CODE_2 =1;
    private static final int REQUEST_OPEN_RESULT_CODE_3 =2;
    private static final int REQUEST_OPEN_RESULT_CODE_4 =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.standard_list_imageview1);
        imageView2 = (ImageView) findViewById(R.id.standard_list_imageview2);
        imageView3 = (ImageView) findViewById(R.id.standard_list_imageview3);
        imageView4 = (ImageView) findViewById(R.id.standard_list_imageview4);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent,REQUEST_OPEN_RESULT_CODE_1);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent,REQUEST_OPEN_RESULT_CODE_2);
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent,REQUEST_OPEN_RESULT_CODE_3);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent,REQUEST_OPEN_RESULT_CODE_4);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode==REQUEST_OPEN_RESULT_CODE_1 && resultCode==RESULT_OK)
        {
            Uri uri=null;
            if (resultData !=null)
            {

                uri = resultData.getData();

            /*try {
                Bitmap bitmap = getBitmapFromUri(uri);
                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
                Glide.with(this).load(uri).into(imageView1);// mubarak ho ais sa image nai phate


            }

        }

        if (requestCode==REQUEST_OPEN_RESULT_CODE_2 && resultCode==RESULT_OK)
        {
            Uri uri=null;
            if (resultData !=null)
            {

                uri = resultData.getData();

            /*try {
                Bitmap bitmap = getBitmapFromUri(uri);
                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
                Glide.with(this).load(uri).into(imageView2);// mubarak ho ais sa image nai phate


            }

        }
        if (requestCode==REQUEST_OPEN_RESULT_CODE_3 && resultCode==RESULT_OK)
        {
            Uri uri=null;
            if (resultData !=null)
            {

                uri = resultData.getData();

            /*try {
                Bitmap bitmap = getBitmapFromUri(uri);
                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
                Glide.with(this).load(uri).into(imageView3);// mubarak ho ais sa image nai phate


            }

        }
        if (requestCode==REQUEST_OPEN_RESULT_CODE_4 && resultCode==RESULT_OK)
        {
            Uri uri=null;
            if (resultData !=null)
            {

                uri = resultData.getData();

            /*try {
                Bitmap bitmap = getBitmapFromUri(uri);
                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
                Glide.with(this).load(uri).into(imageView4);// mubarak ho ais sa image nai phate


            }

        }
    }



    private Bitmap getBitmapFromUri(Uri uri) throws IOException
    {
        ParcelFileDescriptor parcelFileDescriptor=getContentResolver().openFileDescriptor(uri,"r");
        FileDescriptor fileDescriptor= parcelFileDescriptor.getFileDescriptor();
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return bitmap;
    }
}

package com.usmanisolutions.pdfviewpagerliabrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class MainActivity extends AppCompatActivity implements DownloadFile.Listener{
    String url = "africau.edu/images/default/sample.pdf";
    RemotePDFViewPager remotePDFViewPager;
    Context context;

    PDFPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        remotePDFViewPager =
                new RemotePDFViewPager(context, url, this);

    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, "AdobeXMLFormsSamples.pdf");
        remotePDFViewPager.setAdapter(adapter);
        setContentView(remotePDFViewPager);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        adapter.close();
    }

}
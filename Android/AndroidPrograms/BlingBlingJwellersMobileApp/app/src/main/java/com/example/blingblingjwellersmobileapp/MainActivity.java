package com.example.blingblingjwellersmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
private WebView blingbling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        blingbling = (WebView) findViewById(R.id.blingbling);

        //jo web view ka variable  ha aus pa client bna na ha
        blingbling.setWebViewClient(new WebViewClient());
        blingbling.loadUrl("https://blingblingjewelers.com/");

// websettings mera object variable ha WebSettings ka
        WebSettings websettings = blingbling.getSettings();

        //java script enable kre
        websettings.setJavaScriptEnabled(true);










    }

//aub hum pecha jane k lia logic define krain ga


    // now i am creating the method of going back

    // this is a builtin method that i had used
    public void onBackPressed()
    {

        if(blingbling.canGoBack())
        {
           blingbling.goBack();
        }

        else
        {
            // super main class ko refer kr reha ha
            // class main mojuda items ko pecha la jao
            // yani simply back chle jao
            super.onBackPressed();
        }


    }


}

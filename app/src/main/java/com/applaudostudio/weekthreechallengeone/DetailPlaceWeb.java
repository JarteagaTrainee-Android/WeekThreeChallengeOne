package com.applaudostudio.weekthreechallengeone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailPlaceWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place_web);



        WebView myWebView = (WebView) findViewById(R.id.webViewPlace);
        myWebView.loadUrl("https://www.google.com");
    }
}

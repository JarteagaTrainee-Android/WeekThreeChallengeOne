package com.applaudostudio.weekthreechallengeone;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailPlaceWebActivity extends AppCompatActivity {

    @SuppressLint({"PrivateResource", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place_web);

        String urlSite = getIntent().getStringExtra(DetailPlaceActivity.KEY_WEB_URL);

        Toolbar toolbar = findViewById(R.id.toolbarWeb);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setBackgroundColor(getIntent().getIntExtra(DetailPlaceActivity.EXTRA_COLOR_BAR,R.color.foodColor));

        WebView myWebView = findViewById(R.id.webViewPlace);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        myWebView.loadUrl(urlSite);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);

    }
}

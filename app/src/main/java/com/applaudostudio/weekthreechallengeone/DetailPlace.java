package com.applaudostudio.weekthreechallengeone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class DetailPlace extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_WEB_URL="PLACE_SITE";
    private String mPlaceName;
    private String mPlaceDescription;
    private String mPlacePhone;
    private String getmPlaceURL;
    private int mLogoRs;
    private int mPictureRs;

    ImageButton btnPhone;
    ImageButton btnWeb;
    ImageButton btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);
        btnWeb = findViewById(R.id.imageButtonWeb);
        btnPhone = findViewById(R.id.imageButtonPhone);
        btnMaps = findViewById(R.id.imageButtonMap);

        btnWeb.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnMaps.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.imageButtonPhone:
                Uri number = Uri.parse("tel:+503 2257-7777");
                intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
                break;
            case R.id.imageButtonMap:
                Uri mapGeo = Uri.parse("geo:37.7749,-122.4194");
                intent = new Intent(Intent.ACTION_VIEW, mapGeo);
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.imageButtonWeb:
                intent = new Intent(this,DetailPlaceWeb.class);
                intent.putExtra(KEY_WEB_URL,"www.google.com");
                startActivity(intent);
                break;
        }
    }
}

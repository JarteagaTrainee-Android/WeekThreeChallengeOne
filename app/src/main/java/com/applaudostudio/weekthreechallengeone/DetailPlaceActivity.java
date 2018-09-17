package com.applaudostudio.weekthreechallengeone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.applaudostudio.weekthreechallengeone.model.CardItem;


public class DetailPlaceActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_WEB_URL = "PLACE_SITE";
    private static final int INTENT_TYPE_MAP = 1;
    private static final int INTENT_TYPE_DIAL = 2;
    private static final int INTENT_TYPE_WEB = 3;
    public static final String EXTRA_COLOR_BAR="barColor";


    TextView txtTitle;
    TextView txtDescription;
    ImageView imgLogo;
    ImageView imgPlace;
    ImageButton btnPhone;
    ImageButton btnWeb;
    ImageButton btnMaps;
    CardItem mPlaceData;


    @SuppressLint("PrivateResource")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        btnWeb = findViewById(R.id.imageButtonWeb);
        btnPhone = findViewById(R.id.imageButtonPhone);
        btnMaps = findViewById(R.id.imageButtonMap);
        txtTitle = findViewById(R.id.textViewTitle);
        txtDescription = findViewById(R.id.textViewDescription);
        imgLogo = findViewById(R.id.imageViewLogo);
        imgPlace = findViewById(R.id.imageViewPlace);


        btnWeb.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnMaps.setOnClickListener(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        Intent i = getIntent();
        mPlaceData = i.getParcelableExtra(ListFragment.EXTRA_ARG);
        this.bindViewData(mPlaceData);

        toolbar.setBackgroundColor(mPlaceData.getColorBarRs());
        txtTitle.setTextColor(mPlaceData.getColorBarRs());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonPhone:
                startActivity(this.generateCommunication(INTENT_TYPE_DIAL));
                break;
            case R.id.imageButtonMap:
                startActivity(this.generateCommunication(INTENT_TYPE_MAP));
                break;
            case R.id.imageButtonWeb:
                startActivity(this.generateCommunication(INTENT_TYPE_WEB));
                break;
        }
    }


    private Intent generateCommunication(int intentType) {
        Intent intent = null;
        switch (intentType) {
            case INTENT_TYPE_MAP:
                Uri mapGeo = Uri.parse("geo:" + mPlaceData.getLatitude() + "," + mPlaceData.getLongitude() + "?q=" + mPlaceData.getLatitude() + "," + mPlaceData.getLongitude() + "(" + mPlaceData.getCardPlaName() + ")");
                intent = new Intent(Intent.ACTION_VIEW, mapGeo);
                intent.setPackage("com.google.android.apps.maps");
                break;
            case INTENT_TYPE_DIAL:
                Uri number = Uri.parse("tel:" + mPlaceData.getPhone());
                intent = new Intent(Intent.ACTION_DIAL, number);
                break;
            case INTENT_TYPE_WEB:
                intent = new Intent(this, DetailPlaceWebActivity.class);
                intent.putExtra(EXTRA_COLOR_BAR,mPlaceData.getColorBarRs());
                intent.putExtra(KEY_WEB_URL, mPlaceData.getSiteUrl());
                break;
        }
        return intent;
    }


    private void bindViewData(CardItem item) {
        txtDescription.setText(item.getDescription());
        txtTitle.setText(item.getCardPlaName());
        imgLogo.setImageResource(item.getLogo());
        imgPlace.setImageResource(item.getCardImgRs());
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

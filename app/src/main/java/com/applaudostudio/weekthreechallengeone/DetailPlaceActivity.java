package com.applaudostudio.weekthreechallengeone;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
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

    TextView txtTitle;
    TextView txtDescription;
    ImageView imgLogo;
    ImageView imgPlace;
    ImageButton btnPhone;
    ImageButton btnWeb;
    ImageButton btnMaps;
    CardItem mPlaceData;


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
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        Intent i = getIntent();
        mPlaceData = i.getParcelableExtra(ListFragment.EXTRA_ARG);
        this.bindViewData(mPlaceData);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonPhone:
                startActivity(this.phoneFactoryMethod());
                break;
            case R.id.imageButtonMap:
                startActivity(this.mapFactoryMethod());
                break;
            case R.id.imageButtonWeb:
                startActivity(this.webFactoryMethod());
                break;
        }
    }


    //FACTORY METHODS

    private Intent mapFactoryMethod() {
        Intent intent;
        Uri mapGeo = Uri.parse("geo:" + mPlaceData.getLongitude() + "," + mPlaceData.getLatitude() + "?q=" + mPlaceData.getLongitude() + "," + mPlaceData.getLatitude() + "(" + mPlaceData.getCardPlaName() + ")");
        intent = new Intent(Intent.ACTION_VIEW, mapGeo);
        intent.setPackage("com.google.android.apps.maps");
        return intent;
    }


    private Intent phoneFactoryMethod() {
        Intent intent;
        Uri number = Uri.parse("tel:" + mPlaceData.getPhone());
        intent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(intent);
        return intent;
    }

    private Intent webFactoryMethod() {
        Intent intent;
        intent = new Intent(this, DetailPlaceWeb.class);
        intent.putExtra(KEY_WEB_URL, mPlaceData.getSiteUrl());
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

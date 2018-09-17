package com.applaudostudio.weekthreechallengeone;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.applaudostudio.weekthreechallengeone.model.CardItem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CATEGORY_FILTER_FOOD = 1;
    private static final int CATEGORY_FILTER_ARCHAEOLOGY = 2;
    private static final int CATEGORY_FILTER_CITY = 3;
    private static final int CATEGORY_FILTER_MOUNTAIN = 4;
    private static final int CATEGORY_FILTER_BEACH = 5;


    private DrawerLayout mDrawerLayout;
    private List<CardItem> mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_icons8_menu);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()) {
                            case R.id.nav_food:
                                toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_FOOD));
                                initFragment(CATEGORY_FILTER_FOOD);
                                break;
                            case R.id.nav_archaeology:
                                toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_ARCHAEOLOGY));
                                initFragment(CATEGORY_FILTER_ARCHAEOLOGY);
                                break;
                            case R.id.nav_city:
                                toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_CITY));
                                initFragment(CATEGORY_FILTER_CITY);
                                break;
                            case R.id.nav_mountain:
                                toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_MOUNTAIN));
                                initFragment(CATEGORY_FILTER_MOUNTAIN);
                                break;
                            case R.id.nav_beach:
                                toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_BEACH));
                                initFragment(CATEGORY_FILTER_BEACH);
                                break;
                        }


                        return true;
                    }
                });
        toolbar.setBackgroundColor(getIdRsColorByCategory(CATEGORY_FILTER_FOOD));
        initFragment(CATEGORY_FILTER_FOOD);
    }

    public void initFragment(int filterType) {
        FragmentManager manager = getSupportFragmentManager();
        List<CardItem> filteredData = new ArrayList<>();
        for(CardItem itemData : mDataSet){
            if(itemData.getFilterCategory()==filterType){
                filteredData.add(itemData);
            }
        }
        Fragment fragment = ListFragment.newInstance(filteredData);
        FragmentTransaction transaction = manager.beginTransaction();
        assert fragment != null;
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }

    private void initData() {
        mDataSet = new ArrayList<>();

        Resources res = getResources();
        TypedArray ta = res.obtainTypedArray(R.array.Places);
        int n = ta.length();
        String[][] array = new String[n][];
        for (int i = 0; i < n; ++i) {
            int id = ta.getResourceId(i, 0);
            if (id > 0) {
                array[i] = res.getStringArray(id);
            }
        }

            for(String[] data:array){
                CardItem itemData= new CardItem();
                itemData.setFilterCategory(Integer.parseInt(data[0]));
                itemData.setCardPlaName(data[1]);
                itemData.setDescription(data[2]);
                itemData.setPhone(data[3]);
                itemData.setSiteUrl(data[4]);
                itemData.setLatitude(data[5]);
                itemData.setLongitude(data[6]);
                String[] splitLogo=data[7].split("/");
                itemData.setLogo(getResources().getIdentifier(splitLogo[2].split(Pattern.quote("."))[0],
                        "drawable", getPackageName()));
                String[] splitImg=data[8].split("/");
                itemData.setCardImgRs(getResources().getIdentifier(splitImg[2].split(Pattern.quote("."))[0],
                        "drawable", getPackageName()));
                itemData.setColorBarRs(getIdRsColorByCategory(itemData.getFilterCategory()));
                mDataSet.add(itemData);
            }
        ta.recycle();
    }

    private int getIdRsColorByCategory(int category){
        switch (category){
            case CATEGORY_FILTER_FOOD:
                return R.color.foodColor;
            case CATEGORY_FILTER_ARCHAEOLOGY:
                return R.color.archaeologyColor;

            case CATEGORY_FILTER_CITY:
                return R.color.cityColor;

            case CATEGORY_FILTER_MOUNTAIN:
                return R.color.mountainColor;

            case CATEGORY_FILTER_BEACH:
                return R.color.beachColor;

            default:
                return R.color.colorAccent;

        }
    }


}

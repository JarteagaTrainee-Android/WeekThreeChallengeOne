package com.applaudostudio.weekthreechallengeone;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.applaudostudio.weekthreechallengeone.model.CardItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CATEGORY_FILTER_FOOD = 1;
    private static final int CATEGORY_FILTER_ARCHAEOLOGY = 2;
    private static final int CATEGORY_FILTER_CITY = 3;
    private static final int CATEGORY_FILTER_MOUNTAIN = 4;
    private static final int CATEGORY_FILTER_BEACH = 5;


    private DrawerLayout mDrawerLayout;
    private List<CardItem> mDataSet;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
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
                                initFragment(CATEGORY_FILTER_FOOD);
                                break;
                            case R.id.nav_archaeology:
                                initFragment(CATEGORY_FILTER_ARCHAEOLOGY);
                                break;
                            case R.id.nav_city:
                                initFragment(CATEGORY_FILTER_CITY);
                                break;
                            case R.id.nav_mountain:
                                initFragment(CATEGORY_FILTER_MOUNTAIN);
                                break;
                            case R.id.nav_beach:
                                initFragment(CATEGORY_FILTER_BEACH);
                                break;
                        }


                        return true;
                    }
                });
        initFragment(CATEGORY_FILTER_FOOD);
    }

    public void initFragment(int filterType) {
        manager = getSupportFragmentManager();

        Fragment fragment = ListFragment.newInstance(mDataSet);
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
        CardItem itemd = new CardItem();
        itemd.setFilterCategory(1);
        itemd.setCardPlaName("Lugar 1");
        itemd.setPhone("2222-2222");
        itemd.setDescription("DESCRIPCION 1");
        itemd.setColorBarRs(R.color.listBackColor);
        itemd.setCardImgRs(R.drawable.ic_launcher_background);
        itemd.setLogo(R.drawable.ic_launcher_foreground);
        itemd.setLatitude("13.6929403");
        itemd.setLongitude("-89.2181911");
        itemd.setSiteUrl("https://www.google.com");
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);

        itemd.setFilterCategory(2);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        itemd.setFilterCategory(3);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        itemd.setFilterCategory(4);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        itemd.setFilterCategory(5);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);


    }

}

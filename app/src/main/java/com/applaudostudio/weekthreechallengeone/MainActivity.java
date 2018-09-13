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

    private DrawerLayout mDrawerLayout;
    private List<CardItem> mDataSet;

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
                        FragmentManager manager = getSupportFragmentManager();
                        Fragment fragment = null;
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()) {
                            case R.id.nav_food:
                                fragment= ListFragment.newInstance(mDataSet);
                                break;
                            case R.id.nav_archaeology:
                                fragment= ListFragment.newInstance(mDataSet);

                                break;
                            case R.id.nav_city:
                                fragment= ListFragment.newInstance(mDataSet);

                                break;
                            case R.id.nav_mountain:
                                fragment= ListFragment.newInstance(mDataSet);

                                break;
                            case R.id.nav_beach:
                                fragment= ListFragment.newInstance(mDataSet);

                                break;
                        }
                        FragmentTransaction transaction = manager.beginTransaction();
                        assert fragment != null;
                        transaction.replace(R.id.content_frame, fragment);
                        transaction.commit();

                        return true;
                    }
                });


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

    private void initData(){
        mDataSet=new ArrayList<>();
        CardItem itemd = new CardItem();
        itemd.setCardPlaName("Lugar 1");
        itemd.setDescription("DESCRIPCION 1");
        itemd.setColorBarRs(R.color.secondaryColor);
        itemd.setCardImgRs(R.drawable.ic_launcher_background);
        itemd.setLogo(R.drawable.ic_launcher_foreground);
        itemd.setLatitude("13.6929403");
        itemd.setLongitud("-89.21819110000001");
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);
        mDataSet.add(itemd);

    }

}

package com.applaudostudio.weekthreechallengeone;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] planets;
    Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();
        planets = res.getStringArray(R.array.planets_array);
    }
}

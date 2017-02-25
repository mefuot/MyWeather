package com.pong.myweather.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pong.myweather.R;
import com.pong.myweather.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            openSearchFragment();
        }
    }

    private void openSearchFragment() {
        searchFragment = new SearchFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, searchFragment);
        ft.commit();
    }
}

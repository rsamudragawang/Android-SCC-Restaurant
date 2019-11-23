package com.scc.myrestaurant.activity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.scc.myrestaurant.R;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabIndicator;
    MaterialSearchView searchView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_wong:
            case R.id.nav_home:
            case R.id.navigation_cart:
            case R.id.navigation_email:
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitleTextColor(Color.parseColor("#FF4057"));

            searchView = (MaterialSearchView) findViewById(R.id.action_search);
        }


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = findViewById(R.id.view_pager);
        tabIndicator = findViewById(R.id.tab_main_indicator);
        searchView = findViewById(R.id.action_search);

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);

        viewPager.setAdapter(mainViewPagerAdapter);
        tabIndicator.setupWithViewPager(viewPager);




    }
}

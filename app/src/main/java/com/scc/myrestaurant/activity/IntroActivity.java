package com.scc.myrestaurant.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.scc.myrestaurant.R;
import com.scc.myrestaurant.model.ScreenItem;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenpager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btn_skip, btn_prev, btn_getstarted;
    LinearLayout linearLayoutSkip, linearLayoutPrev,linearLayoutGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorePreData()){
            Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(MainActivity);
            finish();
        }
        setContentView(R.layout.activity_intro);

        btn_skip = findViewById(R.id.btn_skip);
        btn_prev = findViewById(R.id.btn_prev);
        btn_getstarted = findViewById(R.id.btn_get_started);

        linearLayoutSkip = findViewById(R.id.linear_layout_skip);
        linearLayoutPrev = findViewById(R.id.linear_layout_prev);
        linearLayoutGetStarted = findViewById(R.id.linear_layout_get_started);

        tabIndicator = findViewById(R.id.tab_indicator);

        // Fill data description

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("ADD TO CHART", "Pilih makanan dan minuman kesukaanmu, tambahkan ke keranjang untuk memesannya dengan mudah.", R.drawable.chart));
        mList.add(new ScreenItem("PAYMENT", "Cukup sekali klik, anda bisa membayar tagihan pesanan tanpa melalui genggaman tangan.", R.drawable.payment));
        mList.add(new ScreenItem("SIT DOWN", "Anda hanya tinggal duduk manis dan bersantai, menunggu pesanan yang akan diantarkan ke meja anda", R.drawable.sitdown));


        // Setup ViewPager
        screenpager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenpager.setAdapter(introViewPagerAdapter);

        // Setup tab indicator
        tabIndicator.setupWithViewPager(screenpager);

        // Button Skip
        btn_skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                screenpager.setCurrentItem(screenpager.getCurrentItem()+1, true);
            }
        });

        // Button Prev
        btn_prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                screenpager.setCurrentItem(screenpager.getCurrentItem()-1,true);
                linearLayoutGetStarted.setVisibility(View.INVISIBLE);
                linearLayoutSkip.setVisibility(View.VISIBLE);
            }
        });




        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Button Get Started
        btn_getstarted.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);

                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePreData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);

        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }

    private void loadLastScreen(){
        linearLayoutSkip.setVisibility(View.INVISIBLE);
        linearLayoutGetStarted.setVisibility(View.VISIBLE);
    }
}

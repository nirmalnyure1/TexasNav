package com.example.texas;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class EventActivity extends AppCompatActivity {
    ImageView arrowback;
    ViewPager viewPager;
    TabLayout tabLayout;

    PagerAdapter pagerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

     viewPager=(ViewPager)findViewById(R.id.event_view_pager);
     tabLayout=(TabLayout)findViewById(R.id.event_tab_layout);

     arrowback=(ImageView)findViewById(R.id.arrowback);

     pagerAdapter=new PagerAdapter(getSupportFragmentManager());
     pagerAdapter.addFragment(new AcedemicFragment(),"Acedemic");
     pagerAdapter.addFragment(new SportFragment(),"Sport");
     pagerAdapter.addFragment(new ToursFragment(),"Tours");

     viewPager.setAdapter(pagerAdapter);
     tabLayout.setupWithViewPager(viewPager);

     arrowback.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            startActivity(new Intent(EventActivity.this,MainActivity.class));
            finish();
         }
     });



    }

}

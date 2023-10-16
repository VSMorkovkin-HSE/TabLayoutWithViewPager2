package com.example.tablayoutwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Fragment1.newInstance());
        fragmentList.add(Fragment2.newInstance());
        fragmentList.add(Fragment3.newInstance());

        List<String> tabTitles = new ArrayList<>();
        tabTitles.add("Tab1");
        tabTitles.add("Tab2");
        tabTitles.add("Tab3");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragmentList);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        viewPager2.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
                (tab, pos) -> {
                    tab.setText(tabTitles.get(pos));
                }
        );
        tabLayoutMediator.attach();

    }
}
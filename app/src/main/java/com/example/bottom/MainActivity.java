package com.example.bottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpage;
    BottomNavigationView bottomnav;
    List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpage = findViewById(R.id.vp);
         bottomnav = findViewById(R.id.bon);

     initData();

     ContentPagerAdapter adapter = new ContentPagerAdapter(this,fragmentList);
     viewpage.setAdapter(adapter);

     viewpage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             super.onPageScrolled(position, positionOffset, positionOffsetPixels);
         }

         @Override
         public void onPageSelected(int position) {
             super.onPageSelected(position);
             bottomnav.getMenu().getItem(position).setChecked(true);

         }

         @Override
         public void onPageScrollStateChanged(int state) {
             super.onPageScrollStateChanged(state);
         }
     });

     bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             switch (item.getItemId()) {

                 case R.id.item_share:
                     viewpage.setCurrentItem(0);
                     break;
                 case R.id.item_mycollect:
                     viewpage.setCurrentItem(1);
                     break;
                 case R.id.item_edit:
                     viewpage.setCurrentItem(2);
                     break;
                 case R.id.item_del:
                     viewpage.setCurrentItem(3);
                     break;
             }
                     return true;

             }
     });

    }
    private void initData(){
        fragmentList.add(new shareFragment());
        fragmentList.add(new mycollectFragment());
        fragmentList.add(new editFragment());
        fragmentList.add(new delFragment());
    }
}
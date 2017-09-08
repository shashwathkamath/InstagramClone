package com.example.android.instagramclone.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.instagramclone.R;
import com.example.android.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.android.instagramclone.Utils.SectionPagerAdapter;
import com.example.android.instagramclone.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private Context mContext= HomeActivity.this;
    private static final int ACTIVITY_NUM= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageLoader();
        setupBottomNavigationView();
        setupViewPager();
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader= new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfiguration());
    }

    /**
     * Responsible for adding 3 tabs: Camera, Home, Messages
     * */
    public void setupViewPager(){
        SectionPagerAdapter sectionPagerAdapter= new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragments(new CameraFragment());
        sectionPagerAdapter.addFragments(new HomeFragment());
        sectionPagerAdapter.addFragments(new MessageFragment());
        ViewPager viewPager= (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionPagerAdapter);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

    //Bottom Navigation setup
    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu= bottomNavigationViewEx.getMenu();
        MenuItem menuItem= menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}

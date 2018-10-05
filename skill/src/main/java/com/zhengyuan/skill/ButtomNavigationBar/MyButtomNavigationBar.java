package com.zhengyuan.skill.ButtomNavigationBar;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zhengyuan.skill.R;

/**
 * Created by Administrator on 2018/10/6.
 */

public class MyButtomNavigationBar extends Activity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private String TAG = MyButtomNavigationBar.class.getSimpleName();

    private LocationFragment mLocationFragment;
    private FindFragment mFindFragment;
    private FavoritesFragment mFavoritesFragment;
    private BookFragment mBookFragment;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bottomnavigationbar);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.tab_home_selector, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.tab_attention_selector, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.tab_discovery_selector, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.tab_attention_selector, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.tab_profile_selector, "Games"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

        initFragment();//默认选择第一个Fragment
    }

    @Override
    public void onTabSelected(int position) {
        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance("位置");
                }
                transaction.replace(R.id.tb, mLocationFragment);
                break;
            case 1:
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.newInstance("发现");
                }
                transaction.replace(R.id.tb, mFindFragment);
                break;
            case 2:
                if (mFavoritesFragment == null) {
                    mFavoritesFragment = FavoritesFragment.newInstance("爱好");
                }
                transaction.replace(R.id.tb, mFavoritesFragment);
                break;
            case 3:
                if (mBookFragment == null) {
                    mBookFragment = BookFragment.newInstance("图书");
                }
                transaction.replace(R.id.tb, mBookFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
    }

    @Override
    public void onTabReselected(int position) {

    }

    private void initFragment() {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        if (mLocationFragment == null) {
            mLocationFragment = LocationFragment.newInstance("位置");
        }
        transaction.replace(R.id.tb, mLocationFragment);
        // 事务提交
        transaction.commit();
    }
}

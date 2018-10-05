package com.zhengyuan.skill;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2018/10/6.
 */

public class TabLayoutActivity extends Activity {
    private TabLayout mTabLayout;
    private Fragment[] mFragmensts;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tablayout);
        mFragmensts = TabLayoutDataGenerator.getFragments("TabLayout Tab");
        initView();
        initEvent();
    }

    private void initView() {

    }

    private void initEvent() {

    }
}

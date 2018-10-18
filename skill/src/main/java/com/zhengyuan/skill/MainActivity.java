package com.zhengyuan.skill;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.zhengyuan.skill.ButtomNavigationBar.MyButtomNavigationBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editview1;
    private Toolbar mNormalToolbar;

    private Button TabLayout;
    private Button BottomNavigationView;
    private Button BottomNavigationBar;
    private Button popipwindow;
    private Button mTakePhotoAndSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.TabLayout:
                intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.BottomNavigationView:
                intent = new Intent(MainActivity.this, ButtonNavigationActivity.class);
                startActivity(intent);
                break;
            case R.id.BottomNavigationBar:
                intent = new Intent(MainActivity.this, MyButtomNavigationBar.class);
                startActivity(intent);
                break;
            case R.id.popipwindow:
                intent = new Intent(MainActivity.this, PopipWindow.class);
                startActivity(intent);
                break;

            case R.id.takePhotoAndSave:
                intent = new Intent(MainActivity.this, TakePhotoAndSave.class);
                startActivity(intent);
                break;
        }
    }

    private void initView() {
        //显示顶部的toolBar
        mNormalToolbar = (Toolbar) findViewById(R.id.toolbar_normal);
        //设置图标和文字
        // Logo
        mNormalToolbar.setLogo(R.mipmap.ic_launcher);
        // 主标题
        mNormalToolbar.setTitle("主标题");
        // 副标题
        mNormalToolbar.setSubtitle("副标题");
        //设置menu
        mNormalToolbar.inflateMenu(R.menu.menu_normal);
        // 左边的小箭头
        mNormalToolbar.setNavigationIcon(R.mipmap.down);


        editview1 = (EditText) findViewById(R.id.editview1);
        Drawable drawable = getResources().getDrawable(R.drawable.error16);
        // 设置编辑框提示的图片大小
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        editview1.setError("请输入手机号", drawable);

        //测试底部导航栏
        TabLayout = (Button) findViewById(R.id.TabLayout);
        BottomNavigationView = (Button) findViewById(R.id.BottomNavigationView);
        BottomNavigationBar = (Button) findViewById(R.id.BottomNavigationBar);
        popipwindow = (Button) findViewById(R.id.popipwindow);
        mTakePhotoAndSave = (Button) findViewById(R.id.takePhotoAndSave);
    }

    private void initEvent() {

        TabLayout.setOnClickListener(this);
        BottomNavigationView.setOnClickListener(this);
        BottomNavigationBar.setOnClickListener(this);
        popipwindow.setOnClickListener(this);
        mTakePhotoAndSave.setOnClickListener(this);
        initToolbar();
    }

    private void initToolbar() {

        //设置menu的点击事件
        mNormalToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(MainActivity.this, "11", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_notification) {
                    Toast.makeText(MainActivity.this, "22", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item_one) {
                    Toast.makeText(MainActivity.this, "33", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item_two) {
                    Toast.makeText(MainActivity.this, "44", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
        //设置左侧NavigationIcon点击事件
        mNormalToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了左侧按钮", Toast.LENGTH_SHORT).show();
            }
        });


    }


}

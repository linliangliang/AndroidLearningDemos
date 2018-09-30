package com.zhengyuan.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //显示圆形进度条
    private Loading_view loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showProgremmer();
    }

    private void showProgremmer() {//显示进度条
        loading = new Loading_view(this, R.style.CustomDialog);
        loading.show();
    }

    private void closeProgremmer() {//关闭进度条
        loading.dismiss();
    }

}

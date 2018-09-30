package com.zhengyuan.skill;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        editview1 = (EditText) findViewById(R.id.editview1);

        Drawable drawable = getResources().getDrawable(R.drawable.error16);
        // 设置图片大小
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        editview1.setError("请输入手机号", drawable);
    }

    private void initEvent() {

    }
}

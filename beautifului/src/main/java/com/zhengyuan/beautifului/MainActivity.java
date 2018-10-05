package com.zhengyuan.beautifului;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

        EditText textView = findViewById(R.id.EditText2);
        DrawableUtil drawableUtil = new DrawableUtil(textView, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onLeft(View v, Drawable left) {
                Toast.makeText(getApplicationContext(), "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRight(View v, Drawable right) {
                Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        showDialogButton = findViewById(R.id.button2);
    }

    private void initEvent() {
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MyDialog1 myDialog1 = new MyDialog1(MainActivity.this);
                myDialog1.setTitle("提示");
                myDialog1.setMessage("确定退出应用?");
                myDialog1.setYesOnclickListener("确定", new MyDialog1.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        Toast.makeText(MainActivity.this, "点击了--确定--按钮", Toast.LENGTH_LONG).show();
                        myDialog1.dismiss();
                    }
                });
                myDialog1.setNoOnclickListener("取消", new MyDialog1.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        Toast.makeText(MainActivity.this, "点击了--取消--按钮", Toast.LENGTH_LONG).show();
                        myDialog1.dismiss();
                    }
                });
                myDialog1.show();

            }
        });
    }
}

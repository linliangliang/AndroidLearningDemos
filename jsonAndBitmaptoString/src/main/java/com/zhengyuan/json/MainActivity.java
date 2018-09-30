package com.zhengyuan.json;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhengyuan.json.entity.User;
import com.zhengyuan.json.util.BitmapAndStringUtils;
import com.zhengyuan.json.util.logUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView image1;
    private ImageView image2;
    BitmapAndStringUtils bitmapAndStringUtils = new BitmapAndStringUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

        testJson();//使用Gson
        testBitmapToString();//自定义类
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image1:
                Bitmap bitmap = ((BitmapDrawable) image1.getDrawable()).getBitmap();
                String string = bitmapAndStringUtils.convertIconToString(bitmap);
                logUtil.i("convertIconToString", string);
                bitmapAndStringUtils.convertStringToIcon(string);
                image2.setImageBitmap(bitmapAndStringUtils.convertStringToIcon(string));
                break;
        }
    }

    private void initView() {
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
    }

    private void initEvent() {
        image1.setOnClickListener(this);
    }

    private void testJson() {

        User user1 = new User("linliang", "123455");
        User user2 = new User("linliang", "123456");
        User user3 = new User("linliang", "123457");

        //测试对象lsit to jsonString
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Gson g = new Gson();

        String json1 = g.toJson(userList);
        logUtil.i("jsontest", json1);


        Map<String, String> map = new HashMap<String, String>();
        map.put("111", "111");
        map.put("112", "112");
        map.put("113", "113");
        map.put("114", "114");
        map.put("115", "115");

        String mapString = g.toJson(map);
        logUtil.i("mapString", mapString);

        String[] array = {"11", "22", "33"};
        String arrayString = g.toJson(array);
        logUtil.i("arrayString", arrayString);
    }

    private void testBitmapToString() {

    }
}

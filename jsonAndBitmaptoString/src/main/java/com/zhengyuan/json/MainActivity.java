package com.zhengyuan.json;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
        //序列化
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
        map.put("111", "1111");
        map.put("112", "1122");
        map.put("113", "1133");
        map.put("114", "1144");
        map.put("115", "1155");

        String mapString = g.toJson(map);
        logUtil.i("mapString", mapString);

        String[] array = {"11", "22", "33"};
        String arrayString = g.toJson(array);
        logUtil.i("arrayString", arrayString);

        //反序列化
        List<User> userList2 = g.fromJson(json1, new TypeToken<List<User>>() {
        }.getType());
        logUtil.i("反序列化List", userList2.get(1).toString());

        Map<String, String> usermap = g.fromJson(mapString, Map.class);
        logUtil.i("反序列化Map", usermap.get("111"));
        logUtil.i("反序列化Map", usermap.get("115"));

        String[] userString2 = g.fromJson(arrayString, String[].class);
        logUtil.i("反序列化String[]", userString2[1]);

    }

    private void testBitmapToString() {

    }
}

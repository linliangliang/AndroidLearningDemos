package com.zhengyuan.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.zhengyuan.json.entity.User;
import com.zhengyuan.json.logutil.logUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}

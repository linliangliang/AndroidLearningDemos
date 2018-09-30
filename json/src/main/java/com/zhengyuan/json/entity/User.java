package com.zhengyuan.json.entity;

/**
 * Created by Administrator on 2018/9/30.
 */

public class User {
    private String userName;
    private String password;

    public User() {

    }

    public User(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String mUserName) {
        this.userName = mUserName;
    }

    public void setPassword(String mPassword) {
        this.password = mPassword;
    }
}

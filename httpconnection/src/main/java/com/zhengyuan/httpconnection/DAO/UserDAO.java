package com.zhengyuan.httpconnection.DAO;

import com.zhengyuan.httpconnection.model.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/9/25.
 */

public class UserDAO {
    public static void main(String[] args) {
        //本地验证Main函数
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.isLoginOK("123456", "abc123456"));
    }

    //假设的数据源
    public ArrayList<User> users;

    public UserDAO() {
        // TODO Auto-generated constructor stub
        users = new ArrayList<User>();
        users.add(new User("123456", "abc123456", "codingma"));
        users.add(new User("654321", "abcdf123", "codemayq"));
    }

    //验证函数
    public boolean isLoginOK(String phoneNumber, String password) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}

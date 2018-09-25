package com.zhengyuan.httpconnection;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhengyuan.httpconnection.model.User;

import java.util.HashMap;

/**
 * 1.获取登录信息
 * 2.验证登录信息
 * 3.获取URL
 * 4.建立连接
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPhoneNumberEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private Button mSignInBuyyon;
    //忘记密码部分没写
    //用于接收Http请求的servlet的URL地址，请自己定义
    private String originAddress = "http://59.175.173.136:9080/EMTest/servlet/LoginServlet";
    //用于处理消息的Handler
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = "";

            if ("OK".equals(msg.obj.toString())){
                result = "success";
            }else if ("Wrong".equals(msg.obj.toString())){
                result = "fail";
            }else {
                result = msg.obj.toString();
            }
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //透明状态栏          
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        initView();
        initEvent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainLoginButton:
                //login();
                break;
            case R.id.mainSignInButton:
                break;
        }
    }

    private void initView() {
        mPhoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        mPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
        mLoginButton = (Button) findViewById(R.id.mainLoginButton);
        mSignInBuyyon = (Button) findViewById(R.id.mainSignInButton);
    }

    private void initEvent() {
        mLoginButton.setOnClickListener(this);
    }

    private boolean login() {
        //检查用户输入的账号和密码的合法性
        if (!isInputValid()) {
            return false;
        }
        //构造HashMap
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(User.PHONENUMBER, mPhoneNumberEditText.getText().toString());
        params.put(User.PASSWORD, mPasswordEditText.getText().toString());
        try {
            //构造完整URL
            String compeletedURL = HttpUtil.getURLWithParams(originAddress, params);
            //发送请求
            HttpUtil.sendHttpRequest(compeletedURL, new HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    Message message = new Message();
                    message.obj = response;
                    mHandler.sendMessage(message);
                }

                @Override
                public void onError(Exception e) {
                    Message message = new Message();
                    message.obj = e.toString();
                    mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isInputValid() {
        //检测输入的完整性
        return false;
    }
}

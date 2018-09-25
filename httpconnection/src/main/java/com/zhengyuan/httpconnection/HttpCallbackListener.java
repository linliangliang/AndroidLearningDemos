package com.zhengyuan.httpconnection;

/**
 * Created by Administrator on 2018/9/21.
 */

//请求回调接口
public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);
}
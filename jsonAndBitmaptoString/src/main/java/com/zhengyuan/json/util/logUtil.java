package com.zhengyuan.json.util;

import android.util.Log;

/**
 * Created by Administrator on 2018/9/30.
 */

public class logUtil {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    //开发时==verbose==1，上先后level==nothing，这样if判断就会跳出，上线后就不会打印日志了
    public static final int NOTHING = 6;
    public static final int LEVEL = VERBOSE;

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL < ERROR) {
            Log.e(tag, msg);
        }
    }

}

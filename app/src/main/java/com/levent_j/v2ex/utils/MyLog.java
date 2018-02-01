package com.levent_j.v2ex.utils;

import android.util.Log;

import io.reactivex.schedulers.Schedulers;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class MyLog {
    private static final String COMMON_TAG="v2ex-debug";

    public static final void d(String TAG, String message){
        Log.d(TAG,packMessage(message));
    }

    private static String packMessage(String message) {
        String result = "[ v2ex-demo|message: "+message+" ]";
        return result;
    }

    public static final void d(String message){
        d(COMMON_TAG,message);
    }
}

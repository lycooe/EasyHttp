package com.lewis.magicalhttp.samples;

import android.app.Application;

import com.lewis.magicalhttp.request.Easy;
import com.lewis.magicalhttp.tools.EasyLog;

/**
 *
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Easy.init(getApplicationContext());
        EasyLog.setDebugMode(true);
    }
}

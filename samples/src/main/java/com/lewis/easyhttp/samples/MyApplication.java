package com.lewis.easyhttp.samples;

import android.app.Application;

import com.lewis.easyhttp.request.Easy;
import com.lewis.easyhttp.tools.EasyLog;

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

package com.lz.easyhttp.samples;

import android.app.Application;

import com.lz.easyhttp.request.Easy;
import com.lz.easyhttp.tools.EasyLog;

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

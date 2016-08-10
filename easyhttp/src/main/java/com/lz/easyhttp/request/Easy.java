package com.lz.easyhttp.request;

import android.content.Context;
import android.util.Log;

import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadHelper;
import com.lz.easyhttp.db.EasyKvDb;
import com.lz.easyhttp.tools.CheckTool;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * 网络操作入口
 */
public class Easy {

    /**
     * init 方法，需要在application中启动是调用
     *
     * @param context
     */
    public static void init(Context context) {
        EasyKvDb.init(context.getApplicationContext());
        FileDownloader.init(context.getApplicationContext(),
                new FileDownloadHelper.OkHttpClientCustomMaker() { // is not has to provide.
                    @Override
                    public OkHttpClient customMake() {
                        // just for OkHttpClient customize.
                        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        // you can set the connection timeout.
                        builder.connectTimeout(15_000, TimeUnit.MILLISECONDS);
                        // you can set the HTTP proxy.
                        builder.proxy(Proxy.NO_PROXY);
                        // etc.
                        return builder.build();
                    }
                });
    }

    /**
     * 加载
     *
     * @param context 上下文，如果需要弹起转轮，则需要传入Activity
     * @param url     请求的地址
     */
    public static EasyBuilder load(Context context, String url) {
        if (context == null || CheckTool.isEmpty(url)) {
            Log.e("Easy", "context is null or url is null");
            throw new RuntimeException("context is null or url is null");
        }
        if (!EasyKvDb.isInit()) {
            throw new RuntimeException("please call init in application onCreate()");
        }

        return new EasyBuilder(context, url);
    }

    /**
     * 取消当前网络操作
     */
    public static void cancelRequest(String url) {
        EasyRequest.getInstence().cancelRequest(url);
    }

    /**
     * 暂停当前下载
     *
     * @param url
     */
    public static void pauseDownload(String url) {
        EasyDownloadRequest.getInstence().pauseDownload(url);
    }

    /**
     * 暂停全部下载
     */
    public static void pauseAllDownload() {
        EasyDownloadRequest.getInstence().pauseAllDownload();
    }
}

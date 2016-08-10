package com.lz.easyhttp.samples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.lz.easyhttp.request.Easy;
import com.lz.easyhttp.request.EasyDownloadListener;
import com.lz.easyhttp.request.EasyUploadListener;
import com.lz.easyhttp.samples.model.HomeModel;
import com.lz.easyhttp.samples.model.RequestModel;
import com.lz.easyhttp.tools.EasyLog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private ProgressBar progressBar_1;

    private final String downloadUrl = "http://124.202.164.14/files/2147000007F9967E/dl.wandoujia.com/files/phoenix/latest/wandoujia-wandoujia-web_direct_binded.apk";
    private final String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/.easy-download";
    private final String name = "web_direct_binded.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_1 = (ProgressBar) findViewById(R.id.progressBar_1);


        if (!new File(filePath).exists()) {
            new File(filePath).mkdirs();
        }
    }

    public void toRequest(View view) {

        HomeModel.getHome(this, new HomeModel.HomeCallback() {
            @Override
            public void success(HomeModel home) {
                Log.d("=====main====", "home: " + home.toString());
            }
        });
    }


    public void toStart(View view) {
        Easy.load(this, downloadUrl)
                .asDownload(filePath + "/" + name)
                .execute(new EasyDownloadListener() {
                    @Override
                    public void blockComplete(BaseDownloadTask task) {

                    }

                    @Override
                    public void completed(BaseDownloadTask task) {

                    }

                    @Override
                    public void error(BaseDownloadTask task, Throwable e) {

                    }

                    @Override
                    public void warn(BaseDownloadTask task) {

                    }

                    @Override
                    public void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    public void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    public void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }
                });

    }

    public void toPause(View view) {
        Easy.pauseDownload(downloadUrl);

    }

    public void toDelete(View view) {
        new File(filePath + "/" + name).delete();

    }


    public void upload(View view) {
        List<File> files = new ArrayList<File>();
        String name1 = "/storage/emulated/0/DCIM/Camera/IMG_20160704_112613.jpg";
        String name2 = "/storage/emulated/0/DCIM/Camera/IMG_20160704_112611.jpg";
        String name3 = "/storage/emulated/0/DCIM/Camera/IMG_20160704_112609.jpg";
        String name4 = "/storage/emulated/0/DCIM/Camera/IMG_20160704_112608.jpg";
        String name5 = "/storage/emulated/0/DCIM/Camera/IMG_20160704_112607.jpg";
        files.add(new File(name1));
        files.add(new File(name2));
        files.add(new File(name3));
        files.add(new File(name4));
        files.add(new File(name5));

        Easy.load(MainActivity.this, "http://1fd.mrocker.com/home/api/upload")
                .barCanCancel()
                .asUploadFile(files)
                .executeAsync("bin", new EasyUploadListener<RequestModel<String>>() {
                    @Override
                    public void netError() {
                        Log.d("======upload=====", "netError");
                    }

                    @Override
                    public void success(File file, RequestModel<String> result, Map<String, List<String>> headerMap) {

                        Log.d("======success======", "file: "+file.getPath()+" result: "+result.data);
                    }

                    @Override
                    public void cancel(File file) {
                        EasyLog.d("======cancel======", "file: "+file.getPath());
                    }

                    @Override
                    public void error(File file, Throwable e, int code, String error, String result) {
                        EasyLog.d("======error======", "file: "+file.getPath() + " error: "+error);
                    }
                });



    }



    /*new EasyDownloadListener() {
                    @Override
                    public void blockComplete(BaseDownloadTask baseDownloadTask) {
                        Log.d("=======blockComplete====", "baseDownloadTask: " + baseDownloadTask.getUrl());

                    }

                    @Override
                    public void completed(BaseDownloadTask baseDownloadTask) {
                        Log.d("=======completed====", "baseDownloadTask: " + baseDownloadTask.getUrl());

                    }

                    @Override
                    public void error(BaseDownloadTask baseDownloadTask, Throwable throwable) {
                        Log.d("=======error====", "baseDownloadTask: " + baseDownloadTask.getUrl() + " throwable: " + throwable.getMessage());

                    }

                    @Override
                    public void warn(BaseDownloadTask baseDownloadTask) {
                        Log.d("=======warn====", "baseDownloadTask: " + baseDownloadTask.getUrl());

                    }

                    @Override
                    public void pending(BaseDownloadTask baseDownloadTask, int i, int i1) {
                        progressBar_1.setMax(i1);
                        Log.d("=======pending====", "baseDownloadTask: " + baseDownloadTask.getUrl() + " i: " + " i1: " + i1);

                    }

                    @Override
                    public void progress(BaseDownloadTask baseDownloadTask, int i, int i1) {
                        progressBar_1.setMax(i1);
                        progressBar_1.setProgress(i);
                        Log.d("=======progress====", "baseDownloadTask: " + baseDownloadTask.getUrl() + " i: " + i + " i1: " + i1);
                    }

                    @Override
                    public void paused(BaseDownloadTask baseDownloadTask, int i, int i1) {
                        Log.d("=======paused====", "baseDownloadTask: " + baseDownloadTask.getUrl() + " i: " + " i1: " + i1);

                    }
                }*/

}

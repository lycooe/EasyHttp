package com.lewis.magicalhttp.samples.model;

import android.app.Activity;
import android.util.Log;

import com.lewis.magicalhttp.request.Easy;
import com.lewis.magicalhttp.request.EasyLoadingListener;

import java.util.List;
import java.util.Map;

public class HomeModel {
    public int id;

    public String json;

    public List<BannerModel> banner;
    public List<CourseList> recommends;

    public class CourseList {
        public int id;
        public int categoryId;
        public String title;
        public List<CourseListModel.Course> courses;
    }

    public static void getHome(Activity activity, final HomeCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback 不能为空");
        }

        Easy.load(activity, "http://app.ohwit.com/i/app/home")
                .barCanCancel()
                .barCanFinish()
                .asGet(null)
                .executeAsync(new EasyLoadingListener<RequestModel<HomeModel>>() {
                    @Override
                    public void netError() {

                        Log.d("=======", "netError");
                    }

                    @Override
                    public void success(boolean local, RequestModel<HomeModel> result, Map<String, List<String>> headerMap) {
                        Log.d("======success=", "local: " + local + " headerMap: " + headerMap);
                        callback.success(result.result);
                    }

                    @Override
                    public void error(Throwable e, int code, String error, String result, Map<String, List<String>> headerMap) {
                        Log.d("======error=", "code: " + code + " headerMap: " + headerMap);

                    }
                });
    }

    public interface HomeCallback {
        void success(HomeModel home);
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "id=" + id +
                ", json='" + json + '\'' +
                ", banner=" + banner +
                ", recommends=" + recommends +
                '}';
    }
}

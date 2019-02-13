package com.example.qd.webviewx5;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * author: wu
 * date: on 2019/2/13.
 * describe:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initX5WebView();
    }

    private void initX5WebView() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                if (arg0) {
                    Log.e("=====myApp", " x5WebView内核加载成功" + arg0);
                } else {
                    Log.e("=====myApp", " x5WebView内核加载失败" + arg0);
                }
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}

package com.lxf.handy.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by lxf on 2018/4/20.
 */

public class MyApplication extends Application{

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext(){
        return application;
    }

}

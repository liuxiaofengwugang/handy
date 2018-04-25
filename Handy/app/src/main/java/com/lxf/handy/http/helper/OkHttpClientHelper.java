package com.lxf.handy.http.helper;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by liuxiaofeng  on 2018/4/20.
 * Okhttp帮助类
 */

public class OkHttpClientHelper {

    private final Cache cache;
    private OkHttpClient mClient;
    private final  static  long TIMEOUT = 10000;  //超时时间

    private OkHttpClientHelper(){

        cache = CacheHelper.getInstance().getCache();
    }


    private static OkHttpClientHelper clientHelper;

    public static OkHttpClientHelper getInstance(){
        if(clientHelper==null){
            synchronized (OkHttpClientHelper.class){
                if(clientHelper==null){
                    clientHelper = new OkHttpClientHelper();
                }
            }
        }
        return clientHelper;
    }


    //获取OKHttpClicent对象
    public OkHttpClient getOkHttpClient(){

        if(mClient ==null) {
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .cache(cache)      //设置缓存
                    .build();
        }
        return mClient;
    }
}

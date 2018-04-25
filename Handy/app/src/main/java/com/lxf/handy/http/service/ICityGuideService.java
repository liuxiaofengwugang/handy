package com.lxf.handy.http.service;


import com.lxf.handy.bean.cityguide.CityGuideInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zlc on 2017/2/9.
 */

public interface ICityGuideService {

    @GET("http://news-at.zhihu.com/api/4/news/before/{date}")
    Observable<CityGuideInfo> getTheDaily(@Path("date") String date);

    @GET("api/4/news/latest")
    Observable<CityGuideInfo> getLastDaily();


}

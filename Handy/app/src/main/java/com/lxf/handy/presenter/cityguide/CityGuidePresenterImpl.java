package com.lxf.handy.presenter.cityguide;

import android.util.Log;

import com.lxf.handy.bean.cityguide.CityGuideInfo;
import com.lxf.handy.http.HttpUtils;
import com.lxf.handy.http.helper.RetrofitHelper;
import com.lxf.handy.http.service.ICityGuideService;
import com.lxf.handy.model.cityguide.ICityGuideModel;
import com.lxf.handy.model.cityguide.CityGuideModelImpl;
import com.lxf.handy.view.cityguide.ICityGuideFragment;

import rx.Observable;

/**
 * Created by liuxf on 2018/4/20.
 */

public class CityGuidePresenterImpl implements ICityGuidePresenter {

    private ICityGuideModel zhihuModel;
    private ICityGuideFragment iZhihuFragment;
    public CityGuidePresenterImpl(ICityGuideFragment iZhihuFragment){
        zhihuModel = new CityGuideModelImpl();
        this.iZhihuFragment = iZhihuFragment;
    }


    @Override
    public void getCityGuideInfo(String url,String date) {

        Observable<CityGuideInfo> observable = RetrofitHelper.getService(url, ICityGuideService.class).getTheDaily(date);
        HttpUtils.requestNetByGet(observable, new HttpUtils.OnResultListener<CityGuideInfo>() {
            @Override
            public void onSuccess(CityGuideInfo zhihuInfo) {
                if(zhihuInfo!=null)
                    iZhihuFragment.getCityGuideInfoList(zhihuInfo.date,zhihuInfo.stories);
            }

            @Override
            public void onError(Throwable error, String msg) {
                Log.e("error msg",msg);
            }
        });
    }

    @Override
    public void getLastCityGuideNews(String url) {

        Observable<CityGuideInfo> observable = RetrofitHelper.getService(url, ICityGuideService.class).getLastDaily();
        HttpUtils.requestNetByGet(observable, new HttpUtils.OnResultListener<CityGuideInfo>() {
            @Override
            public void onSuccess(CityGuideInfo zhihuInfo) {
                if(zhihuInfo!=null)
                    iZhihuFragment.getCityGuideInfoList(zhihuInfo.date, zhihuInfo.stories);
            }

            @Override
            public void onError(Throwable error, String msg) {
                Log.e("error msg",msg);
            }
        });
    }
}

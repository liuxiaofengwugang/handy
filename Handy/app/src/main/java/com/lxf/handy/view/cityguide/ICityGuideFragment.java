package com.lxf.handy.view.cityguide;


import com.lxf.handy.bean.cityguide.CityGuideInfo;

import java.util.List;

/**
 * Created by liuxf on 2018/4/20.
 */

public interface ICityGuideFragment {

    void getCityGuideInfoList(String date, List<CityGuideInfo.CityGuideBean> zhihuInfos);

}

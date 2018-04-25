package com.lxf.handy.bean.cityguide;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by lxf on 2018/4/20
 */

public class CityGuideInfo {


    @SerializedName("date")
    public String date;
    @SerializedName("top_stories")
    public ArrayList<CityGuideBean> mZhihuDailyItems;
    @SerializedName("stories")
    public ArrayList<CityGuideBean> stories;

    public static class CityGuideBean{
        @SerializedName("images")
        public String[] images;
        @SerializedName("type")
        public int type;
        @SerializedName("id")
        public String id;
        @SerializedName("title")
        public String title;
        public String date;
        public boolean hasFadedIn = false;
    }

}

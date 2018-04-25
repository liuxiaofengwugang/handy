package com.lxf.handy.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by liuxf on 2018/4/20.
 */
public class ScreenUtil {

    public static int getScreenWidth(Context context){

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context){

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}

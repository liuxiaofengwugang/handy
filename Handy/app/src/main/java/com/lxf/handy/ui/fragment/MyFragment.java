package com.lxf.handy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.handy.R;

/**
 * Created by liuxiaofeng on 2018/4/20.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.shop_fragment, null);
        return view;
    }

    @Override
    public void onDestroy() {
        Log.d("liuxiaofeng","MyFragment is destroying ");
        super.onDestroy();
    }
}

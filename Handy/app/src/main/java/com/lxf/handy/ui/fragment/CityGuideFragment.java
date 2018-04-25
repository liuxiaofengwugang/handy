package com.lxf.handy.ui.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lxf.handy.R;
import com.lxf.handy.adapter.CityGuideAdapter;
import com.lxf.handy.bean.cityguide.CityGuideInfo;
import com.lxf.handy.presenter.cityguide.ICityGuidePresenter;
import com.lxf.handy.presenter.cityguide.CityGuidePresenterImpl;
import com.lxf.handy.util.SwipeRefreshUtil;
import com.lxf.handy.view.custom_view.GridItemDividerDecoration;
import com.lxf.handy.view.cityguide.ICityGuideFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by lxf on 2018/4/20.
 * handy city guide Fragment
 */

public class CityGuideFragment extends BaseFragment implements ICityGuideFragment,SwipeRefreshLayout.OnRefreshListener{

    @InjectView(R.id.id_recycle_city_guide)
    RecyclerView mCityGuideRecycle;
    @InjectView(R.id.id_city_guide_swipe)
    SwipeRefreshLayout mCityGuideSwipe;
    private ICityGuidePresenter cityGuidePresenter;

    private String url = "http://news-at.zhihu.com";

    private String currentLoadDate = "0";
    private CityGuideAdapter mcityGuideAdapter;
    private List<CityGuideInfo.CityGuideBean> cityGuideInfos;
    private LinearLayoutManager linearLayoutManager;
    private boolean loading;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_city_guide, null);
        return view;
    }

    @Override
    public void initData() {

        SwipeRefreshUtil.setSiwpeLayout(mCityGuideSwipe,mActivity,this);
        cityGuideInfos = new ArrayList<>();
        cityGuidePresenter = new CityGuidePresenterImpl(this);
        cityGuidePresenter.getLastCityGuideNews(url);
        setRecycleView();
    }

    private void setRecycleView() {

        mCityGuideRecycle.addItemDecoration(new GridItemDividerDecoration(getContext(), R.dimen.divider_height, R.color.divider_color));
        mCityGuideRecycle.setItemAnimator(new DefaultItemAnimator());
        mCityGuideRecycle.setLayoutManager(linearLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
    }


    @Override
    public void getCityGuideInfoList(String date, List<CityGuideInfo.CityGuideBean> cityGuideInfos) {

        if(cityGuideInfos==null || cityGuideInfos.size()<=0)
            return;
        loading = false;
        mCityGuideSwipe.setRefreshing(false);
        this.cityGuideInfos.addAll(cityGuideInfos);
        this.currentLoadDate = date;
        Log.e("cityGuide info", cityGuideInfos.size() + "");
        if(mcityGuideAdapter==null) {
            mCityGuideRecycle.setAdapter(mcityGuideAdapter = new CityGuideAdapter(mActivity, this.cityGuideInfos));
        }else{
            mcityGuideAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void initListener() {
        super.initListener();
        mCityGuideRecycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0 && linearLayoutManager !=null){
                    int totalCout = linearLayoutManager.getItemCount();
                    int visibleItemCount = linearLayoutManager.getChildCount();
                    int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    if(!loading && (visibleItemCount + firstVisibleItemPosition ) >= totalCout){
                        loading = true;
                        loadMoreData();
                    }
                }
            }
        });
    }

    private void loadMoreData() {

        Log.e("currentLoadDate==",currentLoadDate);
        cityGuidePresenter.getCityGuideInfo("",currentLoadDate);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
           public void run() {
                cityGuideInfos.clear();
                currentLoadDate = "0";
                loading = false;
                cityGuidePresenter.getLastCityGuideNews(url);
            }
        },1000);
    }
}

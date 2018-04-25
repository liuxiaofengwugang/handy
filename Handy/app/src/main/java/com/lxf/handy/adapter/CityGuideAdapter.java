package com.lxf.handy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lxf.handy.R;
import com.lxf.handy.adapter.common.CommonRecyclerViewAdapter;
import com.lxf.handy.adapter.common.CommonRecyclerViewHolder;
import com.lxf.handy.bean.cityguide.CityGuideInfo;
import com.lxf.handy.util.DensityUtil;
import com.lxf.handy.util.ImageUtil;

import java.util.List;

/**
 * Created by liuxf on 2018/4/20.
 * 数据适配器
 */

public class CityGuideAdapter extends CommonRecyclerViewAdapter<CityGuideInfo.CityGuideBean> {


    public CityGuideAdapter(Context context, List<CityGuideInfo.CityGuideBean> datas) {
        super(context, datas);
    }

    @Override
    public View initView() {
        mView = View.inflate(mContext, R.layout.recycle_city_guide_item,null);
        return mView;
    }

    @Override
    public void setData(CommonRecyclerViewHolder holder, int position) {

        CityGuideInfo.CityGuideBean info = mDatas.get(position);
        if(holder!=null){
            holder.setText(R.id.id_tv_city_guide_titile,info.title);

            ImageView id_iv_news = holder.getView(R.id.id_iv_city_guide);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) id_iv_news.getLayoutParams();
            int w = params.width = DensityUtil.dip2px(mContext,93);
            params.height = (w * 3) / 4;
            id_iv_news.setLayoutParams(params);
            ImageUtil.show(id_iv_news,info.images[0]);
        }
    }

}

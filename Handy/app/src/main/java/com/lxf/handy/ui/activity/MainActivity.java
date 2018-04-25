package com.lxf.handy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.lxf.handy.R;
import com.lxf.handy.ui.fragment.CityGuideFragment;
import com.lxf.handy.ui.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener{

    private PagerAdapter adapter;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;


    private TextView text_first;
    private TextView text_second;
    private TextView text_third;




    @InjectView(R.id.drawer)
    DrawerLayout drawer;

    /**
     * Created by lxf on 2018/4/20.
     * handy demo主界面
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =  (ViewPager)findViewById(R.id.main_viewpager);
        text_first = (TextView) findViewById(R.id.text_first);
        text_second = (TextView) findViewById(R.id.text_second);
        text_third = (TextView) findViewById(R.id.text_third);


        ButterKnife.inject(this);
        initData();




    }

    private void initData() {

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new CityGuideFragment());
       // fragmentList.add(new CityGuideFragment());
        //fragmentList.add(new CityGuideFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());



        adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(MainActivity.this);
        viewPager.setOffscreenPageLimit(3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_open:
                    drawer.openDrawer(GravityCompat.END);
                    break;
            }
            return true;
        }};

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {







    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {

        Log.d("liuxiaofeng","liuxiaofeng  position"+position);

        switch (position) {
            case 0:
                text_first.setTextColor(getResources().getColor(R.color.red));
                text_second.setTextColor(getResources().getColor(R.color.black));
                text_third.setTextColor(getResources().getColor(R.color.black));

                break;
            case 1:
                text_first.setTextColor(getResources().getColor(R.color.black));
                text_second.setTextColor(getResources().getColor(R.color.red));
                text_third.setTextColor(getResources().getColor(R.color.black));

                break;
            case 2:
                text_first.setTextColor(getResources().getColor(R.color.black));
                text_second.setTextColor(getResources().getColor(R.color.black));
                text_third.setTextColor(getResources().getColor(R.color.red));

                break;


            default:
                break;
        }

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {



    }
}

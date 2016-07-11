package com.example.taobaodemo.fragments.fragment1_home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<ImageView>imglist;
    private Context context;

    public ViewPagerAdapter(Context context, List<ImageView> imglist) {
        this.context = context;
        this.imglist = imglist;
    }

    public ViewPagerAdapter(List<ImageView> imglist) {
        this.imglist=imglist;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imglist.get(position%imglist.size()));
        return imglist.get(position%imglist.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imglist.get(position%imglist.size()));
    }
}

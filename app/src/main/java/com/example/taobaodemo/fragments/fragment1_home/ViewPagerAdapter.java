package com.example.taobaodemo.fragments.fragment1_home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.taobaodemo.activities.DetailActivity;

import java.util.List;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<ImageView>imglist;
    private Context context;

    public ViewPagerAdapter(List<ImageView> imglist,Context context) {
        this.imglist=imglist;
        this.context=context;
//        this.acitvity=acitvity;
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
    public Object instantiateItem(final ViewGroup container, int position) {
        container.addView(imglist.get(position%imglist.size()));
        ImageView imageView=imglist.get(position%imglist.size());
        //点击viewpager中的图片跳转到下个界面
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
               context.startActivity(intent);
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imglist.get(position%imglist.size()));
    }
}

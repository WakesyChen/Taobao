package com.example.taobaodemo.fragments.fragment1_home;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.example.taobaodemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class Fragment1_home extends Fragment{

    private int imgs[]={R.mipmap.menu_viewpager_1,R.mipmap.menu_viewpager_2,R.mipmap.menu_viewpager_3,
            R.mipmap.menu_viewpager_4,R.mipmap.menu_viewpager_5,};
    private ViewPager viewPager;
    private Context context;
    private List<ImageView>imglist;
    private LinearLayout ll_points;//viewapger下面指示点的布局；
    private List<ImageView>pointslist;
    private boolean isStop=false;//判断是否停止轮播
    private GridView gridView_1;
    private GridView gridView_2;
    private SimpleAdapter gv_adapter;//gridview的适配器
    private SimpleAdapter gv2_adapter;//gridview的适配器
    private List<Map<String,Object>>gv_list;//gridview_1的数据源
    private List<Map<String,Object>>gv2_list;//gridview_2的数据源
    private MyAsynctask myAsynctask;//控制轮播的异步任务
    private int gvImgs[]={R.mipmap.menu_guide_1,R.mipmap.menu_guide_2,R.mipmap.menu_guide_3,R.mipmap.menu_guide_4,
            R.mipmap.menu_guide_5,R.mipmap.menu_guide_6,R.mipmap.menu_guide_7,R.mipmap.menu_guide_8,};
    private  int gvImgs2[]={R.mipmap.menu_1,R.mipmap.menu_2,R.mipmap.menu_3,
            R.mipmap.menu_4, R.mipmap.menu_5,R.mipmap.menu_6};
    public Fragment1_home(Context context) {
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1_home,null);
            initView(view);
        initData();

//开启线程，实现viewpager无限轮播
        myAsynctask=new MyAsynctask();
        myAsynctask.execute();



        return view;
    }

    private void initData() {

        //gridview_2设置数据
        for (int i = 0; i < gvImgs2.length; i++) {
            Map<String,Object>map=new HashMap<>();
            map.put("itemImg",gvImgs2[i]);
            gv2_list.add(map);
        }
//            GridView设置适配器
        gv2_adapter=new SimpleAdapter(context,gv2_list,R.layout.home_gridview_item2,new String[]{"itemImg"},new int[]{R.id.gv_img_item});
        gridView_2.setAdapter(gv2_adapter);




        //gridview_1设置数据
        for (int i = 0; i < gvImgs.length; i++) {
            Map<String,Object>map=new HashMap<>();
            map.put("itemImg",gvImgs[i]);
            gv_list.add(map);
        }
//            GridView设置适配器
        gv_adapter=new SimpleAdapter(context,gv_list,R.layout.home_gridview_item,new String[]{"itemImg"},new int[]{R.id.gv_img_item});
                gridView_1.setAdapter(gv_adapter);
        //设置viewpager 数据源
        for (int i = 0; i < imgs.length; i++) {
            //设置viewpager 数据源
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(imgs[i]);
            imglist.add(imageView);
            //添加指示圆点
            ImageView imageViewPoint=new ImageView(context);
            imageViewPoint.setImageResource(R.drawable.selector_points);
            imageViewPoint.setEnabled(true);//默认都为灰色
            ll_points.addView(imageViewPoint);//添加到指示器布局中
            pointslist.add(imageViewPoint);//添加到集合中
        }
        ViewPagerAdapter adapter=new ViewPagerAdapter(imglist);
        viewPager.setAdapter(adapter);
        //默认设置第一个圆点为绿色
        pointslist.get(0).setEnabled(false);

//        当图片开始无限轮播时，切换相应的圆点
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换页面时先所有的圆点设置为灰色
                for (int i = 0; i < pointslist.size(); i++) {
                    pointslist.get(i).setEnabled(true);
                }
                //当前界面为绿色
                pointslist.get(position%pointslist.size()).setEnabled(false);

            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView(View view) {
        viewPager= (ViewPager) view.findViewById(R.id.viewpager_home);
        ll_points= (LinearLayout) view.findViewById(R.id.ll_points);
        gridView_1= (GridView) view.findViewById(R.id.gridview_1);
        gridView_2= (GridView) view.findViewById(R.id.gridview_2);
        gv_list=new ArrayList<>();
        gv2_list=new ArrayList<>();
        imglist=new ArrayList<>();
        pointslist=new ArrayList<>();
    }


    public class MyAsynctask extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... params) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(!isStop) {
                        try {
                            Thread.sleep(2000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            return null;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        isStop=true;
        //退出时取消异步任务
        myAsynctask.cancel(true);

    }
}

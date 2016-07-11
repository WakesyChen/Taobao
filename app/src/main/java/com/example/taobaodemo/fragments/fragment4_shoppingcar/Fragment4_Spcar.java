package com.example.taobaodemo.fragments.fragment4_shoppingcar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.taobaodemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class Fragment4_Spcar extends Fragment implements View.OnClickListener{

    private Context context;
    private  Fragment_item1 fragment_item1;
    private  Fragment_item2 fragment_item2;
    private  Fragment_item3 fragment_item3;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    //与切换子fragment相关的控件
    private LinearLayout fragitem_ll_1,fragitem_ll_2,fragitem_ll_3;
    private TextView fragitem_tv_1,fragitem_tv_2,fragitem_tv_3;
    private ImageView fragitem_tab_1,fragitem_tab_2,fragitem_tab_3;
    public Fragment4_Spcar(Context context,FragmentManager manager) {
        this.context=context;
        this.manager=manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4_shoppingcar,null);
        initView(view);
        initData();
        initEven();
        return view;
    }

    private void initEven() {
        fragitem_ll_1.setOnClickListener(this);
        fragitem_ll_2.setOnClickListener(this);
        fragitem_ll_3.setOnClickListener(this);


    }

    private void initData() {
//        将三个子Fragments装入第四个界面
        fragment_item1=new Fragment_item1();
        fragment_item2=new Fragment_item2();
        fragment_item3=new Fragment_item3();
//        FragmentTransaction transaction=manager.beginTransaction();空指针异常，只能从主Activity中传manager过来
        transaction=manager.beginTransaction();
        transaction.add(R.id.fragment_beans,fragment_item1);
        transaction.add(R.id.fragment_beans,fragment_item2);
        transaction.add(R.id.fragment_beans, fragment_item3);
        transaction.hide(fragment_item2);
        transaction.hide(fragment_item3);
        transaction.commit();

    }

    private void initView(View view) {
        fragitem_ll_1= (LinearLayout) view.findViewById(R.id.fragitem_ll_1);
        fragitem_ll_2= (LinearLayout) view.findViewById(R.id.fragitem_ll_2);
        fragitem_ll_3= (LinearLayout) view.findViewById(R.id.fragitem_ll_3);
        fragitem_tv_1= (TextView) view.findViewById(R.id.fragitem_tv_1);
        fragitem_tv_2= (TextView) view.findViewById(R.id.fragitem_tv_2);
        fragitem_tv_3= (TextView) view.findViewById(R.id.fragitem_tv_3);
        fragitem_tab_1= (ImageView) view.findViewById(R.id.fragitem_tab_1);
        fragitem_tab_2= (ImageView) view.findViewById(R.id.fragitem_tab_2);
        fragitem_tab_3= (ImageView) view.findViewById(R.id.fragitem_tab_3);

    }

    //初始化子Fragment导航栏属性
    public void initFragItem(){
        fragitem_tv_1.setTextColor(0xff000000);
        fragitem_tv_2.setTextColor(0xff000000);
        fragitem_tv_3.setTextColor(0xff000000);
        fragitem_tab_1.setBackgroundResource(R.color.line);
        fragitem_tab_2.setBackgroundResource(R.color.line);
        fragitem_tab_3.setBackgroundResource(R.color.line);

    }
//    隐藏fragment
    public void hideFrags( FragmentTransaction transaction1){
        transaction1.hide(fragment_item1);
        transaction1.hide(fragment_item2);
        transaction1.hide(fragment_item3);



    }
    //导航栏的点击事件
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction1=manager.beginTransaction();

        switch (v.getId()){
            case R.id.fragitem_ll_1:
                initFragItem();
                hideFrags(transaction1);
                transaction1.show(fragment_item1);
                fragitem_tv_1.setTextColor(0xffef0000);
                fragitem_tab_1.setBackgroundColor(0xffee0000);

                break;
            case R.id.fragitem_ll_2:
                initFragItem();
                hideFrags(transaction1);
                transaction1.show(fragment_item2);

                fragitem_tv_2.setTextColor(0xffef0000);
                fragitem_tab_2.setBackgroundColor(0xffee0000);

                break;
            case R.id.fragitem_ll_3:
                initFragItem();
                hideFrags(transaction1);
                transaction1.show(fragment_item3);

                fragitem_tv_3.setTextColor(0xffef0000);
                fragitem_tab_3.setBackgroundColor(0xffee0000);

                break;


        }
        transaction1.commit();
    }
}

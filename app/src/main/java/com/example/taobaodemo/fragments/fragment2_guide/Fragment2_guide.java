package com.example.taobaodemo.fragments.fragment2_guide;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.taobaodemo.R;
import com.example.taobaodemo.activities.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class Fragment2_guide extends Fragment{

    private int Imgs[]={R.mipmap.detail_show_1,R.mipmap.detail_show_2,R.mipmap.detail_show_3,
            R.mipmap.detail_show_4,R.mipmap.detail_show_5,R.mipmap.detail_show_6};
    private List<Bean>datalist;
    private ListView listView;
    private Context context;
    private LayoutInflater inflater;//加载listview头布局

    public Fragment2_guide(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2_guide,null);

        initView(view);
        initData();
        return view;
    }

    private void initData() {

        //设置数据源
        for (int i = 0; i < Imgs.length; i++) {
            Bean bean=new Bean();
            bean.setIcon(R.mipmap.tao_user_2);
            bean.setTitle("优惠街-恋上猫女衣坊");
            bean.setDetai_img(Imgs[i]);
            bean.setUrl("【优惠街】  恋上猫女衣坊，最好的优惠，地址： http://yecaoly.taobao.com");
            bean.setTime("07-17");
            datalist.add(bean);
        }
        GuideAdapter adapter=new GuideAdapter(context,datalist);
        //添加listview头布局
        View view=inflater.inflate(R.layout.guide_listview_head,null);
        listView.addHeaderView(view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Detail.class);
                startActivity(intent);
            }
        });

    }

    private void initView(View view) {
        datalist=new ArrayList<>();
        listView= (ListView) view.findViewById(R.id.guide3_listview);


    }
}

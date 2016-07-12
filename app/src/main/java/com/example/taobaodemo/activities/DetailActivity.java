package com.example.taobaodemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.taobaodemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/7/11.
 */
public class DetailActivity extends Activity {
    private ListView lv_detail;
    private List<Map<String,Object>> datalist;
    private SimpleAdapter adapter;
    private ImageView img_girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        initData();

    }

    private void initData() {
        datalist=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Map<String,Object>map=new HashMap<>();
            map.put("icon",R.mipmap.tb_icon);
            map.put("title","恋上猫女衣坊");
            map.put("comment","质量很好，比淘宝其他店铺都便宜了好多，恋上猫女衣坊，值得你一看，点击查看，店铺地址：http://yecaoly.taobao.com");
            map.put("time","2016-7-18");
            datalist.add(map);
        }
        adapter=new SimpleAdapter(this,datalist,R.layout.activity_detatil_listview_item,new String[]{"icon","title",
                            "comment","time"},new int[]{R.id.detail_lv_icon,R.id.detail_tv_title,R.id.detail_tv_comment
                                ,R.id.detail_tv_time});

        lv_detail.setAdapter(adapter);
    }

    private void initView() {
        lv_detail= (ListView) findViewById(R.id.detail_listview);
        //添加头布局
        View view= LayoutInflater.from(this).inflate(R.layout.activity_detail_head,null);
        lv_detail.addHeaderView(view);
        img_girl= (ImageView) findViewById(R.id.lv_head_girl);
        img_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击了图片",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

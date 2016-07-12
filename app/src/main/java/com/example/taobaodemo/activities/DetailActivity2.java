package com.example.taobaodemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.taobaodemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/7/12.
 */
public class DetailActivity2 extends Activity {
    private ListView detail_lv2;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        initView();
        initData();
    }

    private void initData() {
        datalist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("show", R.mipmap.detail_show_6);
            map.put("content", "时尚女衣 流行女衣 连衣裙 半身裙 尽在恋上猫女衣坊 店铺地址：http://yecaoly.taobao.com");
            map.put("price", "¥49.9 包邮");
            map.put("sale", "1.8万人付款  广州");
            datalist.add(map);
        }
        adapter = new SimpleAdapter(this, datalist, R.layout.activity_detail2_listview_item, new String[]{
                "show", "content", "price", "sale"}, new int[]{R.id.detail2_img_show, R.id.detail2_tv_content, R.id.detail2_tv_price,
                R.id.detail2_tv_sale});
        detail_lv2.setAdapter(adapter);
    }

    private void initView() {
        detail_lv2 = (ListView) findViewById(R.id.detail2_listview);

    }
}

package com.example.taobaodemo.fragments.fragment3_find;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.taobaodemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wakesy on 2016/7/8.
 */
public class Fragment3_find extends Fragment{

    private GridView gridView3;
    private GridView gridView4;
    private  int imgs[]={R.mipmap.find_g_1,R.mipmap.find_g_2,R.mipmap.find_g_3,R.mipmap.find_g_4};
    private  int imgs2[]={R.mipmap.find_g_5,R.mipmap.find_g_6,R.mipmap.find_g_7,R.mipmap.find_g_8};
    private SimpleAdapter adapter;
    private List<Map<String,Object>>datalist;
    private SimpleAdapter adapter2;
    private List<Map<String,Object>>datalist2;
    private Context context;
    public Fragment3_find( Context context) {
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3_find,null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        //第一个gridview数据
        for (int i = 0; i < imgs.length; i++) {
            Map<String ,Object>map=new HashMap<>();
            map.put("img",imgs[i]);
            datalist.add(map);
        }
        adapter = new SimpleAdapter(context, datalist, R.layout.find_gv_item, new String[]{"img"}, new int[]{R.id.gv3_item_img});
        gridView3.setAdapter(adapter);

        //第二个gridview数据
        for (int i = 0; i < imgs2.length; i++) {
            Map<String ,Object>map=new HashMap<>();
            map.put("img",imgs2[i]);
            datalist2.add(map);
        }
        adapter2 = new SimpleAdapter(context, datalist2, R.layout.find_gv_item, new String[]{"img"}, new int[]{R.id.gv3_item_img});
        gridView4.setAdapter(adapter2);
    }

    private void initView(View view ) {
        gridView3= (GridView) view.findViewById(R.id.gridview_3);
        datalist=new ArrayList<>();
        gridView4= (GridView) view.findViewById(R.id.gridview_4);
        datalist2=new ArrayList<>();

    }
}

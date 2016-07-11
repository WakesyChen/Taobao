package com.example.taobaodemo.fragments.fragment2_guide;

import android.content.ComponentName;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taobaodemo.R;

import java.util.List;

/**
 * Created by Wakesy on 2016/7/11.
 */
public class GuideAdapter extends BaseAdapter {
    private Context context;
    private List<Bean>datalist;
    private LayoutInflater mInflater;

    public GuideAdapter(Context context, List<Bean> datalist) {
        mInflater=LayoutInflater.from(context);
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.guide_listview_item,null);
            holder.img_icon= (ImageView) convertView.findViewById(R.id.item_img_icon);
            holder.tv_title= (TextView) convertView.findViewById(R.id.item_img_title);
            holder.img_detail= (ImageView) convertView.findViewById(R.id.item_img_detai);
            holder.tv_url= (TextView) convertView.findViewById(R.id.item_url);
            holder.tv_time= (TextView) convertView.findViewById(R.id.item_time);
            convertView.setTag(holder);
        }
        holder= (ViewHolder) convertView.getTag();
        Bean bean= (Bean) getItem(position);
        holder.img_icon.setImageResource(bean.getIcon());
        holder.tv_title.setText(bean.getTitle());
        holder.img_detail.setImageResource(bean.getDetai_img());
        holder.tv_url.setText(bean.getUrl());
        holder.tv_time.setText(bean.getTime());


        return convertView;
    }
    public class ViewHolder{
        ImageView img_icon;
        TextView tv_title;
        ImageView img_detail;
        TextView tv_url;
        TextView tv_time;
        
        
    }
}

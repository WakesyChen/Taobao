package com.example.taobaodemo.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.taobaodemo.R;
import com.example.taobaodemo.fragments.fragment1_home.Fragment1_home;
import com.example.taobaodemo.fragments.fragment2_guide.Fragment2_guide;
import com.example.taobaodemo.fragments.fragment3_find.Fragment3_find;
import com.example.taobaodemo.fragments.fragment4_shoppingcar.Fragment4_Spcar;
import com.example.taobaodemo.fragments.fragment5_me.Fragment5_me;

public class MainActivity extends Activity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;
    private Fragment1_home fragment1;
    private Fragment2_guide fragment2;
    private Fragment3_find fragment3;
    private Fragment4_Spcar fragment4;
    private Fragment5_me fragment5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        manager=getFragmentManager();
        fragment1=new Fragment1_home(MainActivity.this);
        fragment2=new Fragment2_guide(MainActivity.this);
        fragment3=new Fragment3_find(MainActivity.this);
        fragment4=new Fragment4_Spcar(MainActivity.this,manager);
        fragment5=new Fragment5_me();
        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        //初始化全部加载进入transaction

        transaction.add(R.id.ll_1, fragment1);
        transaction.add(R.id.ll_1, fragment2);
        transaction.add(R.id.ll_1, fragment3);
        transaction.add(R.id.ll_1, fragment4);
        transaction.add(R.id.ll_1, fragment5);
        transaction.hide(fragment2);//隐藏
        transaction.hide(fragment3);
        transaction.hide(fragment4);//隐藏
        transaction.hide(fragment5);
        transaction.commit();



    }


    private void initEvents() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction=manager.beginTransaction();
                hideFragments(transaction);//先隐藏所有fragment
                switch (checkedId){
                    case R.id.btn_home1:
                        transaction.show(fragment1);

                        break;
                    case R.id.btn_weitao2:

                        transaction.show(fragment2);
                        break;
                    case R.id.btn_discover3:

                        transaction.show(fragment3);
                        break;
                    case R.id.btn_cart4:

                        transaction.show(fragment4);
                        break;
                    case R.id.btn_account5:

                        transaction.show(fragment5);
                        break;



                }
                transaction.commit();


            }


        });

    }

    private void hideFragments(FragmentTransaction transaction) {

        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
        transaction.hide(fragment5);

    }

    private void initView() {
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);

    }
}

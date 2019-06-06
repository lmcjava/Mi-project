package com.test.wx.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.test.wx.R;
import com.test.wx.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;
    private List<Fragment> list=new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("启动成功");
        initView();
    }

    private void initView(){
        mViewPager=findViewById(R.id.fragment_vp);
        mTabRadioGroup=findViewById(R.id.tabs_rg);
        list.add(BlankFragment.newInstance("消息"));
        list.add(BlankFragment.newInstance("通讯录"));
        list.add(BlankFragment.newInstance("发现"));
        list.add(BlankFragment.newInstance("我"));
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton) mTabRadioGroup.getChildAt(position);
                radioButton.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}

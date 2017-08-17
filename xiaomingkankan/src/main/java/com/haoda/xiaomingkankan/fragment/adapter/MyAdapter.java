package com.haoda.xiaomingkankan.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class MyAdapter extends FragmentPagerAdapter {

    private final ArrayList<String> titleList;
    private final ArrayList<Fragment> fragmentList;

    public MyAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment>
            fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}


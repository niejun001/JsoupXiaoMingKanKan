package com.haoda.xiaomingkankan.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haoda.xiaomingkankan.fragment.adapter.MyAdapter;

import java.util.ArrayList;


/**
 * Created by code on 2017/8/15.
 */
public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        TabLayout tl = ((TabLayout) view.findViewById(getTabLayoutId()));
        ViewPager vp = (ViewPager) view.findViewById(getViewPagerId());
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        MyAdapter adapter = new MyAdapter(getActivity().getSupportFragmentManager(), getTitleList(),
                getFragmentList());
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp, true);
        tl.setTabsFromPagerAdapter(adapter);

        return view;
    }

    protected abstract ArrayList<Fragment> getFragmentList();

    protected abstract ArrayList<String> getTitleList();

    protected abstract int getLayout();

    protected abstract int getTabLayoutId();

    protected abstract int getViewPagerId();
}

package com.haoda.xiaomingkankan.fragment.main;

import android.support.v4.app.Fragment;

import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.form.Form1Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form2Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form3Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form4Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form5Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form6Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form7Fragment;
import com.haoda.xiaomingkankan.fragment.form.Form8Fragment;

import java.util.ArrayList;

/**
 * Created by 聂军 on 2017/8/4.
 */

public class FromFragment extends BaseFragment{
    @Override
    protected ArrayList<Fragment> getFragmentList() {
        return new ArrayList<Fragment>() {{
            add(new Form1Fragment());
            add(new Form2Fragment());
            add(new Form3Fragment());
            add(new Form4Fragment());
            add(new Form5Fragment());
            add(new Form6Fragment());
            add(new Form7Fragment());
            add(new Form8Fragment());
        }};
    }

    @Override
    protected ArrayList<String> getTitleList() {
        return new ArrayList<String>() {{
            add("都市激情");
            add("人妻交换");
            add("校园小说");
            add("家庭乱伦");
            add("武侠古典");
            add("另类小说");
            add("情色笑话");
            add("性爱技巧");
        }};
    }

    @Override
    protected int getLayout() {
        return R.layout.frag_from;
    }

    @Override
    protected int getTabLayoutId() {
        return R.id.tlForm;
    }

    @Override
    protected int getViewPagerId() {
        return R.id.vpForm;
    }
}

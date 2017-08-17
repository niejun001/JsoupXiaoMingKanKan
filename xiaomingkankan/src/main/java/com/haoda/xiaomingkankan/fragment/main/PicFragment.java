package com.haoda.xiaomingkankan.fragment.main;

import android.support.v4.app.Fragment;

import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.pic.Pic1Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic2Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic3Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic4Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic5Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic6Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic7Fragment;
import com.haoda.xiaomingkankan.fragment.pic.Pic8Fragment;

import java.util.ArrayList;

/**
 * Created by 聂军 on 2017/8/4.
 */

public class PicFragment extends BaseFragment{
    @Override
    protected ArrayList<Fragment> getFragmentList() {
        return new ArrayList<Fragment>() {{
            add(new Pic1Fragment());
            add(new Pic2Fragment());
            add(new Pic3Fragment());
            add(new Pic4Fragment());
            add(new Pic5Fragment());
            add(new Pic6Fragment());
            add(new Pic7Fragment());
            add(new Pic8Fragment());
        }};
    }

    @Override
    protected ArrayList<String> getTitleList() {
        return new ArrayList<String>() {{
            add("偷拍自拍");
            add("亚洲色情");
            add("欧美色图");
            add("美腿丝袜");
            add("明星淫乱");
            add("乱伦熟女");
            add("卡通动漫");
            add("清纯少女");
        }};
    }

    @Override
    protected int getLayout() {
        return R.layout.frag_pic;
    }

    @Override
    protected int getTabLayoutId() {
        return R.id.tlPic;
    }

    @Override
    protected int getViewPagerId() {
        return R.id.vpPic;
    }
}

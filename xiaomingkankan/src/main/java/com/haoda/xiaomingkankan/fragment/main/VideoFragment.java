package com.haoda.xiaomingkankan.fragment.main;

import android.support.v4.app.Fragment;

import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.video.Video1Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video2Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video3Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video4Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video5Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video6Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video7Fragment;
import com.haoda.xiaomingkankan.fragment.video.Video8Fragment;

import java.util.ArrayList;

/**
 * Created by 聂军 on 2017/8/4.
 */

public class VideoFragment extends BaseFragment{

    @Override
    protected ArrayList<Fragment> getFragmentList() {
        return new ArrayList<Fragment>() {{
            add(new Video1Fragment());
            add(new Video2Fragment());
            add(new Video3Fragment());
            add(new Video4Fragment());
            add(new Video5Fragment());
            add(new Video6Fragment());
            add(new Video7Fragment());
            add(new Video8Fragment());
        }};
    }

    @Override
    protected ArrayList<String> getTitleList() {
        return new ArrayList<String>() {{
            add("亚洲风情");
            add("日韩女忧");
            add("国内自拍");
            add("欧美激情");
            add("卡通动漫");
            add("强奸乱伦");
            add("制服诱惑");
            add("综合另类");
        }};
    }

    @Override
    protected int getLayout() {
        return R.layout.frag_video;
    }

    @Override
    protected int getTabLayoutId() {
        return R.id.tlVideo;
    }

    @Override
    protected int getViewPagerId() {
        return R.id.vpVideo;
    }
}

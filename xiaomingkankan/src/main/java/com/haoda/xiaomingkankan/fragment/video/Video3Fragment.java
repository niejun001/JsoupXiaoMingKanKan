package com.haoda.xiaomingkankan.fragment.video;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */
public class Video3Fragment extends VideoBaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.frag_video3;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.video3_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.video3_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb3;
    }

    @Override
    protected String getUrl() {
        return Contact.VIDEO3;
    }
}
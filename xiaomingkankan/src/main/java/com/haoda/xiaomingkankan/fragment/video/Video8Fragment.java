package com.haoda.xiaomingkankan.fragment.video;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Video8Fragment extends VideoBaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.frag_video8;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.video8_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.video8_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb8;
    }

    @Override
    protected String getUrl() {
        return Contact.VIDEO8;
    }

}

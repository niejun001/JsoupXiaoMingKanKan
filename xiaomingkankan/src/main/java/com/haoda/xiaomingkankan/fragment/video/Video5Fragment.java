package com.haoda.xiaomingkankan.fragment.video;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Video5Fragment extends VideoBaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.frag_video5;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.video5_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.video5_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb5;
    }

    @Override
    protected String getUrl() {
        return Contact.VIDEO5;
    }

}

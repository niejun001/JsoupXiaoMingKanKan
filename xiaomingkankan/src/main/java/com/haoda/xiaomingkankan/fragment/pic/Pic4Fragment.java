package com.haoda.xiaomingkankan.fragment.pic;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Pic4Fragment extends PicBaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.frag_pic4;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.pic4_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.pic4_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb4;
    }

    @Override
    protected String getUrl() {
        return Contact.PIC4;
    }

}

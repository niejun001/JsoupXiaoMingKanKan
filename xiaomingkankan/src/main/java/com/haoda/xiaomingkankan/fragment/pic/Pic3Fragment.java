package com.haoda.xiaomingkankan.fragment.pic;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Pic3Fragment extends PicBaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.frag_pic3;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.pic3_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.pic3_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb3;
    }

    @Override
    protected String getUrl() {
        return Contact.PIC3;
    }

}

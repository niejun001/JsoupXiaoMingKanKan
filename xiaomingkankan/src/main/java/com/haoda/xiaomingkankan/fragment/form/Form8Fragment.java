package com.haoda.xiaomingkankan.fragment.form;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Form8Fragment extends FormBaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.frag_form8;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.form8_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.form8_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb8;
    }

    @Override
    protected String getUrl() {
        return Contact.FORM8;
    }

}

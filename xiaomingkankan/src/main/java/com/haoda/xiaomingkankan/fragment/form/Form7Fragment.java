package com.haoda.xiaomingkankan.fragment.form;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Form7Fragment extends FormBaseFragment {

    @Override
    protected int getLayout() {
        return R.layout.frag_form7;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.form7_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.form7_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb7;
    }

    @Override
    protected String getUrl() {
        return Contact.FORM7;
    }

}

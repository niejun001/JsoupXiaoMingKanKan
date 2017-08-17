package com.haoda.xiaomingkankan.fragment.form;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Form6Fragment extends FormBaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.frag_form6;
    }

    @Override
    protected int getSmartRefreshLayoutId() {
        return R.id.form6_refresh;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.form6_rv;
    }

    @Override
    protected int getProgressBarId() {
        return R.id.pb6;
    }

    @Override
    protected String getUrl() {
        return Contact.FORM6;
    }

}

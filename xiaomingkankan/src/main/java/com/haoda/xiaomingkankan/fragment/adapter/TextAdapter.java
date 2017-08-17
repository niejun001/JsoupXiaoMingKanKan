package com.haoda.xiaomingkankan.fragment.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.bean.PicsList;

import java.util.List;

/**
 * Created by niejun on 2017/8/10.
 */

public class TextAdapter extends BaseItemDraggableAdapter<PicsList,BaseViewHolder> {

    public TextAdapter(List list) {
        super(R.layout.text,list);
    }

    @Override
    protected void convert(BaseViewHolder helper, PicsList item) {
        final TextView texts = helper.getView(R.id.texts);
        texts.setText(item.getUrl());
    }
}

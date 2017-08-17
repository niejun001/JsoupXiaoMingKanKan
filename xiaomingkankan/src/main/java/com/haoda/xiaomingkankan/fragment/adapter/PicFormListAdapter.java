package com.haoda.xiaomingkankan.fragment.adapter;


import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.bean.PicFormList;

import java.util.List;

/**
 * Created by niejun on 2017/8/9.
 */

public class PicFormListAdapter extends BaseItemDraggableAdapter<PicFormList,BaseViewHolder> {

    public PicFormListAdapter(List list) {
        super(R.layout.item_pic,list);
    }

    @Override
    protected void convert(BaseViewHolder helper, PicFormList item) {
        TextView tv_pic = helper.getView(R.id.tv_pic);
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                break;
            case 1:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                break;
            case 2:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                break;
            default:
                break;
        }
        tv_pic.setText(item.getName());
        helper.addOnClickListener(R.id.tv_pic);
    }
}

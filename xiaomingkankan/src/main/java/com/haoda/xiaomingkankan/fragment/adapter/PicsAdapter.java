package com.haoda.xiaomingkankan.fragment.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.bean.PicsList;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by niejun on 2017/8/9.
 */

public class PicsAdapter extends BaseItemDraggableAdapter<PicsList,BaseViewHolder> {

    private final Context context;

    public PicsAdapter(List list, Context context) {
        super(R.layout.pics,list);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PicsList item) {
        final ImageView picitem = helper.getView(R.id.picitem);
        Glide.with(context).load(item.getUrl())
                .bitmapTransform(new RoundedCornersTransformation(context,10,0,RoundedCornersTransformation.CornerType.ALL))
                .crossFade(500).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                picitem.setImageDrawable(resource);
            }
        });
    }
}

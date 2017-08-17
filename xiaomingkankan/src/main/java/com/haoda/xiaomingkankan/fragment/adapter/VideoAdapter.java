package com.haoda.xiaomingkankan.fragment.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.bean.Videolist;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by niejun on 2017/8/7.
 */

public class VideoAdapter extends BaseQuickAdapter<Videolist, BaseViewHolder> {
    private final Context context;

    public VideoAdapter(Context context) {
        super(R.layout.item_walk);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Videolist item) {
        final ImageView iv = helper.getView(R.id.pic);
        TextView name = helper.getView(R.id.name);
        name.setText(item.getName());
        Glide.with(context)
             .load(item.getImgurl())
             .bitmapTransform(new RoundedCornersTransformation(context,10,0,RoundedCornersTransformation.CornerType.ALL))
             .crossFade(500)
             .into(new SimpleTarget<GlideDrawable>() {
                 @Override
                 public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                     iv.setImageDrawable(resource);
                 }
             });
        helper.addOnClickListener(R.id.name);
        helper.addOnClickListener(R.id.video_ll);
    }
}

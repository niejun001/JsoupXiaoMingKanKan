package com.haoda.xiaomingkankan.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.geturl.GetVideoLinkRx;
import com.haoda.xiaomingkankan.geturl.GetVideoUrlRx;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DownAndPlayActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private Button down;
    private Button play;
    private GetVideoUrlRx getVideoUrlRx;
    private String videolink;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String imgurl = getIntent().getStringExtra("imgurl");
        String name = getIntent().getStringExtra("name");
        String videourl = getIntent().getStringExtra("videourl");
        setContentView(R.layout.activity_down_and_play);

        GetVideoLinkRx getVideoLinkRx = new GetVideoLinkRx();
        getVideoUrlRx = new GetVideoUrlRx();
        iv = ((ImageView) findViewById(R.id.downandplay_iv));
        TextView tv = ((TextView) findViewById(R.id.downandplay_tv));
        down = ((Button) findViewById(R.id.downandplay_down));
        play = ((Button) findViewById(R.id.downandplay_play));
        pb = ((ProgressBar) findViewById(R.id.pb));

        down.setClickable(false);
        play.setClickable(false);
        tv.setText(name);

        Glide.with(this).load(imgurl)
                .bitmapTransform(new RoundedCornersTransformation(this,10,0,
                        RoundedCornersTransformation.CornerType.ALL))
                .crossFade(500).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                iv.setImageDrawable(resource);
            }
        });
        Log.e("DownAndPlayActivity", imgurl + ", " + name + ", " + videourl);
        Toast.makeText(this, imgurl + ", " + name + ", " + videourl, Toast.LENGTH_SHORT).show();

        getVideoLinkRx.getvideolink(Contact.HEAD + videourl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String s) {
                        videolink = s;
                        down.setClickable(true);
                        play.setClickable(true);
                        down.setOnClickListener(DownAndPlayActivity.this);
                        play.setOnClickListener(DownAndPlayActivity.this);
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.downandplay_down:
                //设置滚动条可见
                pb.setVisibility(View.VISIBLE);
                getVideoUrlRx.getvideourl(Contact.HEAD + videolink)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                //设置滚动条不可见
                                pb.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(String s) {

                                getVideoUrlRx.getvideourl(Contact.HEAD + videolink)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Subscriber<String>() {
                                            @Override
                                            public void onCompleted() {
                                                //设置滚动条不可见
                                                pb.setVisibility(View.GONE);
                                            }

                                            @Override
                                            public void onError(Throwable e) {

                                            }

                                            @Override
                                            public void onNext(String s) {
                                                Log.e("DownAndPlayActivity",  s);
                                                //浏览器打开
                                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                                intent.setData(Uri.parse(s));
                                                startActivity(intent);
                                            }
                                        });
                                Log.e("DownAndPlayActivity", s);
                                Toast.makeText(DownAndPlayActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.downandplay_play:
                //设置滚动条可见
                pb.setVisibility(View.VISIBLE);
                getVideoUrlRx.getvideourl(Contact.HEAD + videolink)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                //设置滚动条不可见
                                pb.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(String s) {
                                //播放器打开
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setDataAndType(Uri.parse(s),"video/mp4");
                                startActivity(intent);
                            }
                        });
                break;
            default:
                break;
        }
    }
}

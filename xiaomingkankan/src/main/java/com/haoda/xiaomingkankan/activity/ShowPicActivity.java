package com.haoda.xiaomingkankan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.adapter.PicsAdapter;
import com.haoda.xiaomingkankan.fragment.bean.PicsList;
import com.haoda.xiaomingkankan.geturl.GetPicUrlRx;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShowPicActivity extends AppCompatActivity {
    private String imgurl;
    private RecyclerView picrv;
    private GetPicUrlRx getPicUrlRx;
    private PicsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("name");
        imgurl = getIntent().getStringExtra("imgurl");
        getPicUrlRx = new GetPicUrlRx();
        setContentView(R.layout.activity_show_pic);

        TextView showpic = ((TextView) findViewById(R.id.tv_showpic));
        picrv = ((RecyclerView) findViewById(R.id.pic_rv));
        showpic.setText(name);
        init();
    }

    private void init() {
        getPicUrlRx.getpicurl(imgurl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PicsList>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<PicsList> picsLists) {
                        picrv.setLayoutManager(new LinearLayoutManager(ShowPicActivity.this));
                        adapter = new PicsAdapter(picsLists,ShowPicActivity.this);
                        picrv.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        adapter.setNewData(picsLists);
                    }
                });
    }
}

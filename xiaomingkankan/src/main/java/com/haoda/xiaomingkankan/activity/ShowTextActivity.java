package com.haoda.xiaomingkankan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haoda.xiaomingkankan.R;
import com.haoda.xiaomingkankan.fragment.adapter.TextAdapter;
import com.haoda.xiaomingkankan.fragment.bean.PicsList;
import com.haoda.xiaomingkankan.geturl.GetFormTextRx;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ShowTextActivity extends AppCompatActivity {
    private String url;
    private GetFormTextRx getFormTextRx;
    private RecyclerView textrv;
    private TextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = getIntent().getStringExtra("name");
        url = getIntent().getStringExtra("url");
        getFormTextRx = new GetFormTextRx();
        setContentView(R.layout.activity_show_text);
        TextView showtext = ((TextView) findViewById(R.id.tv_showtext));
        textrv = ((RecyclerView) findViewById(R.id.text_rv));
        showtext.setText(name);
        init();
    }

    private void init() {
        getFormTextRx.gettext(url)
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
                        textrv.setLayoutManager(new LinearLayoutManager(ShowTextActivity.this));
                        adapter = new TextAdapter(picsLists);
                        textrv.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        adapter.setNewData(picsLists);
                    }
                });
    }
}

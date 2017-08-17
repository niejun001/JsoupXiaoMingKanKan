package com.haoda.xiaomingkankan.fragment.pic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.activity.ShowPicActivity;
import com.haoda.xiaomingkankan.fragment.adapter.PicFormListAdapter;
import com.haoda.xiaomingkankan.fragment.bean.PicFormList;
import com.haoda.xiaomingkankan.geturl.GetPicFormDownRx;
import com.haoda.xiaomingkankan.geturl.GetPicFormListRx;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by code on 2017/8/15.
 */

public abstract class PicBaseFragment extends Fragment {
    private SmartRefreshLayout refresh;
    private RecyclerView rv;
    private GetPicFormListRx getPicFormListRx;
    private GetPicFormDownRx getPicFormDownRx;
    private String url = getUrl();
    private PicFormListAdapter adapter;
    private ProgressBar pb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        refresh = ((SmartRefreshLayout) view.findViewById(getSmartRefreshLayoutId()));
        rv = ((RecyclerView) view.findViewById(getRecyclerViewId()));
        pb = ((ProgressBar) view.findViewById(getProgressBarId()));

        pb.setVisibility(View.VISIBLE);

        getPicFormListRx = new GetPicFormListRx();
        getPicFormDownRx = new GetPicFormDownRx();

        initView();
        return view;
    }

    protected abstract int getLayout();

    protected abstract int getSmartRefreshLayoutId();

    protected abstract int getRecyclerViewId();

    protected abstract int getProgressBarId();

    protected abstract String getUrl();

    private void initView() {

        getPicFormListRx.getdatas(Contact.HEAD + url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PicFormList>>() {
                    @Override
                    public void onCompleted() {
                        pb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(final List<PicFormList> picFormLists) {
                        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        adapter = new PicFormListAdapter(picFormLists);
                        rv.setAdapter(adapter);
                        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        adapter.setNewData(picFormLists);
                        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @SuppressLint("NewApi")
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(getActivity(), ShowPicActivity.class);
                                intent.putExtra("name", picFormLists.get(position).getName());
                                intent.putExtra("imgurl",Contact.HEAD + picFormLists.get(position)
                                        .getPicurls());
                                getActivity().startActivity(intent);
                            }
                        });
                    }
                });


        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(1000);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                getPicFormDownRx.getpicdown(Contact.HEAD + url)
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
                                url = s;
                                getPicFormListRx.getdatas(Contact.HEAD + s)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Subscriber<List<PicFormList>>() {
                                            @Override
                                            public void onCompleted() {
                                                adapter.loadMoreComplete();
                                                refreshlayout.finishLoadmore();
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                            }

                                            @Override
                                            public void onNext(List<PicFormList> picFormLists) {
                                                adapter.addData(picFormLists);
                                            }
                                        });
                            }
                        });
            }
        });
    }
}

package com.haoda.xiaomingkankan.geturl;

import android.util.Log;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.fragment.bean.Videolist;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class GetVideoListUrlRx {
    public GetVideoListUrlRx(){

    }

    public Observable<List<Videolist>> getdatas(final String url){
        return Observable.create(new Observable.OnSubscribe<List<Videolist>>() {
            @Override
            public void call(Subscriber<? super List<Videolist>> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    List<Videolist> datas = new ArrayList<>();
                    Connection conn = Jsoup.connect(url);
                    // 修改http包中的header,伪装成浏览器进行抓取
                    conn.header("User-Agent", Contact.USERAGENT);
                    Document doc = null;
                    try {
                        doc = conn.get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (doc != null) {
                        //获取视频列表链接
                        Elements elements = doc.select("div.index_list").select("ul").select("li");
                        for (Element element : elements) {
                            String name = element
                                    .select("a")
                                    .select("h3")
                                    .text();
                            String img = element
                                    .select("a")
                                    .select("img")
                                    .attr("src");

                            String videourl = element
                                    .select("a")
                                    .attr("href");
                            datas.add(new Videolist(name,img,videourl));

                            Log.e("MainActivity00", "video:" + name + "," + img + "," + videourl);
                        }
                        subscriber.onNext(datas);
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }
}

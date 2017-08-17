package com.haoda.xiaomingkankan.geturl;

import android.util.Log;

import com.haoda.xiaomingkankan.Contact;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by niejun on 2017/8/8.
 */

public class GetVideoLinkRx {
    public GetVideoLinkRx() {
    }

    public Observable<String> getvideolink(final String url){
        return Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {

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
                        //获取视频链接
                        String link = doc.select("div.playBar")
                                .select("ul")
                                .select("ul")
                                .select("ul")
                                .select("li")
                                .select("a")
                                .attr("href");
                        Log.e("MainActivity00", "video:" + link + ",");
                        subscriber.onNext(link);
                        subscriber.onCompleted();
                    }
                }
                }
        });
    }
}

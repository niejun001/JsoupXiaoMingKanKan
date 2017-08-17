package com.haoda.xiaomingkankan.geturl;

import android.util.Log;

import com.haoda.xiaomingkankan.Contact;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by niejun on 2017/8/8.
 */

public class GetPicFormDownRx {
    public GetPicFormDownRx() {
    }

    public Observable<String> getpicdown(final String url){
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
                        //获取图片或小说的下一页
                        Elements picture = doc.select("ul.news_list").select("div.pagination").select("a");
                        for (Element element : picture) {
                            String text = element.text();
                            if (text.equals("下一页")) {
                                String href = element.attr("href");
                                Log.e("Main2Activity2222222", href);
                                subscriber.onNext(href);
                            }
                        }
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }
}

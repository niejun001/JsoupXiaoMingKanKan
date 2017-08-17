package com.haoda.xiaomingkankan.geturl;

import android.util.Log;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.fragment.bean.PicFormList;

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
 * Created by niejun on 2017/8/9.
 */

public class GetPicFormListRx {
    public GetPicFormListRx() {
    }

    public Observable<List<PicFormList>> getdatas(final String url){
        return Observable.create(new Observable.OnSubscribe<List<PicFormList>>() {
            @Override
            public void call(Subscriber<? super List<PicFormList>> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    List<PicFormList> datas = new ArrayList<>();
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
                        //获取图片或小说列表
                        Elements picture = doc.select("ul.news_list").select("ul").select("li");
                        for (Element element : picture) {
                            String text = element.select("a").text();
                            String link = element.select("a").attr("href");
                            String s = text.split("4444fff.com")[1];
                            Log.e("Main2Activity", s + ",,," + link);
                            datas.add(new PicFormList(s,link));
                        }
                        subscriber.onNext(datas);
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }
}

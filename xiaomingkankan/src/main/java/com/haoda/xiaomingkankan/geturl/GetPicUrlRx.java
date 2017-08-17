package com.haoda.xiaomingkankan.geturl;

import android.util.Log;

import com.haoda.xiaomingkankan.Contact;
import com.haoda.xiaomingkankan.fragment.bean.PicsList;

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
 * Created by niejun on 2017/8/8.
 */

public class GetPicUrlRx {

    public GetPicUrlRx() {
    }

    public Observable<List<PicsList>> getpicurl(final String url) {
        return Observable.create(new Observable.OnSubscribe<List<PicsList>>() {
            @Override
            public void call(Subscriber<? super List<PicsList>> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    List<PicsList> datas = new ArrayList<>();
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
                        //获取图片路径
                        Elements picture = doc.select("div.news").select("table").select("tbody")
                                .select("tr").select("td").select("img");
                        for (Element element : picture) {
                            String src = element.attr("src");
                            Log.e("Main2Activity", src);
                            datas.add(new PicsList(src));
                        }
                        subscriber.onNext(datas);
                        subscriber.onCompleted();
                    }
                }
            }
        });
    }
}

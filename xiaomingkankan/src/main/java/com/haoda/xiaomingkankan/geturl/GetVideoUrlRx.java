package com.haoda.xiaomingkankan.geturl;


import android.util.Log;

import com.haoda.xiaomingkankan.Contact;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by niejun on 2017/8/8.
 */

public class GetVideoUrlRx {
    private final OkHttpClient client;

    public GetVideoUrlRx() {
        client = new OkHttpClient();
    }

    public Observable<String> getvideourl(final String url){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                    Connection conn2 = Jsoup.connect(url);
                    // 修改http包中的header,伪装成浏览器进行抓取
                    conn2.header("User-Agent", Contact.USERAGENT);
                    Document doc2 = null;
                    try {
                        doc2 = conn2.get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (doc2 != null) {
                        //获取视频路径
                        String s = doc2.select("div.player")
                                .select("div.player_l")
                                .select("script")
                                .attr("src");
                        Log.e("MainActivity00", "video:" + s + ",");

                        String url2 = Contact.HEAD + s;

                        try {
                            String json = getJson(url2);
                            Log.e("MainActivity00", "json:" + json + ",");

                            String mp4 = json.substring(json.indexOf("$") + 1, json.lastIndexOf("$"));
                            Log.e("MainActivity00", "json:"  + "---->" + mp4);

                            subscriber.onNext(mp4);
                        } catch (IOException e) {
                            e.printStackTrace();
                            subscriber.onError(e);
                        }
                        subscriber.onCompleted();
                    }
            }
        });
    }

    private String getJson(String urls) throws IOException{
        Request request = new Request.Builder().url(urls).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}

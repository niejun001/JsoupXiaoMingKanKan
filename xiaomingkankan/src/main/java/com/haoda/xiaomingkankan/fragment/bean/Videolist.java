package com.haoda.xiaomingkankan.fragment.bean;

/**
 * Created by 聂军 on 2017/8/7.
 */

public class Videolist {
    private final String name;
    private final String imgurl;
    private final String videourl;

    public Videolist(String name, String img, String videourl) {
        this.name = name;
        this.imgurl = img;
        this.videourl = videourl;
    }

    public String getName() {
        return name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getVideourl() {
        return videourl;
    }

}

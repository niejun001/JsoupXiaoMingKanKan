package com.haoda.xiaomingkankan.fragment.bean;

/**
 * Created by niejun on 2017/8/9.
 */

public class PicFormList {
    private final String name;
    private final String picurls;

    public PicFormList(String name, String picurls) {
        this.name = name;
        this.picurls = picurls;
    }

    public String getPicurls() {
        return picurls;
    }

    public String getName() {
        return name;
    }

}

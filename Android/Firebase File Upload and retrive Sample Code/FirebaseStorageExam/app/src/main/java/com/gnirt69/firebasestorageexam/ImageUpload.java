package com.gnirt69.firebasestorageexam;

/**
 * Created by NgocTri on 3/4/2017.
 */

public class ImageUpload {

    public String name;
    public String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ImageUpload(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public ImageUpload(){}
}

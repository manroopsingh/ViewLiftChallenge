package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by singh on 01-Apr-17.
 */

@Root
public class Player implements Serializable {

    @Attribute
    int height;


    @Attribute
    int width;

    @Attribute
    String url;


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}

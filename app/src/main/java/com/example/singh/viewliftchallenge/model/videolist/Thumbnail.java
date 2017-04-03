package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by singh on 01-Apr-17.
 */

@Root
public class Thumbnail implements Serializable {

    @Attribute
    String type;

    @Attribute
    String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

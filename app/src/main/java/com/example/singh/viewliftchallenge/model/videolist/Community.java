package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by singh on 01-Apr-17.
 */

@Root
public class Community implements Serializable {

    @Element(required = false)
    int starRating;

    @Element(required = false)
    String tags;

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

package com.example.singh.viewliftchallenge.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by singh on 30-Mar-17.
 */

@Root(strict = false)
public class Rss {

//    @ElementList
//    List<Item> channel;
//
//    public List<Item> getChannel() {
//        return channel;
//    }


    public Channel getChannel() {
        return channel;
    }
    @Element(name = "channel")
    public Channel channel;

}
package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by singh on 30-Mar-17.
 */

@Root(strict = false)
@NamespaceList({
@Namespace(reference = "http://purl.org/rss/1.0/modules/content/", prefix = "content"),
@Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
})
public class Rss {

    public Channel getChannel() {
        return channel;
    }
    @Element(name = "channel")
    public Channel channel;

}

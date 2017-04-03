package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;
import java.util.List;

/**
 * Created by singh on 30-Mar-17.
 */

@Root(strict = false)
@NamespaceList({
        @Namespace(reference = "http://purl.org/rss/1.0/modules/content/", prefix = "content"),
        @Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
})
public class Item implements Serializable {


    @Element(required = false)
    int year;

    @Element
    String filmType;

    @Element(required = false)
    String link;

    @Element
    int guid;

    @Element
    int runtime;

    @Element
    String pubDate;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    @Path("title")
    @Text(required = false)
    public String title;

    @Path("description")
    @Text(required = false)
    public String description;


    @Element(required = false)
    @Namespace(reference = "http://purl.org/rss/1.0/modules/content/")
    String encoded;


    @ElementList(entry = "thumbnail", inline = true, required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/")
    public List<Thumbnail> thumbnail;


    @ElementList(entry = "credit", inline = true, required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/")
    public List<Credit> credit;


    @Element(required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/")
    String keywords;

    @Element(required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/")
    Player player;


    public void setYear(int year) {
        this.year = year;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public List<Thumbnail> getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(List<Thumbnail> thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Credit> getCredit() {
        return credit;
    }

    public void setCredit(List<Credit> credit) {
        this.credit = credit;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public int getYear() {
        return year;
    }


    public String getFilmType() {
        return filmType;
    }


}

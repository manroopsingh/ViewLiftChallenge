package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {

//    @Element(name = "title")
//    String title;

    @Element(name = "link")
    String link;

    @Element(name = "description")
    String description;

    @Element(name = "language")
    String language;

    @Element(required = false)
    String currentPageLink;

    @Element(required = false)
    String nexPagetLink;

    @Element
    int totalResults;

    @Element
    int startIndex;

    @Element
    int itemsPerPage;

    @ElementList(name = "item",inline = true)
    List<Item> items;

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrentPageLink() {
        return currentPageLink;
    }

    public void setCurrentPageLink(String currentPageLink) {
        this.currentPageLink = currentPageLink;
    }

    public String getNexPagetLink() {
        return nexPagetLink;
    }

    public void setNexPagetLink(String nexPagetLink) {
        this.nexPagetLink = nexPagetLink;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

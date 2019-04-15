package com.demo.nytimesnews.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rashida on 4/10/19.
 */
public class Results {

    @SerializedName("url")
    private String url;

    @SerializedName("byline")
    private String byline;

    @SerializedName("title")
    private String title;

    @SerializedName("published_date")
    private String publishedDate;


    @SerializedName("media")
    private List<Media> mediaList;

    public String getUrl() {
        return url;
    }

    public String getByline() {
        return byline;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }
}

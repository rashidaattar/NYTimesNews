package com.demo.nytimesnews.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rashida on 4/14/19.
 */
public class MediaMetadata {

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }
}

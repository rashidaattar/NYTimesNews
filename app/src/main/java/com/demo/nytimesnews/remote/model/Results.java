package com.demo.nytimesnews.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rashida on 4/10/19.
 */
public class Results {

    @SerializedName("url")
    String url;

    @SerializedName("byline")
    String byline;

    @SerializedName("title")
    String title;
}

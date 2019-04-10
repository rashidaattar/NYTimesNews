package com.demo.nytimesnews.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rashida on 4/10/19.
 */


public class NewsList {

    @SerializedName("status")
    String status;

    @SerializedName("num_results")
    int numResults;

    @SerializedName("results")
    List<Results> resultsList;

    public String getStatus() {
        return status;
    }

    public int getNumResults() {
        return numResults;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }
}

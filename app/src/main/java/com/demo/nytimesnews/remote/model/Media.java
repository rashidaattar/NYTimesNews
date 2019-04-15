package com.demo.nytimesnews.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rashida on 4/14/19.
 */
public class Media {

    @SerializedName("media-metadata")
    private List<MediaMetadata> mediaMetadataList;

    public List<MediaMetadata> getMediaMetadataList() {
        return mediaMetadataList;
    }
}

package com.pordiva.esraeken.photogllery.model;

/**
 * Created by esraeken on 24/08/16.
 */
public class photo

{

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    private String url;
    private String thumbnailUrl;

}

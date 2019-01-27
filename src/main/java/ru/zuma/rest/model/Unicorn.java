package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Unicorn {
    private String date;
    private String imageURL;

    public Unicorn() {
    }

    public Unicorn(String date, String imageURL) {
        this.date = date;
        this.imageURL = imageURL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("image_url")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

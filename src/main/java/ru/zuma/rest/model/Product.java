package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Map;

public class Product {

    private long id;
    private String category;
    private String name;
    private float stars;
    private boolean isLiked;
    private long iconId;
    private Map<String, String> characteristics;

    public Product() {
    }

    public Product(long id, String category, String name, float stars, boolean isLiked, long iconId) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.stars = stars;
        this.isLiked = isLiked;
        this.iconId = iconId;
    }

    public Product(long id, String category, String name, float stars, boolean isLiked, long iconId, Map<String, String> characteristics) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.stars = stars;
        this.isLiked = isLiked;
        this.iconId = iconId;
        this.characteristics = characteristics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    @JsonGetter(value = "is_liked")
    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    @JsonGetter(value = "icon_id")
    public long getIconId() {
        return iconId;
    }

    public void setIconId(long iconId) {
        this.iconId = iconId;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }
}

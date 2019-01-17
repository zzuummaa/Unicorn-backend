package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Offer {
    private long id;
    private float price;
    private boolean isLiked;
    private Shop shop;
    private Product product;

    public Offer(long id, float price, boolean isLiked, Shop shop, Product product) {
        this.id = id;
        this.price = price;
        this.isLiked = isLiked;
        this.shop = shop;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isLiked() {
        return isLiked;
    }

    @JsonGetter(value = "is_liked")
    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

package ru.zuma.rest.model;

import java.util.List;

public class ProductHits {

    private List<Product> products = null;

    public ProductHits() {
    }

    public ProductHits(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}

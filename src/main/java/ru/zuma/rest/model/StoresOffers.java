package ru.zuma.rest.model;

import java.util.List;

public class StoresOffers {
    private List<Offer> offers;

    public StoresOffers() {
    }

    public StoresOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}

package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Shop {
    private long id;
    private String name;
    private String description;
    private String metro;
    private String address;
    private long iconId;

    public Shop(long id, String name, String description, String metro, String address, long iconId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.metro = metro;
        this.address = address;
        this.iconId = iconId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonGetter(value = "icon_id")
    public long getIconId() {
        return iconId;
    }

    public void setIconId(long iconId) {
        this.iconId = iconId;
    }
}

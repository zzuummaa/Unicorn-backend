package ru.zuma.rest.model;

public class DailyUnicorn {
    private String date;
    private String url;

    public DailyUnicorn() {
    }

    public DailyUnicorn(String date, String url) {
        this.date = date;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

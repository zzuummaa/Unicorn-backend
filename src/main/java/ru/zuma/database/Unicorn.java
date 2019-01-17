package ru.zuma.database;

import javax.persistence.*;

@Entity
@Table(name = "unicorns")
public class Unicorn {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "unicorn_id")
    private Integer id;

    private String date;

    public Unicorn() {
    }

    public Unicorn(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

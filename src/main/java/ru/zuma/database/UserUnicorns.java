package ru.zuma.database;

import javax.persistence.*;

@Entity
public class UserUnicorns {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_unicorns_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String date;

    public UserUnicorns() {
    }

    public UserUnicorns(User user, String date) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

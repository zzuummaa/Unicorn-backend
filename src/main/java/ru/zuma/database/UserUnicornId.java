package ru.zuma.database;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UserUnicornId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "unicorn_id")
    private Unicorn unicorn;

    public UserUnicornId() {
    }

    public UserUnicornId(User user, Unicorn unicorn) {
        this.user = user;
        this.unicorn = unicorn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Unicorn getUnicorn() {
        return unicorn;
    }

    public void setUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }
}

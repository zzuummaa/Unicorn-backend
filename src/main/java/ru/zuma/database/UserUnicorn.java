package ru.zuma.database;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_unicorns")
public class UserUnicorn implements Serializable {

    @EmbeddedId
    private UserUnicornId userUnicornId;

    public UserUnicorn() {
    }

    public UserUnicorn(User user, Unicorn unicorn) {
        this.userUnicornId = new UserUnicornId(user, unicorn);
    }

    public UserUnicorn(UserUnicornId userUnicornId) {
        this.userUnicornId = userUnicornId;
    }

    public UserUnicornId getUserUnicornId() {
        return userUnicornId;
    }

    public void setUserUnicornId(UserUnicornId userUnicornId) {
        this.userUnicornId = userUnicornId;
    }
}

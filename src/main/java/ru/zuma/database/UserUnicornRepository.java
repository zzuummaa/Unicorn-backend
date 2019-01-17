package ru.zuma.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserUnicornRepository extends JpaRepository<UserUnicorn, UserUnicornId> {
    List<UserUnicorn> findByUserUnicornId_User(User user);
}

package ru.zuma.database;

import org.springframework.data.repository.CrudRepository;

public interface UserUnicornRepository extends CrudRepository<UserUnicorn, Integer> {
    UserUnicorn findFirstByUserUnicornId(UserUnicornId userUnicornId);
}

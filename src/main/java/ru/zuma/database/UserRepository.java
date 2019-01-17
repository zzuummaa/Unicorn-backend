package ru.zuma.database;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByAccessToken(String accessToken);

    User findFirstByAndroidId(String androidId);
}

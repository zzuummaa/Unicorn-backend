package ru.zuma.database;

import org.springframework.data.repository.CrudRepository;

public interface UnicornRepository extends CrudRepository<Unicorn, Integer> {
    Unicorn findByDate(String date);
}

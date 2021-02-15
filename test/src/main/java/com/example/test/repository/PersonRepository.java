package com.example.test.repository;

import com.example.test.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    //List<Person> findByDate(LocalDate date);
}

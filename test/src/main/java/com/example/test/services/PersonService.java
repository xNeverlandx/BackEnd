package com.example.test.services;

import com.example.test.model.Person;
import com.example.test.repository.PersonRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> findPerson(Long id, LocalDate date) {
        List<Person> allPersons = new ArrayList<>();
        personRepository.findAll().forEach(allPersons::add);
        List<Person> filterPerson = allPersons
                .stream()
                .filter(f -> f.getId().equals(id))
                .filter(f -> f.getDateOfBirth().equals(date))
                .collect(Collectors.toList());
        log.info("inside PersonService.findPerson");
        return filterPerson;
    }

    /*public List<Person> findPersonByDate(LocalDate date) {
        return personRepository.findByDate(date);
    }*/

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }
}

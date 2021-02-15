package com.example.test.controllers;

import com.example.test.repository.PersonRepository;
import com.example.test.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    @CrossOrigin
    @GetMapping("/getPerson/{id}/{date}")
    public ResponseEntity<?> getPerson(@PathVariable Long id, @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(personService.findPerson(id, localDate));
    }

    @CrossOrigin
    @GetMapping("/getAllPerson")
    public ResponseEntity<?> getAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findAll());
    }
}

package com.canyapan.sample.springredissample.controller;

import com.canyapan.sample.springredissample.model.Person;
import com.canyapan.sample.springredissample.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}/")
    public Person getPerson(@PathVariable final long id) {
        return personService.getPerson(id);
    }

    @GetMapping
    public List<Person> getPerson() {
        return personService.getAllPersons();
    }

    @PostMapping
    public Long createPerson(@Valid @RequestBody Person person) {
        return personService.savePerson(person).getId();
    }

    @DeleteMapping("/{id}/")
    public Person deletePerson(@PathVariable final long id) {
        return personService.deletePerson(id);
    }
}

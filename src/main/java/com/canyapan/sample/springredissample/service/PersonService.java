package com.canyapan.sample.springredissample.service;

import com.canyapan.sample.springredissample.exception.NotFoundException;
import com.canyapan.sample.springredissample.model.Person;
import com.canyapan.sample.springredissample.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;

    @Cacheable(cacheNames = "person")
    public Person getPerson(long id) {
        log.info("Loading id {} from database.", id);
        return personRepo.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Cacheable(cacheNames = "person")
    public List<Person> getAllPersons() {
        log.info("Loading all from database.");
        return personRepo.findAll();
    }

    @CachePut(cacheNames = "person", key = "#person.id")
    public Person savePerson(final Person person) {
        return personRepo.save(person);
    }

    @CacheEvict(cacheNames = "person")
    public Person deletePerson(long id) {
        Person person = getPerson(id);
        personRepo.deleteById(id);

        return person;
    }
}

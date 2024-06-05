package org.example.labapasha.service;

import org.example.labapasha.model.Person;
import org.example.labapasha.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Integer id, Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setSurname(updatedPerson.getSurname());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    updatedPerson.setId(id);
                    return personRepository.save(updatedPerson);
                });
    }
}

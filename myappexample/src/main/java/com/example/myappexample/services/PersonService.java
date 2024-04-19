package com.example.myappexample.services;

import com.example.myappexample.domains.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPerson();
    Person getPerson(Long id);
    void EditPerson(Person o);
    void createPerson(Person p);
    void deletePerson(Long id);
}

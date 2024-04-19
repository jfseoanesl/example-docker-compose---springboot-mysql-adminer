package com.example.myappexample.services;

import com.example.myappexample.domains.Person;
import com.example.myappexample.exceptions.ResourceNotFoundException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Lazy
@Service("LIST")
@ConditionalOnProperty(value = "person-service.estrategia", havingValue = "LIST")
public class PersonServiceListImpl implements PersonService{

    private List<Person> personList= new ArrayList<>();

    public PersonServiceListImpl() {
        System.out.println("creando beam person service list impl ");
    }

    @Override
    public List<Person> getPerson() {
        return this.personList;
    }

    @Override
    public Person getPerson(Long id) {
        Person person = this.personList.stream().filter(p -> p.getId().equals(id)).findAny().orElseThrow(
                () -> new ResourceNotFoundException("El recurso persona con id = "+id+ " no se encuentra registrado")
        );
        return person;
    }

    @Override
    public void EditPerson(Person o) {

        Person person = this.personList.stream()
                .filter(p -> p.getId().equals(o.getId()))
                .findFirst()
                .orElseThrow(
                    () -> new ResourceNotFoundException("El recurso persona con id = "+o.getId()+ " no se encuentra registrado")
                );

        person.setName(o.getName());
        person.setLastName(o.getLastName());
        person.setAge(o.getAge());

    }

    @Override
    public void createPerson(Person p) {

        this.personList.add(p);

    }

    @Override
    public void deletePerson(Long id) {
        Person person = this.personList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new ResourceNotFoundException("El recurso persona con id = "+id+ " no se encuentra registrado")
                );
        this.personList.remove(person);

    }
}

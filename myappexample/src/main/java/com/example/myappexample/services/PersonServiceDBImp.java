package com.example.myappexample.services;


import com.example.myappexample.domains.Person;
import com.example.myappexample.exceptions.ResourceNotFoundException;
import com.example.myappexample.mapStructs.PersonMapper;
import com.example.myappexample.persistence.entities.PersonEntity;
import com.example.myappexample.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


//@Primary
@Service("DB")
@ConditionalOnProperty(value = "person-service.estrategia", havingValue = "DB")
public class PersonServiceDBImp implements PersonService {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper mapper;
    @Override
    public List<Person> getPerson() {

        return this.mapper.listEntityTolistObject(this.repository.findAll());
    }

    @Override
    public Person getPerson(Long id) {

        PersonEntity entity = this.repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("El recurso Person con id " + id +"no se encuentra registrado"));
        return this.mapper.entityToObject(entity);
    }

    @Override
    public void EditPerson(Person o) {
        PersonEntity entity = this.repository.findById(o.getId()).orElseThrow(
                ()->new ResourceNotFoundException("El recurso Person con id " + o.getId() +"no se encuentra registrado")
        );

        entity.setName(o.getName());
        entity.setLastName(o.getLastName());
        entity.setAge(o.getAge());

        this.repository.save(entity);

    }

    @Override
    public void createPerson(Person p) {
       PersonEntity entity = this.mapper.objectToEntity(p);
       this.repository.save(entity);

    }

    @Override
    public void deletePerson(Long id) {

        this.repository.deleteById(id);

    }
}

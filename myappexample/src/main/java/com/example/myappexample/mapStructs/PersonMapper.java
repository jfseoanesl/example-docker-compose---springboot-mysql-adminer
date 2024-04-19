package com.example.myappexample.mapStructs;

import com.example.myappexample.domains.Person;
import com.example.myappexample.persistence.entities.PersonEntity;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper( componentModel = "spring")
public interface PersonMapper {

    Person entityToObject (PersonEntity entity);
    PersonEntity objectToEntity (Person object);
    List<Person> listEntityTolistObject (Collection<PersonEntity> listEntity);
    List<PersonEntity> listObjectTolistEntity (Collection<Person> listObject);
}

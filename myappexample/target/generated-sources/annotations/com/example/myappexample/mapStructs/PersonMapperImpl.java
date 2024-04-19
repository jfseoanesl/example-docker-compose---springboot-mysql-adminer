package com.example.myappexample.mapStructs;

import com.example.myappexample.domains.Person;
import com.example.myappexample.persistence.entities.PersonEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-19T08:27:34-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person entityToObject(PersonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( entity.getId() );
        person.setName( entity.getName() );
        person.setLastName( entity.getLastName() );
        person.setAge( entity.getAge() );

        return person;
    }

    @Override
    public PersonEntity objectToEntity(Person object) {
        if ( object == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( object.getId() );
        personEntity.setName( object.getName() );
        personEntity.setLastName( object.getLastName() );
        personEntity.setAge( object.getAge() );

        return personEntity;
    }

    @Override
    public List<Person> listEntityTolistObject(Collection<PersonEntity> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( listEntity.size() );
        for ( PersonEntity personEntity : listEntity ) {
            list.add( entityToObject( personEntity ) );
        }

        return list;
    }

    @Override
    public List<PersonEntity> listObjectTolistEntity(Collection<Person> listObject) {
        if ( listObject == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( listObject.size() );
        for ( Person person : listObject ) {
            list.add( objectToEntity( person ) );
        }

        return list;
    }
}

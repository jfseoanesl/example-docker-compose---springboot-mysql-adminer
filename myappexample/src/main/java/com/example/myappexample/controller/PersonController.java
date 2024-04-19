package com.example.myappexample.controller;

import com.example.myappexample.domains.Person;
import com.example.myappexample.exceptions.BadRequestException;
import com.example.myappexample.services.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    //@Qualifier("LIST")
    @Lazy
    @Autowired
    private PersonService service;
    @GetMapping
    public ResponseEntity<?>  getPerson(){

        return ResponseEntity.ok(this.service.getPerson());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getPerson(@PathVariable Long id){

        return ResponseEntity.ok(this.service.getPerson(id));

    }

    @PostMapping
    public ResponseEntity<?>  createPerson(@RequestBody Person p){
        if(p==null)
            throw new BadRequestException("El objeto persona es null");

        List<String> errors = new ArrayList<>();
        if(p.getId()==null){
            errors.add("La persona requiere un id");
        }
        if(p.getName().isBlank()){
            errors.add("La persona requiere un name");
        }
        if(p.getLastName().isBlank()){
            errors.add("La persona requiere un lastName");
        }
        if(p.getAge()<=0){
            errors.add("La persona requiere una edad valida");
        }

        if(!errors.isEmpty())
            throw new BadRequestException(errors.toString());

        this.service.createPerson(p);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(p.getId()).toUri();

        return ResponseEntity.created(location).body(p);

    }

    @PutMapping
    public ResponseEntity<?>  editPerson(@RequestBody Person p){

        this.service.EditPerson(p);
        return ResponseEntity.ok(p);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deletePerson(@PathVariable Long id){

        this.service.deletePerson(id);
        return ResponseEntity.noContent().build();

    }



}

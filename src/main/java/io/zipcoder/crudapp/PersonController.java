package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @GetMapping("/person")
    public ResponseEntity<Person> create(@RequestBody Person person){
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(service.getPersonList(), HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}

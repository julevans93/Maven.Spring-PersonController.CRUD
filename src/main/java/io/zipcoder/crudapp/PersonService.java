package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Iterable<Person> index(){
        return repository.findAll();
    }

    public Person show(Integer id){
        return repository.findOne(id);
    }

    public Person create(Person p){
        return repository.save(p);
    }

    public Person update(Integer id, Person newPersonData){
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setLastName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }

    public boolean delete(Integer id){
        repository.delete(id);
        return true;
    }

    public Iterable<Person> getPersonList(){
        return repository.findAll();
    }
}

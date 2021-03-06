/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infnet.service;

import edu.infnet.model.Person;
import edu.infnet.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcelo Vergara <http://marcelo-vergara.codes/>
 */
@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAll() {

        return (List<Person>) repository.findAll();
    }

    // acrescentar save e delete
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }
}

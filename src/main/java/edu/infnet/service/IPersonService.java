/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infnet.service;

import edu.infnet.model.Person;
import java.util.List;

/**
 *
 * @author Marcelo Vergara <http://marcelo-vergara.codes/>
 */
public interface IPersonService {

    List<Person> findAll();

    public void deleteById(Long id);
}

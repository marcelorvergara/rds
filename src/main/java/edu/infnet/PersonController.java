/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infnet;

import edu.infnet.model.Person;
import edu.infnet.service.IPersonService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marcelo Vergara <http://marcelo-vergara.codes/>
 */
@Controller
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);

    @Autowired
    private IPersonService personService;

    @RequestMapping("/")
    public String index() {

        log.info("passei aqui!");
        return "index";
    }

    @GetMapping("/persons")
    public String findPersons(Model model) {

        List<Person> persons = personService.findAll();

        model.addAttribute("persons", persons);

        return "showPersons";
    }
}

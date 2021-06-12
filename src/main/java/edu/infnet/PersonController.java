/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infnet;

import edu.infnet.model.Person;
import edu.infnet.service.IPersonService;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Marcelo Vergara <http://marcelo-vergara.codes/>
 */
@Controller
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);

    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public String index() {

        log.info("passei aqui!");
        return "index";
    }

    @GetMapping("/deletar/{id}")
    public String deletePessoa(@PathVariable Long id) {
        personService.deleteById(id);

        return "redirect:/persons";
    }

    @GetMapping("/editar/{id}")
    public String alterarPessoa(@PathVariable Long id, Model model) throws NotFoundException {

        Person pessoa = personService.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));

        log.info("pessoa aqui" + pessoa);

        model.addAttribute("pessoa", pessoa);

        return "alterar";
    }

    @PostMapping("/update")
    public String updatePessoa(@ModelAttribute("pessoaForm") Person pessoaForm) {

        log.info("Pessoa form: " + pessoaForm);

        Long id = pessoaForm.getId();

        Person p = personService.findById(id).map(person -> {
            person.setFirstName(pessoaForm.getFirstName());
            person.setLastName(pessoaForm.getLastName());
            person.setAddress(pessoaForm.getAddress());
            person.setCity(pessoaForm.getCity());
            return personService.save(person);
        })
                .orElseGet(() -> {
                    pessoaForm.setId(id);
                    return personService.save(pessoaForm);
                });

        return "redirect:/persons";
    }

    @RequestMapping(value = "/inserir")
    public String regsitration(@ModelAttribute("pessoaForm") Person pessoaForm) {

        personService.save(pessoaForm);

        return "redirect:/persons";
    }

    @GetMapping("/persons")
    public String findPersons(Model model
    ) {

        List<Person> persons = personService.findAll();

        model.addAttribute("pessoasLst", persons);

        model.addAttribute("pessoaIns", new Person());

        return "showPersons";
    }
}

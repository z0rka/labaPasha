package org.example.labapasha.controller;

import lombok.RequiredArgsConstructor;

import org.example.labapasha.model.Person;
import org.example.labapasha.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppDemo {

    private final PersonService personService;

    @GetMapping("/")
    public String home(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name != null ? name : "World");

        Iterable<Person> personList = personService.findAll();
        model.addAttribute("personList", personList);

        return "index";
    }

    @PostMapping("/")
    public String addPerson(@RequestParam("name") String name, @RequestParam("surname") String surname, Model model) {
        Person personDto = new Person();
        personDto.setName(name);
        personDto.setSurname(surname);
        personService.save(personDto);

        return "redirect:/";
    }
}

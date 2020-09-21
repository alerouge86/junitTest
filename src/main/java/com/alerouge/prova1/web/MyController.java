package com.alerouge.prova1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.repository.service.IPersonService;

@RestController
public class MyController {

	@Autowired
	private IPersonService service;
	
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person){
		Person personCreated = service.createPerson(person);
		System.out.println(personCreated);
		return personCreated;
	}
	
	@GetMapping("/getAllPersons")
	public List<Person> getAllPersons(){
		return service.getAllPersons();
	}
}

package com.alerouge.prova1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.service.IPersonService;
import com.alerouge.prova1.session.DatiSessione;
import com.google.common.base.Strings;

@RestController
public class MyController {

	@Autowired
	private DatiSessione datiSessione;
	
	@Autowired
	private IPersonService service;
	
	@GetMapping("/getAllPersons")
	public List<Person> getAllPersons(){
		
		System.out.println("[getAllPersons] nome sessione (from controller): " + getNomeSess());

		return service.getAllPersons();
	}

	@GetMapping("/getPerson/{id}")
	public Person getPerson(@PathVariable Long id){
		Optional<Person> optionalPerson = service.getPersonById(id);
		if (optionalPerson.isPresent()) {
			
			Person personReturned = optionalPerson.get();
			
			// TODO: solo per test session bean
//			personReturned.setName(getNomeSess());
			
			System.out.println("[getPerson/{id}] nome sessione (from controller): " + getNomeSess());
			
			return personReturned;
		} else {
			return null;
		}
	}

	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person){
		Person personCreated = service.createPerson(person);
		
		// logica per test...
		personCreated.setPoints(146);

		System.out.println("[savePerson] nome sessione (from controller): " + getNomeSess());

		return personCreated;
	}

	@GetMapping("/setNomeSessione/{nome}")
	public boolean setNomeSessione(@PathVariable String nome) {
		try {
			datiSessione.init(nome);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/getNomeSessione")
	public String getNomeSessione() {
		return getNomeSess();
	}
	
	private String getNomeSess() {
		if (!StringUtils.isEmpty(datiSessione.getNomeSessione())){
			return datiSessione.getNomeSessione();
		} else {
			return "not defined";
		}
	}

}

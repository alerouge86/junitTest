package com.alerouge.prova1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

	private PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Person> getAllPersons() {
		return repository.findAll();
	}

	@Override
	public Optional<Person> getPersonById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Person createPerson(Person person) {
		
		// some business logic
		person.setPoints(person.getPoints()+2);
		
		return repository.save(person);
	}

}

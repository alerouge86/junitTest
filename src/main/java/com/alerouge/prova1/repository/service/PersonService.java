package com.alerouge.prova1.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository repository;
	
	@Override
	public List<Person> getAllPersons() {
		return repository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		Optional<Person> optionPerson = repository.findById(id);
		if (optionPerson.isPresent()){
			return optionPerson.get();
		} else {
			return null;
		}
	}

	@Override
	public Person createPerson(Person person) {
		return repository.save(person);
	}

}

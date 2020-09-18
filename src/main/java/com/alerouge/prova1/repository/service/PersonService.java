package com.alerouge.prova1.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}
	
	@Override
	public Person findById(Long id) {
		Optional<Person> user = personRepository.findById(id);
		if (user.isPresent()){
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public Person findByNome(String nome) {
		return personRepository.findByNome(nome);
	}

	@Override
	public Person savePerson(PersonDto personDto) {
		Person person = new Person(personDto.getNome());
		Person personSaved = personRepository.save(person);
//		personSaved.setNome(null);
		return personSaved;
	}

}

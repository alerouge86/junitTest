package com.alerouge.prova1.service;

import java.util.List;
import java.util.Optional;

import com.alerouge.prova1.model.Person;

public interface IPersonService {

	List<Person> getAllPersons();

	Optional<Person> getPersonById(Long id);

	Person createPerson(Person person);

}

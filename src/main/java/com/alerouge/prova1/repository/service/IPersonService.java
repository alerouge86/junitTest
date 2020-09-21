package com.alerouge.prova1.repository.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alerouge.prova1.model.Person;

public interface IPersonService {

	List<Person> getAllPersons();

	Person getPersonById(Long id);

	Person createPerson(Person person);

}

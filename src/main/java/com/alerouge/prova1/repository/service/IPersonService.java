package com.alerouge.prova1.repository.service;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.model.PersonDto;

public interface IPersonService {

	Person findById(Long id);

	Person findByNome(String nome);

	Person savePerson(PersonDto personDto);
	
}

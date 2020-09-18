package com.alerouge.prova1.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.repository.PersonRepository;
import com.alerouge.prova1.repository.service.PersonService;

import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonService personService;
	

	@Test
	@Disabled
	void savePerson_hasNome(){
		PersonDto personDto = new PersonDto("ike");
		when(personRepository.save(any(Person.class))).then(returnsFirstArg());
		
		Person personSaved = personService.savePerson(personDto);
		assertThat(personSaved.getNome()).isNotNull();
	}
	
	
}

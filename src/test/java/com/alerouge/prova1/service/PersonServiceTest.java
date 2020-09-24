package com.alerouge.prova1.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.repository.PersonRepository;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PersonServiceTest {

	// Autowire in the service we want to test
	@Autowired
	private PersonService service;


	// Create a mock implementation of the PersonRepository
	@MockBean
	private PersonRepository repository;

	@Test
	@DisplayName("Get person by ID")
	public void testGetPersonById() {

		// setup mock repository
		Person person = new Person(1L, "alex", 46);
		doReturn(Optional.of(person)).when(repository).findById(1L);

		// execute the service call
		Optional<Person> returnedPerson = service.getPersonById(1L);

		// assert the response
		Assertions.assertTrue(returnedPerson.isPresent(), "person 1L was not found");
		Assertions.assertSame(returnedPerson.get(), person, "the person returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findById Not FOund")
	void testFindByIdNotFound() {
		// Setup our mock repository
		doReturn(Optional.empty()).when(repository).findById(1L);

		// Execute the service call
		Optional<Person> returnedPerson = service.getPersonById(1L);

		// Assert the response
		Assertions.assertFalse(returnedPerson.isPresent(), "Person should not be found");
	}

	@Test
    @DisplayName("Test findAll Persons")
    void testFindAll() {
        // Setup our mock repository
        Person person1 = new Person(1L, "Person 1", 23);
        Person person2 = new Person(2L, "Person 2", 46);
        doReturn(Arrays.asList(person1, person2)).when(repository).findAll();

        // Execute the service call
        List<Person> persons = service.getAllPersons();

        // Assert the response
        Assertions.assertEquals(2, persons.size(), "findAll should return 2 persons");
    }

	@Test
    @DisplayName("Test person widget with points increment")
    void testSave() {
        // Setup our mock repository
        Person person = new Person(1L, "Person 1", 55, 10);
        doReturn(person).when(repository).save(any());

        // Execute the service call
        Person returnedPerson = service.createPerson(person);

        // Assert the response
        Assertions.assertNotNull(returnedPerson, "The saved person should not be null");
        Assertions.assertEquals(12, returnedPerson.getPoints(), "The points number should be incremented of 2");
    }
	
}

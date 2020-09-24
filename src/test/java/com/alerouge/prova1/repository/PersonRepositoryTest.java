package com.alerouge.prova1.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.alerouge.prova1.model.Person;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.junit5.DBUnitExtension;
import com.google.common.collect.Lists;

@ExtendWith(DBUnitExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class PersonRepositoryTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PersonRepository repository;
	
	public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }

	@Test
    void testFindAll() {
        List<Person> persons = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(4, persons.size(), "Expected 3 person in the database");
    }
	
	@Test
    void testFindByIdSuccess() {
        Optional<Person> person = repository.findById(1L);
        Assertions.assertTrue(person.isPresent(), "We should find a person with ID 1");

        Person p = person.get();
        Assertions.assertEquals(1, p.getId(), "The person ID should be 1");
        Assertions.assertEquals("alex", p.getName(), "Incorrect person name");
        Assertions.assertEquals(25, p.getAge(), "Incorrect person age");
    }
	
	@Test
    void testFindByIdNotFound() {
        Optional<Person> person = repository.findById(10L);
        Assertions.assertFalse(person.isPresent(), "A person with ID 10 should not be found");
    }

    @Test
    void testFindPersonsWithStartWith_a() {
        List<Person> persons = repository.findPersonsWithNameStartWith("a%");
        Assertions.assertEquals(2, persons.size());
    }
    
}

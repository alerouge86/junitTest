package com.alerouge.prova1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alerouge.prova1.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query(value = "SELECT p FROM person p WHERE p.name LIKE ?1")
	List<Person> findPersonsWithNameStartWith(String startWith);
}

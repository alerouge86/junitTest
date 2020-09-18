package com.alerouge.prova1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alerouge.prova1.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByNome(String nome);
	
}

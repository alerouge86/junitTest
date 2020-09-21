package com.alerouge.prova1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alerouge.prova1.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

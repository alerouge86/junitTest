package com.alerouge.prova1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "person")
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	private int age;

	private int points;

	public Person() {
		
	}

	public Person(String name, int age) {
		this(0L, name, age, 0);
	}

	public Person(Long id, String name, int age) {
		this(id, name, age, 0);
	}

	public Person(Long id, String name, int age, int points) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.points = points;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}

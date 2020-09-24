package com.alerouge.prova1.testing;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceDummy {

	private RepoDummy repository;
	
	public ServiceDummy(RepoDummy repository) {
		this.repository = repository;
	}

	public List<String> getStuffStartWithA() {
		try {
			return repository.getStuff().stream()
					.filter(stuff -> stuff.startsWith("a"))
					.collect(Collectors.toList());
		} catch (SQLException e) {
			return Arrays.asList();
		}
	}
	
}

package com.alerouge.prova1.testing;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceDummyTest {

	@Mock
	RepoDummy repository;
	
	@InjectMocks
	ServiceDummy service;

	@Test
	public void testSucces() {
		// setup mockito scenario
		try {
			Mockito.when(repository.getStuff()).thenReturn(Arrays.asList("ale", "vita", "mike", "john", "adriano"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Execute the service that uses the mocked repository
		List<String> stuff = service.getStuffStartWithA();
		
		// validate the response
		Assertions.assertNotNull(stuff);
		Assertions.assertEquals(2, stuff.size());
	}
}

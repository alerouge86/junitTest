package com.alerouge.prova1.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.alerouge.prova1.model.Person;
import com.alerouge.prova1.service.PersonService;
import com.alerouge.prova1.utility.UtiJson;
import com.google.common.collect.Lists;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
class MyControllerTest {

	@MockBean
	private PersonService service;

	@Autowired
	private MockMvc mockMvc;

	@Disabled
	@Test
	@DisplayName("GET /persons success")
	public void testGetPersonsSuccess() throws Exception {
		// Setup our mocked service
		Person person1 = new Person(1L, "Person 1", 23);
		Person person2 = new Person(2L, "Person 2", 46);
		doReturn(Lists.newArrayList(person1, person2)).when(service).getAllPersons();

		// Execute the GET request
		mockMvc.perform(get("/getAllPersons"))
		// Validate the response code and content type
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))

		// Validate headers
		//		.andExpect(header().string(HttpHeaders.LOCATION, "/rest/persons"))

		// Validate the returned fields
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is(1)))
		.andExpect(jsonPath("$[0].name", is("Person 1")))
		.andExpect(jsonPath("$[0].age", is(23)))
		.andExpect(jsonPath("$[1].id", is(2)))
		.andExpect(jsonPath("$[1].name", is("Person 2")))
		.andExpect(jsonPath("$[1].age", is(46)));
	}

	@Test
	@DisplayName("GET /person/1")
	void testGetPersonById() throws Exception {
		// Setup our mocked service
		Person person = new Person(1L, "Person 1", 23);
		doReturn(Optional.of(person)).when(service).getPersonById(1L);

		// Execute the GET request
		mockMvc.perform(get("/getPerson/{id}", 1L))

		// Validate the response code and content type
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))

		// Validate the returned fields
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.name", is("Person 1")))
		.andExpect(jsonPath("$.age", is(23)));
	}

	@Disabled
	@Test
	@DisplayName("GET getPerson/1 - Not Found")
	void testGetPersonByIdNotFound() throws Exception {
		// Setup our mocked service
		doReturn(Optional.empty()).when(service).getPersonById(1L);

		// Execute the GET request
		mockMvc.perform(get("/getPerson/{id}", 1L))
		
		// Validate the response code
		.andExpect(jsonPath("$").doesNotExist())
		.andExpect(status().isOk());
	}
	
	@Disabled
	@Test
    @DisplayName("POST /savePerson")
    void testCreatePerson() throws Exception {
        // Setup our mocked service
        Person personToPost = new Person("Person 1", 23);
        Person personToReturn = new Person(1L, "Person 1", 23);
        doReturn(personToReturn).when(service).createPerson(any());

        // Execute the POST request
        mockMvc.perform(post("/savePerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UtiJson.asJsonString(personToPost)))

                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Person 1")))
                .andExpect(jsonPath("$.age", is(23)))
                .andExpect(jsonPath("$.points", is(146)));
    }
	
}

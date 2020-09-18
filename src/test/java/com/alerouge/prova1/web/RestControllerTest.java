package com.alerouge.prova1.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.repository.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = RestController.class)
public class RestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//	private ObjectMapper objectMapper;
	
	@MockBean
	private PersonService personService;
	
	@Test
	@Disabled
	void ritornaPerson1() throws Exception {

		mockMvc.perform(get("/rest/person/1"))
		   .andExpect(status().isOk());
	}

	@Test
	void save_person_Joe_and_expectNome_Joe() throws Exception{
		
		mockMvc.perform(get("/rest/savePerson/joe"))
		   .andExpect(status().isOk());

		ArgumentCaptor<PersonDto> personCaptor = ArgumentCaptor.forClass(PersonDto.class);
		verify(personService, times(1)).savePerson(personCaptor.capture());
		assertThat(personCaptor.getValue().getNome()).isEqualTo("joe");
	}
	
	
}

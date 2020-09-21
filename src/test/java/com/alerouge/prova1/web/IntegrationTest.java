package com.alerouge.prova1.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.alerouge.prova1.model.PersonDto;
import com.alerouge.prova1.model.UserLoggedSession;
import com.alerouge.prova1.repository.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

	/*
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void init () {
		this.mockMvc = webAppContextSetup(this.wac).build();
		
//		  MockHttpSession mocksession = new MockHttpSession();
//		  this.mockMvc.perform(
//		    get("/rest/initSession")
//		      .session(mocksession));
	}
	
	
	@Test
	 public void testSessionScope() throws Exception {
	  MockHttpSession mocksession = new MockHttpSession();
	  this.mockMvc.perform(
	    get("/rest/initSession")
	      .session(mocksession))
	    .andExpect(status().isOk());
	 
	  this.mockMvc.perform(
	    get("/rest/getSession")
	     .session(mocksession))
	    .andExpect(status().isOk());
	  
	  
		System.out.println("test: chiamata get Person");
		
		mockMvc.perform(get("/rest/person/1"))
		   .andExpect(status().isOk());

	  
	}
	
*/	
}

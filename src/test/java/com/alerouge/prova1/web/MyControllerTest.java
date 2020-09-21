package com.alerouge.prova1.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.alerouge.prova1.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setupTest(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	@Ignore
	public void savePersonTest() throws Exception{
		Person person = new Person();
		person.setName("cri");
		person.setAge(18);
		String jsonRequest = objectMapper.writeValueAsString(person);
		
		MvcResult result = mockMvc.perform(post("/savePerson").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
	
		String resultContent = result.getResponse().getContentAsString();
		Person personSaved = objectMapper.readValue(resultContent, Person.class);
		Assert.assertTrue(personSaved.getName().equals("cri"));
		
	}

	
	@Test
	public void getAllPersonsTest() throws Exception {
		System.out.println("here 1");
		
		MvcResult result = mockMvc.perform(get("/getPerson/1").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		System.out.println("here 2");

		String resultContent = result.getResponse().getContentAsString();
		System.out.println(resultContent);
		Person person = objectMapper.readValue(resultContent, Person.class);
		Assert.assertTrue(person!=null);
		Assert.assertTrue(StringUtils.isEmpty(person.getName()));
	}
	
}

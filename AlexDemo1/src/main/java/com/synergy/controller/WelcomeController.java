package com.synergy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synergy.model.Student;

@RestController
public class WelcomeController {

	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public Student welcome() {
		Student student = new Student();
		student.setId(1);
		student.setName("Ankit Arora");
		student.setAge(39);
		return student;
	}
	
	@RequestMapping(value = "/returnjson/{stdName}",method = RequestMethod.GET)
	public JsonNode returnjson(@PathVariable String stdName) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.createObjectNode();
		((ObjectNode) node).put("id", 100);
		((ObjectNode) node).put("name", "Ankit Arora");
		((ObjectNode) node).put("age", 30);
		
		JsonNode node1 = mapper.createObjectNode();
		((ObjectNode) node1).put("id", 101);
		((ObjectNode) node1).put("name", "Amit Arora");
		((ObjectNode) node1).put("age", 46);
		
		if(stdName.equals("Ankit Arora")) {
			return node;
		}
		else if(stdName.equals("Amit Arora")) {
			return node1;
		}
		else {
			return null;
		}
		
	}
	
	@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("Welcome Mr."+student.getName());
		return student;
	}
}

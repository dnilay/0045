package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeRestController {
	
	private final Environment environment;
	private Map<Integer, Employee> map=null;

	@Autowired
	public EmployeeRestController(Environment environment) {
	
		map=new HashMap<Integer,Employee>();
		map.put(new Random().nextInt(1000), new Employee(UUID.randomUUID().toString(), "John", "Doe","john@email.com"));
		map.put(new Random().nextInt(1000), new Employee(UUID.randomUUID().toString(), "Marry", "Public","marry@email.com"));
		map.put(new Random().nextInt(1000), new Employee(UUID.randomUUID().toString(), "Sourav", "Ganguly","sourav@email.com"));
		map.put(new Random().nextInt(1000), new Employee(UUID.randomUUID().toString(), "Rahul", "Dravid","rahul@email.com"));
		this.environment = environment;
	}
	@RequestMapping
	public String getStatus()
	{
		return "employee service is up and running on port:"+environment.getProperty("local.server.port");
	}
	
	@GetMapping("/employees")
	public Collection<Employee> getAllEmployees()
	{
		return map.values();
	}
	

}

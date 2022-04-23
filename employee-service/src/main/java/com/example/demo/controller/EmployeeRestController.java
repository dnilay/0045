package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeRestController {

	private final Environment environment;
	private Map<Integer, Employee> map = null;

	@Autowired
	public EmployeeRestController(Environment environment) {

		map = new HashMap<Integer, Employee>();
		map.put(new Random().nextInt(1000), new Employee("John", "Doe", "john@email.com"));
		map.put(new Random().nextInt(1000), new Employee("Marry", "Public", "marry@email.com"));
		map.put(new Random().nextInt(1000), new Employee("Sourav", "Ganguly", "sourav@email.com"));
		map.put(new Random().nextInt(1000), new Employee("Rahul", "Dravid", "rahul@email.com"));
		this.environment = environment;
	}

	@GetMapping
	public String getStatus() {
		log.info("displaying map: {}",map.entrySet().toString());
		return "employee service is up and running on port:" + environment.getProperty("local.server.port");
	}

	@GetMapping("/employees")
	public Collection<Employee> getAllEmployees() {
		return map.values();
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		map.put(new Random().nextInt(1000), employee);
		return employee;
	}
	@GetMapping("/employees/{id}")
	public Employee findEmployeeByid(@PathVariable("id") int id)
	{
		Employee employee=map.get(id);
		return employee;
	}

}

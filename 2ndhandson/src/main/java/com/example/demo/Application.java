package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		org.springframework.context.ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat=context.getBean("dateFormat",SimpleDateFormat.class);
		java.util.Date date=new java.util.Date();
		
		String strDate= dateFormat.format(date);  
		System.out.println(strDate);
	}

}

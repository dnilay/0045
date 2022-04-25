package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		displayDate(new Date());
	}
	
	public static void displayDate(Date date)
	{
		log.info("START");
		org.springframework.context.ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		

		String strDate = dateFormat.format(date);
		log.debug(strDate);
		System.out.println(strDate);
		log.info("END");
	}

}

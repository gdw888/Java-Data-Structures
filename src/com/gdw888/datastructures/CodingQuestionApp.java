package com.gdw888.datastructures;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CodingQuestionApp {

	public static void main(String[] args) {

		// define xml application context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the main driver
		CodingQuestionDriver driver = context.getBean("codingQuestionDriver", CodingQuestionDriver.class);
		
		// get the question bean from the properties
		CodingSolution codingSolution = context.getBean(driver.getQuestionName(),CodingSolution.class);

		// validate the answer
		driver.validateAnswer(codingSolution);
		
		context.close();
	}

}

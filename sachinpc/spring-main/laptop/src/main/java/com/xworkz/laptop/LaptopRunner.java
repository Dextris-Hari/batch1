package com.xworkz.laptop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaptopRunner {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		// Object bean = context.getBean("Laptop.class");
		LapTop bean = context.getBean(LapTop.class);
		System.out.println(bean);
	}

}

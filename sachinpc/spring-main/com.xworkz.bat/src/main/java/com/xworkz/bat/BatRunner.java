package com.xworkz.bat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatRunner {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
      Bat bean = context.getBean(Bat.class);
      System.out.println(bean);
	}

}

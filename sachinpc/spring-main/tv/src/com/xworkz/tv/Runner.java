package com.xworkz.tv;

public class Runner {
	public static void main(String[] args) {
 
		ApplicationContext conatiner = new ClassPathXmlApplicationContext("configurecontext.xml");
		System.out.println(conatiner);
		TV bean = conatiner.getBean(TV.class);
		System.out.println(bean);
		System.out.println(bean.color);
		System.out.println(bean.price);
		System.out.println(bean.dispaly.name);
		System.out.println(bean.dispaly.price);
		System.out.println(bean.remote.name);
		System.out.println(bean.remote.price);
		System.out.println(bean.setupBox.name);
		System.out.println(bean.setupBox.price);
		System.out.println(bean.stand.name);
		System.out.println(bean.stand.price);

	}

}

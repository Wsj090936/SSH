package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_DI {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) applicationContext.getBean("UserServiceId");
		
		us.save();
	}
}
 
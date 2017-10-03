package beanProcessor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Processor {
	@Test
	public void fun1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanProcessor/bean.xml");
		UserService us = applicationContext.getBean("UserServiceId", UserServiceImpl.class);
		
		us.addUser();
		applicationContext.close();
	}
}

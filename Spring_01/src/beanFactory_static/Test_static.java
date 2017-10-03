package beanFactory_static;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_static {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanFactory_static/bean.xml");
		UserService us = applicationContext.getBean("UserServiceId", UserService.class);
		us.addUser();
	}
}

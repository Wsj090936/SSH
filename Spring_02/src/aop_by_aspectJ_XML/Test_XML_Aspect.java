package aop_by_aspectJ_XML;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_XML_Aspect {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop_by_aspectJ_XML/bean.xml");
		UserService us = (UserService) applicationContext.getBean("UserServiceId");
		us.addUser();
		us.deleteUser();
	}
}

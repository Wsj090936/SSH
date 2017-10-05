package aop_by_auto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_auto_AOP {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop_by_auto/bean.xml");
		UserService us = applicationContext.getBean("UserServiceId", UserService.class);
		us.addUser();
		us.deleteUser();
	}
	
}
 
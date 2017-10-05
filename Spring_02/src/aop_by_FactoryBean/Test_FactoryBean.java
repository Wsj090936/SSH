package aop_by_FactoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_FactoryBean {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop_by_FactoryBean/bean.xml");
		UserService us = applicationContext.getBean("proxyServiceId", UserService.class);
		us.addUser();
		us.deleteUser();
	}
	
}
 
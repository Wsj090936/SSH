package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	@Test
	public void fun1(){
		//传统的方式
		UserService us = new UserServiceImpl();
		us.addUser();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");//将配置文件的路径输入进去
		UserService us1 = (UserService) applicationContext.getBean("UserServiceId");//得到Bean，其中的参数是配置文件中的id
		us1.addUser();
		
	}
}
 
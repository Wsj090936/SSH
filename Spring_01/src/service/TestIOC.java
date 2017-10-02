package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	@Test
	public void fun1(){
		//��ͳ�ķ�ʽ
		UserService us = new UserServiceImpl();
		us.addUser();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");//�������ļ���·�������ȥ
		UserService us1 = (UserService) applicationContext.getBean("UserServiceId");//�õ�Bean�����еĲ����������ļ��е�id
		us1.addUser();
		
	}
}
 
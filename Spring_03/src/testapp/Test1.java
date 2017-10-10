package testapp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AccountService;

public class Test1 {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountService as = (AccountService) applicationContext.getBean("accountService");
		as.transform("jack", "tom", 1000);
	}
}

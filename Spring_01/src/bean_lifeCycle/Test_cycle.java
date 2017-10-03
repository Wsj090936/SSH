package bean_lifeCycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_cycle {
	@Test
	public void fun1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_lifeCycle/bean.xml");
		UserService us = applicationContext.getBean("UserServiceId", UserServiceImpl.class);
		us.addUser();
		//关闭容器会执行销毁方法
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();
	}
}	

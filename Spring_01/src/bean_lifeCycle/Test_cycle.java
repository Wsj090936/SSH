package bean_lifeCycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_cycle {
	@Test
	public void fun1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_lifeCycle/bean.xml");
		UserService us = applicationContext.getBean("UserServiceId", UserServiceImpl.class);
		us.addUser();
		//�ر�������ִ�����ٷ���
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		applicationContext.close();
	}
}	

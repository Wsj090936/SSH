package bean_construct;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Construct {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_construct/bean.xml");
		User user = applicationContext.getBean("UserId", User.class);
		System.out.println(user);
	}
}

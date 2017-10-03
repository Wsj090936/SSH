package bean_setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Setter {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_setter/bean.xml");
		Person person = applicationContext.getBean("PersonId",Person.class);
		
		System.out.println(person);
	}
}

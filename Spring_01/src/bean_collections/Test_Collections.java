package bean_collections;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Collections {
	@Test
	public void fun1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean_collections/bean.xml");
		CollectionsData data = applicationContext.getBean("CollectionId", CollectionsData.class);
		System.out.println(data);
	}
}

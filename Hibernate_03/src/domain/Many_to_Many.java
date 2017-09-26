package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

public class Many_to_Many {
	
	@Test
	/**
	 * 通过学生保存课程，由学生维护外键
	 * 因此，Student配置文件中inverse为false，cascade为save-update
	 * 		Course配置文件中，inverse为true
	 */
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student stu1 = new Student();
		stu1.setName("tom");
		
		Course c1 = new Course();
		c1.setName("Java");
		
		Course c2 = new Course();
		c2.setName("C++");
		
		Course c3 = new Course();
		c3.setName("Python");
		
		stu1.getCourses().add(c1);//维护关系，级联保存
		stu1.getCourses().add(c2);//维护关系，级联保存
		stu1.getCourses().add(c3);//维护关系，级联保存
		
		session.save(stu1);
		
		transaction.commit();
		session.close(); 
	}
}

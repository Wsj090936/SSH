package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

public class Many_to_Many {
	
	@Test
	/**
	 * ͨ��ѧ������γ̣���ѧ��ά�����
	 * ��ˣ�Student�����ļ���inverseΪfalse��cascadeΪsave-update
	 * 		Course�����ļ��У�inverseΪtrue
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
		
		stu1.getCourses().add(c1);//ά����ϵ����������
		stu1.getCourses().add(c2);//ά����ϵ����������
		stu1.getCourses().add(c3);//ά����ϵ����������
		
		session.save(stu1);
		
		transaction.commit();
		session.close(); 
	}
}

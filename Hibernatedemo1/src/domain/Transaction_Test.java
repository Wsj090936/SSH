package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Transaction_Test {
	@Test
	public void fun1(){
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();//得到与当前线程绑定的事务
		
		session.beginTransaction().commit();//打开事务之后马上提交事务
		Session session2 = sessionFactory.getCurrentSession();//再次得到与当前线程绑定的事务
		System.out.println(session == session2);//false，因此可以的出当事务提交之后，与当前线程绑定的Session对象会被删除掉
	}
}

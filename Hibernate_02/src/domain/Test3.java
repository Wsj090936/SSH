package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

public class Test3 {
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		System.out.println(user);
		user.setName("Lily");
		session.flush();
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		
		session.close();
	}
}

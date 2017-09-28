package Lock;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;
import domain.Customer;

public class Test_Lock {
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 5, LockOptions.UPGRADE);//Ìí¼ÓÐ´Ëø
		System.out.println(customer);
		
		
		transaction.commit();
		session.close();
	}
}

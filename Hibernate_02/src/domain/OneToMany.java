package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

/**
 * 一对多关系的测试
 * @author wushijia
 *
 */
public class OneToMany {
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("苹果");
		
		Order o2 = new Order();
		o2.setName("梨");
		
		c.getOrders().add(o1);////多余了
		c.getOrders().add(o2);//多余了
		
		o1.setCustomer(c);
		o2.setCustomer(c);
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		transaction.commit();
		session.close();
	}
}

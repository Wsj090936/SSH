package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

/**
 * һ�Զ��ϵ�Ĳ���
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
		o1.setName("ƻ��");
		
		Order o2 = new Order();
		o2.setName("��");
		
		c.getOrders().add(o1);////������
		c.getOrders().add(o2);//������
		
		o1.setCustomer(c);
		o2.setCustomer(c);
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		transaction.commit();
		session.close();
	}
}

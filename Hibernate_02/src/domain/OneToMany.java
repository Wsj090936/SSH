package domain;

import java.util.Iterator;
import java.util.Set;

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
	public void fun1(){//save-update �����޸ġ���������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("ƻ��");
		
		Order o2 = new Order();
		o2.setName("��");
		
		c.getOrders().add(o1);//ά����ϵ
		c.getOrders().add(o2);//ά����ϵ
		
//		o1.setCustomer(c);
//		o2.setCustomer(c);
		
		session.save(c);
//		session.save(o1);
//		session.save(o2);
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 4);
		
		Set<Order> orders = customer.getOrders();
		
		for (Order order : orders) {
			order.setName("������");
		}
		
		transaction.commit();//�������˼�������save-update��commitʱ���Զ�����Order�ı仯
		session.close();
	}
	@Test
	public void fun3(){//delete-orphan���¶�ɾ��
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 7);
		
		Set<Order> orders = customer.getOrders();
		Iterator<Order> iterator = orders.iterator();
		while(iterator.hasNext()){
			iterator.next();
			iterator.remove();
		}
		
		transaction.commit();
		session.close();
	}
}

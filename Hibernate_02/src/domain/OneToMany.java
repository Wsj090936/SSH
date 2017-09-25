package domain;

import java.util.Iterator;
import java.util.Set;

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
	public void fun1(){//save-update 级联修改、级联保存
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer c = new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("苹果");
		
		Order o2 = new Order();
		o2.setName("梨");
		
		c.getOrders().add(o1);//维护关系
		c.getOrders().add(o2);//维护关系
		
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
			order.setName("哈哈哈");
		}
		
		transaction.commit();//当设置了级联保存save-update，commit时会自动保存Order的变化
		session.close();
	}
	@Test
	public void fun3(){//delete-orphan：孤儿删除
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

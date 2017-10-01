package second_level;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import Utils.HibernateUtils;
import domain.Customer;

public class Test_Second_Level {
	@Test
	public void fun1(){//类缓存：证明二级缓存存在，去除一级缓存中的内容，再次进行查询
		Session session = HibernateUtils.openSession();//得到session对象
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 2);
		
		session.clear();
		
		Customer customer2 = session.get(Customer.class, 2);
		
		System.out.println(customer==customer2);
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun2(){//查询缓存：证明二级缓存存在，去除一级缓存中的内容，再次进行查询
		Session session = HibernateUtils.openSession();//得到session对象
		Transaction transaction = session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		//设置使用查询缓存
		//查询时先在二级缓存中查找，如果没有，就去数据库查找，然后将查找结果放入二级缓存中
		query.setCacheable(true);
		List<Customer> list = query.list();
		System.out.println(list);
		
		//第二次进行查询
		Query<Customer> query1 = session.createQuery("from Customer",Customer.class);
		query1.setCacheable(true);
		List<Customer> list1 = query1.list();
		
		System.out.println(list1);
		
		transaction.commit();
		session.close();
	}
} 

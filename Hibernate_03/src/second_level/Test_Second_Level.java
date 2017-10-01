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
	public void fun1(){//�໺�棺֤������������ڣ�ȥ��һ�������е����ݣ��ٴν��в�ѯ
		Session session = HibernateUtils.openSession();//�õ�session����
		Transaction transaction = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 2);
		
		session.clear();
		
		Customer customer2 = session.get(Customer.class, 2);
		
		System.out.println(customer==customer2);
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun2(){//��ѯ���棺֤������������ڣ�ȥ��һ�������е����ݣ��ٴν��в�ѯ
		Session session = HibernateUtils.openSession();//�õ�session����
		Transaction transaction = session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		//����ʹ�ò�ѯ����
		//��ѯʱ���ڶ��������в��ң����û�У���ȥ���ݿ���ң�Ȼ�󽫲��ҽ���������������
		query.setCacheable(true);
		List<Customer> list = query.list();
		System.out.println(list);
		
		//�ڶ��ν��в�ѯ
		Query<Customer> query1 = session.createQuery("from Customer",Customer.class);
		query1.setCacheable(true);
		List<Customer> list1 = query1.list();
		
		System.out.println(list1);
		
		transaction.commit();
		session.close();
	}
} 

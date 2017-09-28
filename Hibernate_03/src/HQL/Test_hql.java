package HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import Utils.HibernateUtils;
import domain.Customer;

public class Test_hql {
	@Test
	public void fun1(){//hql��ѯ����
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query query = session.createQuery("from Customer");
		Query<Customer> query = session.createQuery("select c from Customer c",Customer.class);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun2(){//hql��ѯĳ������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select c.id,c.name from Customer c");
		
		List<Object[]> list = query.list();
		for(Object[] o : list){
			System.out.println(Arrays.toString(o));
		}
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun3(){//hql��ѯ   ͶӰ��ѯ,����ѯ���������ݷ�װ��������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun4(){//hql��ѯ   ����
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c order by c.id desc");//��������
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun5(){//hql��ѯ   ��ҳ
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c order by c.id desc");//��������
		//limit ?,?  setFirstResult,setMaxResults
		query.setFirstResult(0);//�ӵ�һ��������ʼ
		query.setMaxResults(2);//ÿ�β�ѯ����
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun6(){//hql��ѯ   �󶨲�����ռλ��
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query query = session.createQuery("from Customer c where c.id=?");//JDBC��ʹ�õķ�����Hibernate��Ҳ����ʹ��
//		query.setInteger(0,10);
		Query query = session.createQuery("from Customer c where c.id = :a");
		query.setParameter("a", 10);//���ռλ��
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun7(){//hql��ѯ   �ۺϺ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query query = session.createQuery("select count(*) from Customer c");
//		Query query = session.createQuery("select avg(c.id) from Customer c");
//		Query query = session.createQuery("select sum(c.id) from Customer c");
//		Query query = session.createQuery("select max(c.id) from Customer c");
		Query query = session.createQuery("select min(c.id) from Customer c");
		Object result = query.uniqueResult();
		
		System.out.println(result);
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun8(){//hql��ѯ   ����
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select o.customer,count(o) from Order o group by o.customer having count(o) > 1");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun9(){//�����ļ������úõ�hql���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("domain.Student.abc");
		List list = query.list();
		
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
}

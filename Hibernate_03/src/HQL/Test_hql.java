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
	public void fun1(){//hql查询所有
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
	public void fun2(){//hql查询某个属性
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
	public void fun3(){//hql查询   投影查询,将查询出来的数据封装到对象中
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun4(){//hql查询   排序
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c order by c.id desc");//降序排序
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun5(){//hql查询   分页
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer c order by c.id desc");//降序排序
		//limit ?,?  setFirstResult,setMaxResults
		query.setFirstResult(0);//从第一个索引开始
		query.setMaxResults(2);//每次查询几个
		
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun6(){//hql查询   绑定参数，占位符
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query query = session.createQuery("from Customer c where c.id=?");//JDBC中使用的方法，Hibernate中也可以使用
//		query.setInteger(0,10);
		Query query = session.createQuery("from Customer c where c.id = :a");
		query.setParameter("a", 10);//填充占位符
		List<Customer> list = query.list();
		System.out.println(list);
		
		
		transaction.commit();
		session.close();
	}
	@Test
	public void fun7(){//hql查询   聚合函数
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
	public void fun8(){//hql查询   分组
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
	public void fun9(){//配置文件中配置好的hql语句
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.getNamedQuery("domain.Student.abc");
		List list = query.list();
		
		System.out.println(list);
		
		transaction.commit();
		session.close();
	}
}

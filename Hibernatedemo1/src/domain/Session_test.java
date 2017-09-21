package domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

public class Session_test {
	@Test
	public void fun1(){//增
		//加载配置文件
		Configuration config = new Configuration().configure();
		//获取session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = new User();
		user.setName("jack");
		user.setPassword("321");
		//开始事务
		Transaction transaction = session.beginTransaction();
		//插入数据
		session.save(user);
		//提交
		transaction.commit();
		//关闭连接
		session.close();
		sessionFactory.close();
	}
	@Test
	public void fun2(){//改
		Configuration config = new Configuration().configure();
		SessionFactory SessionFactory = config.buildSessionFactory();
		Session session = SessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		User user = (User)session.get(User.class, 1);//从数据库中获取对象，第一个参数为对象的类型，第二个为id
		System.out.println(user);
		user.setName("jerry");
		session.update(user);//调用update方法更新数据库
		transaction.commit();
		session.close();
		SessionFactory.close();
	}
	@Test
	public void fun3(){//删
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		//根据id删除相应对象
		User user = new User();
		user.setId(2);//设置ID为2
		Transaction transaction = session.beginTransaction();
		session.delete(user);//删除ID为2 的对象
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void fun4(){//查
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		//该查询方法是原生态的查询方法，其中第一个参数为usql语句，第二个为返回的对象类型
		NativeQuery<User> query = session.createNativeQuery("select * from User1",User.class);
		List<User> list = query.list();
		System.out.println(list);
		//查询的第二种方法，通过传入HQL语句查询
		Query<User> query2 = session.createQuery("from domain.User", User.class);
		List<User> list2 = query2.list();
		System.out.println(list2);
	}
}

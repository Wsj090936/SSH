package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;
/**
 * 对象的三种状态
 * @author wushijia
 *
 */
public class test1 {//瞬时->持久
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();//瞬时态
		user.setName("jack");//瞬时态
		user.setPassword("321");//瞬时态
		
		session.save(user);//持久态，该方法会使用主键生成策略
		
		transaction.commit();//持久态，该方法才会保存数据
		session.close();//游离态
	}
	@Test
	public void fun2(){//持久->瞬时
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//持久态
		user.setId(null);//将id设置为null
		session.evict(user);//瞬时态，取消与session关联
		
		
		transaction.commit();//瞬时态，该方法才会保存数据
		session.close();
	}
	@Test
	public void fun3(){//瞬时->游离  将一个瞬时态的对象，其ID设置为数据库中存在的id
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();//瞬时态
		user.setId(1);//游离态
		
		transaction.commit();//游离态，该方法才会保存数据
		session.close();
	}
	@Test
	public void fun4(){//持久->游离  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//持久态
		session.evict(user);//游离态
		
		transaction.commit();//游离态
		session.close();
	}
	@Test
	public void fun5(){//游离->瞬时  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//持久态
		session.evict(user);//游离态
		user.setId(null);//瞬时态
		
		transaction.commit();//瞬时态
		session.close();
	}
	@Test
	public void fun6(){//游离->持久  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//持久态
		session.evict(user);//游离态
		session.update(user);//持久
		
		transaction.commit();//瞬时态
		session.close();
	}
}

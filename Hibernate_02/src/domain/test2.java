package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

public class test2 {
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//执行这一步时会向数据库中传入sql语句进行查询，将查到的结果进行封装，并存入缓存区
		User user1 = session.get(User.class, 1);//这一条语句会直接从缓存区取出对象
		User user2 = session.get(User.class, 1);//该条语句会直接从缓存区取出对象
		
		
		transaction.commit();
		session.close();
	}
}

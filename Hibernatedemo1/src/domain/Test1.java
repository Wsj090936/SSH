package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Test1 {
	public static void main(String[] args) {
		
		User user = new User();
		user.setName("美女1");
		user.setPassword("1234");
		
		//1加载配置文件并获得核心的配置对象
		Configuration config = new Configuration().configure();
		//2获得session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
/*		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();*/
		Session session = sessionFactory.openSession();
		//3、获取事物
		Transaction transaction = session.beginTransaction();
		//4、执行操作,向表中插入数据
		session.save(user);
		//5、提交事务
		transaction.commit();
		//6、关闭session'
		session.close();
		//7、关闭工厂
		sessionFactory.close();
	}

}

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
		user.setName("��Ů1");
		user.setPassword("1234");
		
		//1���������ļ�����ú��ĵ����ö���
		Configuration config = new Configuration().configure();
		//2���session����
		SessionFactory sessionFactory = config.buildSessionFactory();
/*		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();*/
		Session session = sessionFactory.openSession();
		//3����ȡ����
		Transaction transaction = session.beginTransaction();
		//4��ִ�в���,����в�������
		session.save(user);
		//5���ύ����
		transaction.commit();
		//6���ر�session'
		session.close();
		//7���رչ���
		sessionFactory.close();
	}

}

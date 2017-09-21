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
	public void fun1(){//��
		//���������ļ�
		Configuration config = new Configuration().configure();
		//��ȡsession����
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = new User();
		user.setName("jack");
		user.setPassword("321");
		//��ʼ����
		Transaction transaction = session.beginTransaction();
		//��������
		session.save(user);
		//�ύ
		transaction.commit();
		//�ر�����
		session.close();
		sessionFactory.close();
	}
	@Test
	public void fun2(){//��
		Configuration config = new Configuration().configure();
		SessionFactory SessionFactory = config.buildSessionFactory();
		Session session = SessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		User user = (User)session.get(User.class, 1);//�����ݿ��л�ȡ���󣬵�һ������Ϊ��������ͣ��ڶ���Ϊid
		System.out.println(user);
		user.setName("jerry");
		session.update(user);//����update�����������ݿ�
		transaction.commit();
		session.close();
		SessionFactory.close();
	}
	@Test
	public void fun3(){//ɾ
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		//����idɾ����Ӧ����
		User user = new User();
		user.setId(2);//����IDΪ2
		Transaction transaction = session.beginTransaction();
		session.delete(user);//ɾ��IDΪ2 �Ķ���
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void fun4(){//��
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		//�ò�ѯ������ԭ��̬�Ĳ�ѯ���������е�һ������Ϊusql��䣬�ڶ���Ϊ���صĶ�������
		NativeQuery<User> query = session.createNativeQuery("select * from User1",User.class);
		List<User> list = query.list();
		System.out.println(list);
		//��ѯ�ĵڶ��ַ�����ͨ������HQL����ѯ
		Query<User> query2 = session.createQuery("from domain.User", User.class);
		List<User> list2 = query2.list();
		System.out.println(list2);
	}
}

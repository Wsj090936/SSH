package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Transaction_Test {
	@Test
	public void fun1(){
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();//�õ��뵱ǰ�̰߳󶨵�����
		
		session.beginTransaction().commit();//������֮�������ύ����
		Session session2 = sessionFactory.getCurrentSession();//�ٴεõ��뵱ǰ�̰߳󶨵�����
		System.out.println(session == session2);//false����˿��Եĳ��������ύ֮���뵱ǰ�̰߳󶨵�Session����ᱻɾ����
	}
}

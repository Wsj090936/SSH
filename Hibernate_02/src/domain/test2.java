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
		
		User user = session.get(User.class, 1);//ִ����һ��ʱ�������ݿ��д���sql�����в�ѯ�����鵽�Ľ�����з�װ�������뻺����
		User user1 = session.get(User.class, 1);//��һ������ֱ�Ӵӻ�����ȡ������
		User user2 = session.get(User.class, 1);//��������ֱ�Ӵӻ�����ȡ������
		
		
		transaction.commit();
		session.close();
	}
}

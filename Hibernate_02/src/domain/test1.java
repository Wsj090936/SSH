package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;
/**
 * ���������״̬
 * @author wushijia
 *
 */
public class test1 {//˲ʱ->�־�
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();//˲ʱ̬
		user.setName("jack");//˲ʱ̬
		user.setPassword("321");//˲ʱ̬
		
		session.save(user);//�־�̬���÷�����ʹ���������ɲ���
		
		transaction.commit();//�־�̬���÷����Żᱣ������
		session.close();//����̬
	}
	@Test
	public void fun2(){//�־�->˲ʱ
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//�־�̬
		user.setId(null);//��id����Ϊnull
		session.evict(user);//˲ʱ̬��ȡ����session����
		
		
		transaction.commit();//˲ʱ̬���÷����Żᱣ������
		session.close();
	}
	@Test
	public void fun3(){//˲ʱ->����  ��һ��˲ʱ̬�Ķ�����ID����Ϊ���ݿ��д��ڵ�id
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();//˲ʱ̬
		user.setId(1);//����̬
		
		transaction.commit();//����̬���÷����Żᱣ������
		session.close();
	}
	@Test
	public void fun4(){//�־�->����  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//�־�̬
		session.evict(user);//����̬
		
		transaction.commit();//����̬
		session.close();
	}
	@Test
	public void fun5(){//����->˲ʱ  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//�־�̬
		session.evict(user);//����̬
		user.setId(null);//˲ʱ̬
		
		transaction.commit();//˲ʱ̬
		session.close();
	}
	@Test
	public void fun6(){//����->�־�  
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, 1);//�־�̬
		session.evict(user);//����̬
		session.update(user);//�־�
		
		transaction.commit();//˲ʱ̬
		session.close();
	}
}

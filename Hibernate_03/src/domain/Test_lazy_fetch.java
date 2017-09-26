package domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import Utils.HibernateUtils;

public class Test_lazy_fetch {
	@Test
	/**һ�Զ�
	 * ��Customer.hbm.xml�ļ���
	 * lazy��true
	 * fetch��subselect
	 */
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.list();
		
		for(Customer c : list){
			for(Order o : c.getOrders()){
				System.out.println(c.getName()+"�µ�����:"+o.getName());
			} 
			
		}
		
		transaction.commit();
		session.close();
	}
}

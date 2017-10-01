package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static{
		Configuration config = new Configuration().configure();
		sf = config.buildSessionFactory();
	}
	public static Session openSession(){
		return sf.openSession();
	}
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
	public static void main(String[] args) {
		getCurrentSession();
	}
}

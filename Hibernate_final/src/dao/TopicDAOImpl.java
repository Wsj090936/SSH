package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import domain.Topic;

public class TopicDAOImpl implements TopicDAO{

/**
 * ��������
 */
	@Override
	public void save(Topic t) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(t);
	}

	@Override
	public List<Topic> getList(String key) {
		Session session = HibernateUtils.getCurrentSession();
		Query<Topic> query = session.createQuery("from Topic where title like :key",Topic.class);
		
		if(key != null && !"".equals(key.trim())){//ģ����ѯ
			query.setParameter("key", "%"+key+"%");
		}else{
			query.setParameter("key", "%");
		}
		List<Topic> list = query.list();
		return list;
	}

}

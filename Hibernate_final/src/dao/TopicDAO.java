package dao;

import java.util.List;

import domain.Topic;

public interface TopicDAO {
	public void save(Topic t);
	//���ݹؼ��ֲ�ѯ�����б�
	public List<Topic> getList(String key);
}

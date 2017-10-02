package dao;

import java.util.List;

import domain.Topic;

public interface TopicDAO {
	public void save(Topic t);
	//根据关键字查询帖子列表
	public List<Topic> getList(String key);
}

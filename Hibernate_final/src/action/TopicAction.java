package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.TopicDAO;
import dao.TopicDAOImpl;
import domain.Topic;

public class TopicAction extends ActionSupport implements ModelDriven<Topic>{
	private TopicDAO td = new TopicDAOImpl();
	private Topic topic = new Topic();
	private String key;//查询关键字
	
	public String list(){//帖子列表
		List<Topic> list = td.getList(key);
		//将帖子列表放入ActionContext中
		ActionContext.getContext().put("list", list);
		
		return "list";
	}
	
	public String add(){//添加帖子
		topic.setIpaddr(ServletActionContext.getRequest().getRemoteAddr());//添加ip地址
		topic.setCreateDate(new Date());//创建时间
		topic.setLastReplyDate(topic.getCreateDate());//最后回复时间
		td.save(topic);
		
		return SUCCESS;
	}

	@Override
	public Topic getModel() {
		// TODO Auto-generated method stub
		return topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}

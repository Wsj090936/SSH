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
	private String key;//��ѯ�ؼ���
	
	public String list(){//�����б�
		List<Topic> list = td.getList(key);
		//�������б����ActionContext��
		ActionContext.getContext().put("list", list);
		
		return "list";
	}
	
	public String add(){//�������
		topic.setIpaddr(ServletActionContext.getRequest().getRemoteAddr());//���ip��ַ
		topic.setCreateDate(new Date());//����ʱ��
		topic.setLastReplyDate(topic.getCreateDate());//���ظ�ʱ��
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

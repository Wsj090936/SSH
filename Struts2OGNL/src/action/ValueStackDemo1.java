package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Student;

public class ValueStackDemo1 extends ActionSupport{

	private String username = "����";
	public String execute() {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		vs.push(new Student("tom",23));
		
		vs.setValue("#username", "����");//��  username=����  ����ComtextMap
		vs.setValue("username", "����");//��ValueStack�е�һ������Ϊusernane��ֵ�滻Ϊ���壬���û�ҵ����ͻᱨ��
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

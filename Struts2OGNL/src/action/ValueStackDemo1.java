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
		/**
		 * setValue(String expr��Object Value)����
		 * 	expr:����OGNL���ʽ
		 * 	Value  ����Ҫ����������
		 */
		vs.setValue("#username", "����");//��  username=����  ����ComtextMap
		vs.setValue("username", "����");//��ValueStack�е�һ������Ϊusernane��ֵ�滻Ϊ���壬���û�ҵ����ͻᱨ��
		/**
		 * set(String key,Object o)
		 * 		String  key  ����Map��key
		 * 		Object  o   ����Map��value
		 * 		���ջ��Ԫ����һ��Map���ͽ� key=o �ļ�ֵ�Դ���MapԪ�أ������λ����ջ��
		 * 		���ջ��Ԫ�ز�ΪMap���ʹ���һ��Map��Ȼ��key=o�ļ�ֵ�Դ���MapԪ�أ�ѹ��ջ��
		 */
		vs.set("s", new Student("����",18));
		vs.push(new Student("test",19));
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

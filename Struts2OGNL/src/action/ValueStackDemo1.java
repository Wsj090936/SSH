package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Student;

public class ValueStackDemo1 extends ActionSupport{

	private String username = "张三";
	public String execute() {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		vs.push(new Student("tom",23));
		
		vs.setValue("#username", "李四");//将  username=李四  存入ComtextMap
		vs.setValue("username", "王五");//将ValueStack中第一个名字为usernane的值替换为王五，如果没找到，就会报错
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

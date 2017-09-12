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
		/**
		 * setValue(String expr，Object Value)方法
		 * 	expr:代表OGNL表达式
		 * 	Value  代表要操作的数据
		 */
		vs.setValue("#username", "李四");//将  username=李四  存入ComtextMap
		vs.setValue("username", "王五");//将ValueStack中第一个名字为usernane的值替换为王五，如果没找到，就会报错
		/**
		 * set(String key,Object o)
		 * 		String  key  代表Map的key
		 * 		Object  o   代表Map的value
		 * 		如果栈顶元素是一个Map，就将 key=o 的键值对存入Map元素，存入的位置是栈顶
		 * 		如果栈顶元素不为Map，就创建一个Map，然后将key=o的键值对存入Map元素，压入栈顶
		 */
		vs.set("s", new Student("赵六",18));
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

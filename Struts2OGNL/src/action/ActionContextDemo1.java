package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionContextDemo1 extends ActionSupport {
	public String execute(){
		//1、获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		//2、向其中存储数据
		context.put("ActionContext", "hello");
		//3、向其中5个小Mao中存储数据，先获得一个小Map
		Map<String, Object> session = context.getSession();
		session.put("session", "sessiondemo");
		/**
		 * 或者可以按照如下方式存，二者都能存进去
		 */
		HttpSession session2 = ServletActionContext.getRequest().getSession();
		session2.setAttribute("session2", "sessiondemo2");
		
		return SUCCESS;
	}
}

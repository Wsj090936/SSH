package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionContextDemo1 extends ActionSupport {
	public String execute(){
		//1����ȡActionContext����
		ActionContext context = ActionContext.getContext();
		//2�������д洢����
		context.put("ActionContext", "hello");
		//3��������5��СMao�д洢���ݣ��Ȼ��һ��СMap
		Map<String, Object> session = context.getSession();
		session.put("session", "sessiondemo");
		/**
		 * ���߿��԰������·�ʽ�棬���߶��ܴ��ȥ
		 */
		HttpSession session2 = ServletActionContext.getRequest().getSession();
		session2.setAttribute("session2", "sessiondemo2");
		
		return SUCCESS;
	}
}

package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class pageAction extends ActionSupport {
	/**
	 * �û���½�ķ���
	 * @return
	 */
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "text");
		return SUCCESS;
	}
	/**
	 * ��ʾ��ҳ��������ҳ�棬��ִ�дη���
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}
}

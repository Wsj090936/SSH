package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class pageAction extends ActionSupport {
	/**
	 * 用户登陆的方法
	 * @return
	 */
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "text");
		return SUCCESS;
	}
	/**
	 * 显示主页或者其他页面，都执行次方法
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}
}

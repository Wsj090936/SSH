package action;

import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport{
	private String name;
	public String login(){
		System.out.println(name);
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

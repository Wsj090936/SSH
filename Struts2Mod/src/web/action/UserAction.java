package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	public String addUser(){
		System.out.println("添加成功");
		return SUCCESS;
	}
	public String deleteUser(){
		System.out.println("删除成功");
		return SUCCESS;
	}
	public String findUser(){
		System.out.println("查找成功");
		return SUCCESS;
	}
}

package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	public String addUser(){
		System.out.println("��ӳɹ�");
		return SUCCESS;
	}
	public String deleteUser(){
		System.out.println("ɾ���ɹ�");
		return SUCCESS;
	}
	public String findUser(){
		System.out.println("���ҳɹ�");
		return SUCCESS;
	}
}

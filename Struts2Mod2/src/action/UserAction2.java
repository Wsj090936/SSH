package action;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class UserAction2 extends ActionSupport {
	//javaBean
	private User user;
	public String addUser(){
		System.out.println(user.getUsername()+","+user.getAge());
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

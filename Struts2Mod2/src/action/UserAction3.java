package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;

public class UserAction3 extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
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

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User1;
import service.IUserService;
import service.impl.UserServiceImpl;
/**
 * �û�������ض�����
 * @author wushijia
 *
 */
public class UserAction4 extends ActionSupport implements ModelDriven<User1>{
	private IUserService us = new UserServiceImpl();
	User1 user = new User1();
	public String register(){
		//1�������û�����ѯ���ݿ����Ƿ����һ������������������û����ڣ�����exists
		User1 dbUser = us.findUserByUsername(user.getUsername());
		if(dbUser != null){
			return "exists";
		}
		//2����������ڣ������û���Ϣ�����ִ�н������0������SUCCESS�������ڣ�����null
		int register = us.register(user);
		if(register > 0){
			return SUCCESS;
		}
		return null;
	}

	@Override
	public User1 getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}
	
}

package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User1;
import service.IUserService;
import service.impl.UserServiceImpl;
/**
 * 用户操作相关动作类
 * @author wushijia
 *
 */
public class UserAction4 extends ActionSupport implements ModelDriven<User1>{
	private IUserService us = new UserServiceImpl();
	User1 user = new User1();
	public String register(){
		//1、根据用户名查询数据库中是否存在一个对象，若存在则表明用户存在，返回exists
		User1 dbUser = us.findUserByUsername(user.getUsername());
		if(dbUser != null){
			return "exists";
		}
		//2、如果不存在，保存用户信息，如果执行结果大于0，返回SUCCESS，不大于，返回null
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

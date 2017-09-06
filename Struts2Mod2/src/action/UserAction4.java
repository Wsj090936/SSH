package action;

import org.apache.commons.lang3.StringUtils;

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

//	@Override
//	public void validate() {
//		//�����õ�StringUtils������ǿ�İ�����������˺ܶ��ַ����Ĳ�������
//		if(StringUtils.isEmpty(user.getUsername())){//isEmpty()�ж��ַ����Ƿ�Ϊ���ַ�������Ϊnull
//			addFieldError("username", "�������û���");//�÷�����ActionSupport�£�����ֱ�ӵ��ã��������ô�����Ϣ
//		}
//	}
/*	public void validateRegister(){//ָ����������������֤
		//�����õ�StringUtils������ǿ�İ�����������˺ܶ��ַ����Ĳ�������
		if(StringUtils.isEmpty(user.getUsername())){//isEmpty()�ж��ַ����Ƿ�Ϊ���ַ�������Ϊnull
			addFieldError("username", "�������û���");//�÷�����ActionSupport�£�����ֱ�ӵ��ã��������ô�����Ϣ
		}
	}*/
	@Override
	public User1 getModel() {
		return user;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}
	
}

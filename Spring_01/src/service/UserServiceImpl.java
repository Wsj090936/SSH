package service;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;//��������ע�룬UserServiceImpl������UserDAO
	@Override
	public void addUser() {
		System.out.println("hello Spring");
	}
	
	public void save(){
		this.userDao.save();
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
}
 
package service;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;//利用依赖注入，UserServiceImpl依赖于UserDAO
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
 
package beanFactory;



public class MyFactory {
	public UserService createService(){
		return new UserServiceImpl();
	}
}
 
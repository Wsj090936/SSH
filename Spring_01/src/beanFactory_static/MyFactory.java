package beanFactory_static;



public class MyFactory {
	public static UserService createService(){
		return new UserServiceImpl();
	}
}

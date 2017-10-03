package beanFactory_static;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("static Factory");
	}

}
 
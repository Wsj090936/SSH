package aop_by_FactoryBean;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("deleteUser");
	}

}

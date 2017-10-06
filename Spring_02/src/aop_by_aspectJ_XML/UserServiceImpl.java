package aop_by_aspectJ_XML;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("addUser");
	}

	@Override
	public void deleteUser() {
		int i = 1/0;
		System.out.println("deleteUser");
	}

}

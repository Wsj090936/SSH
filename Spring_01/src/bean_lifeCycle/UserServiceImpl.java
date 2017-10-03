package bean_lifeCycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("addUser");
	}
	public void init(){
		System.out.println("³õÊ¼»¯");
	}
	public void destroy(){
		System.out.println("Ïú»Ù");
	}
}
 
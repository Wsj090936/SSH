package aop_by_jdkProxy;

import org.junit.Test;

public class Test_jdk_proxy {
	@Test
	public void fun1(){
		UserService userService = MyBeanFactory.createUserService();
		userService.addUser();
		userService.deleteUser();
	}
}

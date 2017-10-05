package aop_by_jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createUserService(){
		//目标类 匿名内部类访问时必须为final
		final UserService us = new UserServiceImpl();
		//增强代码，切面类
		final MyAspect ma = new MyAspect();
		/**
		 * 生成代理对象
		 * 利用jdk的动态代理生成，其中newProxyInstance的参数为：
		 * 		参数一：类加载器，通过  当前类.class.getClassLoader()或者目标类.getClass().getClassLoader()获得
		 * 		参数二：目标类中的接口，通过目标类.getClass().getInterfaces()获得
		 */
		UserService proxService = (UserService)Proxy.newProxyInstance(
				us.getClass().getClassLoader(), 
				us.getClass().getInterfaces(),
				new InvocationHandler() {
			/**
			 * 处理类，是一个接口，必须提供其实现代理类的每一个方法执行时，每次都要调用invoke方法(即可以理解为将目标类的方法放入invoke中执行)
			 * 参数一：proxy：代理对象
			 * 参数二：method：代理对象当前执行的方法的描述对象
			 * 			方法名：method.getName()
			 * 			执行方法：method.invoke()
			 * 参数三：args：方法的实际参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//方法执行前
				ma.before();
				//执行方法
				Object object = method.invoke(us, args);
				//方法执行后
				ma.after();
				return object;
			}
		});
		return proxService;
	}
}

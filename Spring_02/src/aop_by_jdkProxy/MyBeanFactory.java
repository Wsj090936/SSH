package aop_by_jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createUserService(){
		//Ŀ���� �����ڲ������ʱ����Ϊfinal
		final UserService us = new UserServiceImpl();
		//��ǿ���룬������
		final MyAspect ma = new MyAspect();
		/**
		 * ���ɴ������
		 * ����jdk�Ķ�̬�������ɣ�����newProxyInstance�Ĳ���Ϊ��
		 * 		����һ�����������ͨ��  ��ǰ��.class.getClassLoader()����Ŀ����.getClass().getClassLoader()���
		 * 		��������Ŀ�����еĽӿڣ�ͨ��Ŀ����.getClass().getInterfaces()���
		 */
		UserService proxService = (UserService)Proxy.newProxyInstance(
				us.getClass().getClassLoader(), 
				us.getClass().getInterfaces(),
				new InvocationHandler() {
			/**
			 * �����࣬��һ���ӿڣ������ṩ��ʵ�ִ������ÿһ������ִ��ʱ��ÿ�ζ�Ҫ����invoke����(���������Ϊ��Ŀ����ķ�������invoke��ִ��)
			 * ����һ��proxy���������
			 * ��������method���������ǰִ�еķ�������������
			 * 			��������method.getName()
			 * 			ִ�з�����method.invoke()
			 * ��������args��������ʵ�ʲ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//����ִ��ǰ
				ma.before();
				//ִ�з���
				Object object = method.invoke(us, args);
				//����ִ�к�
				ma.after();
				return object;
			}
		});
		return proxService;
	}
}

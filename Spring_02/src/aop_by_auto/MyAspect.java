package aop_by_auto;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("ǰ");//��ǿ����
		Object object = mi.proceed();//ִ��Ŀ�귽��
		System.out.println("��");//��ǿ����
		return object;
	}

}

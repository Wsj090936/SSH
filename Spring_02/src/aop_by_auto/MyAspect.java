package aop_by_auto;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("前");//增强代码
		Object object = mi.proceed();//执行目标方法
		System.out.println("后");//增强代码
		return object;
	}

}

package aop_by_aspectJ_XML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类，包括了五种AspectJ通知类型
 * @author wushijia
 *
 */
public class MyAspect{
	//前置类型
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知" + joinPoint.getSignature().getName());
	}
	//后置类型
	public void myAfter(JoinPoint joinPoint,Object ret){
		System.out.println("后置通知" + ret);
	}
	//环绕通知
	public Object myAround(ProceedingJoinPoint point) throws Throwable{
		
		System.out.println("环绕通知前");
		Object object = point.proceed();
		System.out.println("环绕通知后");
		return object;
	}
	//抛出异常  出错才会执行
	public void myThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("异常类型"+e.getMessage());
	}
	//最终通知
	public void after(){
		System.out.println("最终通知");
	}
}

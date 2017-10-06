package aop_by_aspectJ_XML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * �����࣬����������AspectJ֪ͨ����
 * @author wushijia
 *
 */
public class MyAspect{
	//ǰ������
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ" + joinPoint.getSignature().getName());
	}
	//��������
	public void myAfter(JoinPoint joinPoint,Object ret){
		System.out.println("����֪ͨ" + ret);
	}
	//����֪ͨ
	public Object myAround(ProceedingJoinPoint point) throws Throwable{
		
		System.out.println("����֪ͨǰ");
		Object object = point.proceed();
		System.out.println("����֪ͨ��");
		return object;
	}
	//�׳��쳣  ����Ż�ִ��
	public void myThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("�쳣����"+e.getMessage());
	}
	//����֪ͨ
	public void after(){
		System.out.println("����֪ͨ");
	}
}

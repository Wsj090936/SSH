package aop_by_jdkProxy;

public class MyAspect {
	public void before(){
		System.out.println("before");
	}
	public void after(){
		System.out.println("after");
	}
}

package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class demo1Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("demo1������ִ����");
		String rtValue = invocation.invoke();//����  ����success
		System.out.println("��������Ӧִ����");
		return rtValue;
	}

}

package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class demo1Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("demo1拦截器执行了");
		String rtValue = invocation.invoke();//放行  返回success
		System.out.println("拦截器响应执行了");
		return rtValue;
	}

}

package Interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 检查登陆的拦截器
 * @author wushijia
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1、得到session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2、获取session域中的登陆标记
		Object obj = session.getAttribute("user");
		//3、如果为空，就不放行
		if(obj == null){
			return "input";
		}
		//4、如果不为空就放行
		String invoke = invocation.invoke();
		return invoke;
	}

}

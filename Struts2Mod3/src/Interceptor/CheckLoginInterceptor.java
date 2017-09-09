package Interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ����½��������
 * @author wushijia
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1���õ�session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2����ȡsession���еĵ�½���
		Object obj = session.getAttribute("user");
		//3�����Ϊ�գ��Ͳ�����
		if(obj == null){
			return "input";
		}
		//4�������Ϊ�վͷ���
		String invoke = invocation.invoke();
		return invoke;
	}

}

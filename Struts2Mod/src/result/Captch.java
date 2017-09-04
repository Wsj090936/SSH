package result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

public class Captch extends StrutsResultSupport {

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		ValidateCode val = new ValidateCode(110, 20, 4, 6);
		val.write(response.getOutputStream());
	}

}

package action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �����ļ�
 * @author wushijia
 *
 */
public class downloadAction extends ActionSupport {
	private InputStream inputStream;
	public String download() throws Exception{
		//1���Ȼ�ȡ��Ҫ�����ص��ļ�
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/images/cat.png");
		System.out.println(path);
		//2�����ļ�����һ��InputStream����
		inputStream = new FileInputStream(path);
		//3������SUCCESS
		return SUCCESS;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}

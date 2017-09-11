package action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 下载文件
 * @author wushijia
 *
 */
public class downloadAction extends ActionSupport {
	private InputStream inputStream;
	public String download() throws Exception{
		//1、先获取需要被下载的文件
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/images/cat.png");
		System.out.println(path);
		//2、将文件读入一个InputStream流中
		inputStream = new FileInputStream(path);
		//3、返回SUCCESS
		return SUCCESS;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}

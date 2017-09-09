package action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction extends ActionSupport {
	//表单上的字段
	private String username;
	private File tomCat;
	//struts2在文件上传时提供的属性
	private String tomCatFileName;//上传的文件名  命名规则为  上传的文件字段名称+FileName
	private String tomCatContentType;//上传的文件的类型  命名规则为  上传的文件字段名称+ContentType
	public String upload(){
		ServletContext application = ServletActionContext.getServletContext();
		//得到一个存放文件的目录
		String filePath = application.getRealPath("/WEB-INF/images");
		File file = new File(filePath);
		if(!file.exists()){//如果该目录不存在，就创建一个
			file.mkdirs();
		}
		//将文件剪切进去
		tomCat.renameTo(new File(file,tomCatFileName));//第一个为存放的位置，第二个为文件的名字
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getTomCat() {
		return tomCat;
	}
	public void setTomCat(File tomCat) {
		this.tomCat = tomCat;
	}
	public String getTomCatFileName() {
		return tomCatFileName;
	}
	public void setTomCatFileName(String tomCatFileName) {
		this.tomCatFileName = tomCatFileName;
	}
	public String getTomCatContentType() {
		return tomCatContentType;
	}
	public void setTomCatContentType(String tomCatContentType) {
		this.tomCatContentType = tomCatContentType;
	}

}

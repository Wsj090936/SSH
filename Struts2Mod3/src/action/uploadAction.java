package action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction extends ActionSupport {
	//���ϵ��ֶ�
	private String username;
	private File tomCat;
	//struts2���ļ��ϴ�ʱ�ṩ������
	private String tomCatFileName;//�ϴ����ļ���  ��������Ϊ  �ϴ����ļ��ֶ�����+FileName
	private String tomCatContentType;//�ϴ����ļ�������  ��������Ϊ  �ϴ����ļ��ֶ�����+ContentType
	public String upload(){
		ServletContext application = ServletActionContext.getServletContext();
		//�õ�һ������ļ���Ŀ¼
		String filePath = application.getRealPath("/WEB-INF/images");
		File file = new File(filePath);
		if(!file.exists()){//�����Ŀ¼�����ڣ��ʹ���һ��
			file.mkdirs();
		}
		//���ļ����н�ȥ
		tomCat.renameTo(new File(file,tomCatFileName));//��һ��Ϊ��ŵ�λ�ã��ڶ���Ϊ�ļ�������
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

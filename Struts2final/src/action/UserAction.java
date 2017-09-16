package action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ServiceImpl.UserServiceImpl;
import domain.User;
import iService.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService us = new UserServiceImpl();
	private File upload;//保存上传的文件
	private String uploadFileName;
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String login(){
		String loginName = user.getLoginName();
		String loginPwd = user.getLoginPwd();
		User user1 = us.login(loginName, loginPwd);
		if(user1 == null){
			addActionError("用户不存在或用户名与密码不匹配");
			return INPUT;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user1);
		return SUCCESS;
	}
	public String addUser(){
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChilePath(filePath);
		String fileName = TokenHelper.generateGUID();//随机文件名
		fileName = fileName+"_"+uploadFileName;
		
		user.setPath(dir);
		user.setFilename(fileName);
		upload.renameTo(new File(filePath+File.separator+dir,fileName));//上传文件
		int re = us.saveUser(user);
		if(re>0){
			return SUCCESS;			
		}else
			return INPUT;
	}
	
	/**
	 * 以日期为文件夹
	 * @param filePath
	 * @return
	 */
	private String generateChilePath(String filePath) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		File file = new File(filePath,dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}

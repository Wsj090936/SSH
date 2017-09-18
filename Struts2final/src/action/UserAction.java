package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

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
	//-----------------多条件查询------------------
	private String isupload;
	public String findUserByCondition(){
		users = us.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isupload);
		return SUCCESS;
	}
	
	//----------编辑用户-----------
	public String edit(){
		if(upload == null){//如果用户没有重新上传文件，就用原来的
			//先将用户原来的信息查出
			User dbUser = us.findUserByID(user.getUserID());
			//将path、和filename取出，存入
			user.setPath(dbUser.getPath());
			user.setFilename(dbUser.getFilename());
			int res = us.modifyUser(user);
			if(res>0){
				return SUCCESS;
			}
			return null;
		}else{//如果用户重新上传了文件
			String filePath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChilePath(filePath);
			String fileName = TokenHelper.generateGUID();//随机文件名
			fileName = fileName+"_"+uploadFileName;
			
			user.setPath(dir);
			user.setFilename(fileName);
			upload.renameTo(new File(filePath+File.separator+dir,fileName));//上传文件
			int re = us.modifyUser(user);
			if(re>0){
				return SUCCESS;			
			}
		}
			return null;
	}
	public String editUser(){
		//给栈顶的user对象赋值
		user = us.findUserByID(user.getUserID());
		//压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//--------------删除用户------------------
	public String deleteUserById(){
		int res = us.removeUser(user.getUserID());
		if(res>0){
			return SUCCESS;
		}
		return null;
	}
	//-------------下载文件------------
	private String oldFileName;//用户上传的文件名
	private InputStream inputStream;
	public String download() throws Exception{
		Integer id = user.getUserID();
		User user2 = us.findUserByID(id);
		String path = ServletActionContext.getServletContext().getRealPath("/files");
		oldFileName = user2.getFilename().substring(user2.getFilename().indexOf("_")+1);
		inputStream = new FileInputStream(path+File.separator+user2.getPath()+File.separator+user2.getFilename());
		return SUCCESS;
	}
	public String findUserById(){
		//给栈顶的user对象赋值
		User user1 = us.findUserByID(user.getUserID());
		//压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user1);
		return SUCCESS;
	}
	//---------找到所有用户---------
	private List<User> users;//可以在ValueStack中取到
	public String findAllUser(){
		users = us.findAllUser();
		return SUCCESS;
	}
	/**
	 * 登陆
	 * @return
	 */
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
	/**
	 * 添加用户
	 * @return
	 */
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getOldFileName() {
		return oldFileName;
	}
	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

}

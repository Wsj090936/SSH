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
	private File upload;//�����ϴ����ļ�
	private String uploadFileName;
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//-----------------��������ѯ------------------
	private String isupload;
	public String findUserByCondition(){
		users = us.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isupload);
		return SUCCESS;
	}
	
	//----------�༭�û�-----------
	public String edit(){
		if(upload == null){//����û�û�������ϴ��ļ�������ԭ����
			//�Ƚ��û�ԭ������Ϣ���
			User dbUser = us.findUserByID(user.getUserID());
			//��path����filenameȡ��������
			user.setPath(dbUser.getPath());
			user.setFilename(dbUser.getFilename());
			int res = us.modifyUser(user);
			if(res>0){
				return SUCCESS;
			}
			return null;
		}else{//����û������ϴ����ļ�
			String filePath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChilePath(filePath);
			String fileName = TokenHelper.generateGUID();//����ļ���
			fileName = fileName+"_"+uploadFileName;
			
			user.setPath(dir);
			user.setFilename(fileName);
			upload.renameTo(new File(filePath+File.separator+dir,fileName));//�ϴ��ļ�
			int re = us.modifyUser(user);
			if(re>0){
				return SUCCESS;			
			}
		}
			return null;
	}
	public String editUser(){
		//��ջ����user����ֵ
		user = us.findUserByID(user.getUserID());
		//ѹ��ջ��
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//--------------ɾ���û�------------------
	public String deleteUserById(){
		int res = us.removeUser(user.getUserID());
		if(res>0){
			return SUCCESS;
		}
		return null;
	}
	//-------------�����ļ�------------
	private String oldFileName;//�û��ϴ����ļ���
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
		//��ջ����user����ֵ
		User user1 = us.findUserByID(user.getUserID());
		//ѹ��ջ��
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user1);
		return SUCCESS;
	}
	//---------�ҵ������û�---------
	private List<User> users;//������ValueStack��ȡ��
	public String findAllUser(){
		users = us.findAllUser();
		return SUCCESS;
	}
	/**
	 * ��½
	 * @return
	 */
	public String login(){
		String loginName = user.getLoginName();
		String loginPwd = user.getLoginPwd();
		User user1 = us.login(loginName, loginPwd);
		if(user1 == null){
			addActionError("�û������ڻ��û��������벻ƥ��");
			return INPUT;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user1);
		return SUCCESS;
	}
	/**
	 * ����û�
	 * @return
	 */
	public String addUser(){
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChilePath(filePath);
		String fileName = TokenHelper.generateGUID();//����ļ���
		fileName = fileName+"_"+uploadFileName;
		
		user.setPath(dir);
		user.setFilename(fileName);
		upload.renameTo(new File(filePath+File.separator+dir,fileName));//�ϴ��ļ�
		int re = us.saveUser(user);
		if(re>0){
			return SUCCESS;			
		}else
			return INPUT;
	}
	
	/**
	 * ������Ϊ�ļ���
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

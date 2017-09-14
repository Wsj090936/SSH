package action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * checkboxlist标签的使用
 * @author wushijia
 *
 */
public class CheckboxlistAction extends ActionSupport {
	//初始化表单中的爱好选项
	private String[] hobbyarr = new String[]{"吃饭","运动","编程"};
	//用于存储用户选择的爱好
	private String hobby;
	public String save(){
		System.out.println(hobby);
		return null;
	}
	public String[] getHobbyarr() {
		return hobbyarr;
	}
	public void setHobbyarr(String[] hobbyarr) {
		this.hobbyarr = hobbyarr;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}

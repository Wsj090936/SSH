package domain;

import java.io.Serializable;

public class Student implements Serializable {
	private String username;//不能为null和空字符串，要去掉左右的空格
	private int age;//整数，范围为18-100
	private String email;//必须为邮箱的格式
	private String password;//密码，长度为3~8位
	private String repassowrd;//确认密码，必须和密码一致
	private int score;//成绩，必须为自然数
	private String url;//个人主页，必须符合url的格式
	private String gender;//性别
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassowrd() {
		return repassowrd;
	}
	public void setRepassowrd(String repassowrd) {
		this.repassowrd = repassowrd;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

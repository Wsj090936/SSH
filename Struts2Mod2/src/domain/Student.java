package domain;

import java.io.Serializable;

public class Student implements Serializable {
	private String username;//����Ϊnull�Ϳ��ַ�����Ҫȥ�����ҵĿո�
	private int age;//��������ΧΪ18-100
	private String email;//����Ϊ����ĸ�ʽ
	private String password;//���룬����Ϊ3~8λ
	private String repassowrd;//ȷ�����룬���������һ��
	private int score;//�ɼ�������Ϊ��Ȼ��
	private String url;//������ҳ���������url�ĸ�ʽ
	private String gender;//�Ա�
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

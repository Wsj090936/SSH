package action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String name;
	private int age;

	public String addUser(){
		System.out.println(name+","+age);
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

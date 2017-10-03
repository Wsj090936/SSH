package bean_construct;

public class User {
	private Integer uid;
	private String name;
	private Integer age;

	public User(Integer uid, String name) {//构造方法一
		super();
		this.uid = uid;
		this.name = name;
	}
	
	public User(String name, Integer age) {//构造方法二
		super();
		this.name = name;
		this.age = age;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", age=" + age + "]";
	}
	
}

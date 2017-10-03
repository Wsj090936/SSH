package bean_setter;

public class Person {
	private Integer pid;
	private String pname;
	private Integer age;
	
	private Address addr;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", age=" + age + ", addr=" + addr + "]";
	}
	
}

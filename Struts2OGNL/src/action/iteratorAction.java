package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.Student;
/**
 * 测试iterator标签用的动作类
 * @author wushijia
 *
 */
public class iteratorAction extends ActionSupport {
	private List<Student> students;
	public String execute(){
		students = new ArrayList<>();
		students.add(new Student("tom",18));
		students.add(new Student("jerry",20));
		students.add(new Student("Lily",23));
		return SUCCESS;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}

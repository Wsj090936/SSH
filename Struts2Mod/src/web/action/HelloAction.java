package web.action;

public class HelloAction {
	public String sayHello(){
		return "success";//这里的返回值要和struts.xml中的result中的name属性值一样
	}
}

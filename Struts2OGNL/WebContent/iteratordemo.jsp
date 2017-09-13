<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Iterator标签</title>
</head>
<body>
<!-- iterator标签的使用
		属性介绍：begin、end、step和jstl中的forEach的属性一样，分别是开始、结束和步数
					value：其值是一个OGNL表达式
					var：其值是一个字符串
							当var有值时：会将遍历到的内容作为键值对  s=遍历到的内容 存入ActionContext中
							当var没值时：会将遍历的元素压入ValueStack栈顶	
							status：遍历时的一些计数信息
 -->
	<s:iterator value="students" var="s">
		姓名：<s:property value="#s.name"/>年龄：<s:property value="#s.age"/><br/>
	</s:iterator>
	<hr/>
	<s:iterator value="students">
		姓名：<s:property value="name"/>年龄：<s:property value="age"/><br/>
	</s:iterator>
	<s:debug></s:debug>
</body>
</html>
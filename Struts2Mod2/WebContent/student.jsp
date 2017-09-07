<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <s:head/> --%>
</head>
<body>
<%-- Struts2的form标签中的属性和原始的HTML中的form标签中的属性几乎一样 
		action：请求的地址，可以直接写入请求的地址名而不用加上contextPath
		method：请求的方法，这里默认为post方式
		enctype：表单编码的MIME类型
--%>
<s:form action="addstudent.action" method="post">
	<s:textfield name="username" label="用户名"></s:textfield>
	<s:password name="password" label="密码"></s:password>
	<s:password name="repassword" label="确认密码"></s:password>
	<s:textfield name="age" label="年龄"></s:textfield>
	<s:textfield name="email" label="邮箱"></s:textfield>
	<s:textfield name="score" label="成绩"></s:textfield>
	<s:textfield name="url" label="个人主页"></s:textfield>
	<s:radio name="gender" list="{'男','女'}" label="性别"></s:radio>
	<s:submit value="注册"></s:submit>
</s:form>

</body>
</html>
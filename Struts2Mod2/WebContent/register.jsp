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
<s:form action="register.action">
	<s:textfield name="username" label="用户名"></s:textfield>
	<s:password name="password" label="密码"></s:password>
	<s:textfield name="birthday" label="生日"></s:textfield>
	<s:submit value="注册"></s:submit>
</s:form>


<%-- 	<form action="${pageContext.request.contextPath }/register.action">
		用户名:<input type="text" name="username"/><br/>
		密码:<input type="password" name="password"/><br/>
		生日:<input type="text" name="birthday"/><br/>
		爱好:<input type="checkbox" name="hobby" value="睡觉"/>睡觉
			<input type="checkbox" name="hobby" value="运动"/>运动
			<input type="checkbox" name="hobby" value="打代码"/>打代码
			<br/>
		是否已婚:<input type="checkbox" name="married" value="true"/>是
				<input type="checkbox" name="married" value="false"/>否
		<br/>
		<input type="submit" value="注册"/>
	</form> --%>
</body>
</html>
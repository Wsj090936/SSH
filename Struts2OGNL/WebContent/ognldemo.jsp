<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:property value="tom"/>表示OGNL表达式<br/>
	<s:property value="'tom'"/>表示字符串<br/>
	<s:property value="'tom'.length()"/>调用普通方法<br/>
	
	<s:property value="@java.lang.Integer@MAX_VALUE"/>访问静态属性<br/>
	<s:property value="@java.lang.Math@random()"/>访问静态方法<br/>
	
	<s:radio name="sex" list="{'男','女'}"></s:radio>创建List对象<br/>
	<s:radio name="sex1" list="#{'1':'男','0':'女' }"></s:radio>创建Map对象
</body>
</html>
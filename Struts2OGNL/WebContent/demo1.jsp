<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ActionContext</title>
</head>
<body>
	<s:debug></s:debug>
	<!-- 利用property标签从ActionContext中取出数据 -->
	<!-- 从最大的Map中取出数据：将value的值设为#key的值，注意，这里的value的值是OGNL表达式 -->
	<s:property value="#ActionContext"/>
	<!-- 从小Map中取出数据，将value的值设为"#"+大Map的key(即那几个小Map在大Map中对应的key)+"."+想取数据的key -->
	<s:property value="#session.session"/>
</body>
</html>
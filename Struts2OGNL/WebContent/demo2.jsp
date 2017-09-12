<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ValueStack取值</title>
</head>
<body>
	<s:debug></s:debug><br/>
	<!-- 获取ValueStack中的对象属性值 
		value的值是一个OGNL表达式
	-->
	<s:property value="username"/><br/><!-- value的值也可以为[0].username,只写username就从栈顶开始找，找到第一个username就停止，不再继续寻找 -->
	<!-- 指定位置取值 -->
	<s:property value="[1].username"/>
	
</body>
</html>
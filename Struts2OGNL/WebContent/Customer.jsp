<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<s:form action="saveCustomer">
		<s:textfield name="name" label="用户名"/>
		<s:password name="password" label="密码" />
		<s:checkboxlist name="hobby" list="{'摄影','足球','计算机'}" />
		<s:checkbox name="married" label="是否已婚" value="true" />
		<s:select name="city" label="所在地" list="#{'CQ':'重庆','BJ':'北京','SH':'上海' }" headerKey="" headerValue="--请选择--"/>
		<s:textarea name="description" label="个人简介" rows="6" cols="25"/>
		<s:radio name="gender" label="性别" list="#{'male':'男','female':'女' }" value="'male'"/>
		<s:submit value="提交"/><s:reset value="重置"/>
	</s:form>
</body>
</html>
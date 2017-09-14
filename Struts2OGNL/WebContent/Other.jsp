<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其他标签</title>
</head>
<body>
<!-- set标签：
		value属性：是一个OGNL表达式，作为Map中的value
		var属性：作为key
		作用：将var=value的键值对(Map)存入到ContextMap中
 -->
	<s:set var="str1" value="'test'"></s:set><br/>
	<!-- action标签
		name属性：指定一个存在于sturts.xml文件中动作名称
		executeResult：是否执行action，默认为false，如果为true，就将该指定的动作动态包含进来
	 -->
<%-- 	<s:action name="action1" executeResult="true"></s:action> --%>
	<s:url var="url" action="action1"></s:url>
	<s:debug></s:debug>
</body>
</html>
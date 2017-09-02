<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--这里的访问路径要和struts.xml中的action中的name属性值加上.action后缀或直接与name属性值一致，
过滤器会默认拦截action后缀结尾的路径。
或者什么后缀都不写 --%>
	<a href="${pageContext.request.contextPath }/hello.action">有action后缀</a>
	<a href="${pageContext.request.contextPath }/hello">无action后缀</a>
</body>
</html>
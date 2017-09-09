<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<s:form action="upload.action" enctype="multipart/form-data">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:file name="tomCat" label="照片"></s:file>
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>
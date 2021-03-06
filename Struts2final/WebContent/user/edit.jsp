<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<body>
	<s:debug></s:debug>
		<s:form action="edit" name="Form1" namespace="/user" enctype="multipart/form-data">
			&nbsp;
			<input type="hidden" name="userID" value="<s:property value='userID'/>"/>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加用户</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						登录名：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="loginName" cssClass="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:password name="loginPwd" showPassword="true"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						用户姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="userName" cssClass="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:radio name="gender" value="'男'" list="{'男','女' }" />
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						学历：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="education" id="education" list="{'博士','研究生','本科','专科','高中'}" headerKey="" headerValue="--请选择--"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						出生日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="birthday" size="20" readonly="readonly" id="birthday"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="telephone" id="telephone"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						兴趣爱好：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:checkboxlist name="hobby" list="{'吃饭','摄影','旅行','编程','睡觉'}" value="hobby.split(', ')"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						简历资料：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:url value="download" var="url">
							<s:param name="userID" value="userID"></s:param>
						</s:url>
						<a href="#" onclick="openWindow('<s:property value="#url"/>','700','400')" class="cl_01">
						     <s:property value="filename.substring(filename.indexOf('_')+1)"/><!-- 从'_'开始截取文件名 -->
						</a>
						<div id="mydiv" style="display:none">
							<s:file name="upload" size="30"/>
						</div>
						<input type="button" value="重新上传" id="showbtn" onclick="showfile()"/>
						<input type="button" value="取消上传" id="cancelbtn" onclick="cancelfile()" style="display:none"/>
						<script type="text/javascript">
							function showfile(){/* 点击之后让按钮隐藏，让上传文件的窗口出现 */
								var mydiv = document.getElementById("mydiv");
								var showbtn = document.getElementById("showbtn");
								var cancelbtn = document.getElementById("cancelbtn");
								mydiv.style.display = 'inline';
								showbtn.style.display = 'none';
								cancelbtn.style.display = 'inline';
							}
							function cancelfile(){
								var mydiv = document.getElementById("mydiv");
								var showbtn = document.getElementById("showbtn");
								var cancelbtn = document.getElementById("cancelbtn");
								mydiv.style.display = 'none';
								showbtn.style.display = 'inline';
								cancelbtn.style.display = 'none';
							}
						</script>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						备注：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="remark" rows="4" clos="30" cssStyle="WIDTH: 96%"/>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>


				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<s:submit value="提交" name="submit" cssClass="button_ok"/>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<s:reset value="重置" cssClass="button_cancel"/>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</HTML>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>注册</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function fn_verify() {
		var logname = $("#logname").val();
		var name = $("#name").val();
		var psd = $("#psd").val();
		var repsd = $("#repsd").val();

		if (logname == "") {
			alert("用户名不能为空");
			return false;
		}
		if (logname.length<6 || logname.length>20) {
			alert("用户名长度[6-20]");
			return false;
		}

		if (name == "") {
			alert("姓名不能为空");
			return false;
		}
		if (name.length<2 || name.length>10) {
			alert("姓名长度[2-10]");
			return false;
		}

		if (psd == "") {
			alert("密码不能为空");
			return false;
		}
		if (psd != repsd) {
			alert("前后密码不一致");
			return false;
		}

		return true;
	}
</script>
</head>
<body style="text-align: center;">
	<h1><%=basePath%></h1>
	<h1>注册</h1>
	<form action="<%=basePath%>user/register" method="post">
		<div style="text-align: center;">
			<table cellpadding="1" cellspacing="4" border="1" width="400px">
				<tr>
					<th>登录名：</th>
					<td><input id="logname" name="logname" type="text" width="150px" /></td>
				</tr>
				<tr>
					<th>姓名：</th>
					<td><input id="name" name="name" type="text" width="150px" /></td>
				</tr>
				<tr>
					<th>密&nbsp;&nbsp;码：</th>
					<td><input id="psd" name="psd" type="password" width="150px" /></td>
				</tr>
				<tr>
					<th>重复密码：</th>
					<td><input id="repsd" name="repsd" type="password" width="150px" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input id="btnOK" name="btnOK" type="submit" value="注册" onclick="return fn_verify()" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
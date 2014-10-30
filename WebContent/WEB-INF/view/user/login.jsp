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
<title>登录</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function fn_verify() {
		var logname = $("#logname").val();		
		var psd = $("#psd").val();		

		if (logname == "") {
			alert("用户名不能为空");
			return false;
		}		
		if (psd == "") {
			alert("密码不能为空");
			return false;
		}	

		return true;
	}
</script>
</head>
<body style="text-align: center;">
	<h1><%=basePath%></h1>
	<h1>登录</h1>
	<form action="<%=basePath%>user/login" method="post">
		<div style="text-align: center;">
			<table cellpadding="1" cellspacing="4" border="1" width="400px">
				<tr>
					<th>用户名：</th>
					<td><input id="logname" name="logname" type="text" width="150px" /></td>
				</tr>
				<tr>
					<th>密&nbsp;&nbsp;码：</th>
					<td><input id="psd" name="psd" type="password" width="150px" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input id="btnOK" name="btnOK" type="submit" value="登 录"  onclick="return fn_verify()"/></td>
				</tr>
			</table>
		</div>
		<div>
			<img src="<%=basePath%>album/printImage/1" alt="" />
		</div>
	</form>
</body>
</html>
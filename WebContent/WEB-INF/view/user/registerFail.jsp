<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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
<title>注册失败</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<script type="text/javascript">
	function fn_toLogin() {
		window.location.href = "<%=basePath%>/user/toLogin";
	}
	
	function fn_toRegister() {
		window.location.href = "<%=basePath%>/user/toRegister";
	}
</script>
</head>
<body>
	<div style="text-align: center;">
		<h1>注册失败</h1>
		<h2>${errmsg}</h2>
		<a href="javascript:fn_toLogin()">去登陆</a><br /> <a href="javascript:fn_toRegister()">去注册</a>
	</div>
</body>
</html>
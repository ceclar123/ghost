<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>操作失败</title>
<script type="text/javascript">
	function fn_toLoc() {
		window.location.href="<%=basePath%>" + "/album/showAlbum";
	}
</script>
</head>
<body>
	<h1>操作失败</h1>
	<h2>${errmsg }</h2>
	<a href="javascript:fn_toLoc()">返回相册</a>
</body>
</html>
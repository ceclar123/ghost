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
<title>操作成功</title>
<script type="text/javascript">
	function fn_toLoc1() {
		window.location.href="<%=basePath%>" + "album/showAlbum";
	}
	function fn_toLoc2() {
		window.location.href="<%=basePath%>" + "album/showImage/${albumid}";
	}
</script>
</head>
<body>
	<h1>操作成功</h1>
	<h2>${errmsg }</h2>
	<a href="javascript:fn_toLoc1()">返回相册</a>
	<br />
	<a href="javascript:fn_toLoc2()">查看照片</a>
</body>
</html>
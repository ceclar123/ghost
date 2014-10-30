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
<title>上传图片</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="../uploadify/uploadify.css"></link>

<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../uploadify/jquery.uploadify.min.js"></script>

</head>
<body>
	<form>
		<div id="queue"></div>
		<input id="file_upload" name="file_upload" type="file" /> 
		<a href="javascript:$('#file_upload').uploadify('upload')">上传</a>
		<a href="javascript:$('#file_upload').uploadify('cancel')">取消</a> 
	</form>
	<script type="text/javascript">
		$(function() {
			$('#file_upload').uploadify({
				'multi'    : true,//多文件上传
				'auto'     : true,//自动上传
				'buttonText' : '选择图片',//按钮文本
				'swf' : '../uploadify/uploadify.swf',
				'uploader' : '<%=basePath%>album/upload',
				'uploadLimit' : 20
			//文件数量限制
			});
		});
	</script>

</body>
</html>
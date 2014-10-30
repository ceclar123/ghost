<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="../plupload-2.1.2/js/jquery.plupload.queue/css/jquery.plupload.queue.css" type="text/css" media="screen" />

<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>

<!-- production -->
<script type="text/javascript" src="../plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="../plupload-2.1.2/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="../plupload-2.1.2/js/i18n/zh_CN.js"></script>

</head>
<body style="font: 13px Verdana; background: #eee; color: #333">

<form method="post" action="dump.php">
	<h1>Queue widget example</h1>

	<p>Shows the jQuery Plupload Queue widget and under different runtimes.</p>

	<div style="float: left; margin-right: 20px">
		<h3>Flash runtime</h3>
		<div id="flash_uploader" style="width: 500px; height: 330px;">Your browser doesn't have Flash installed.</div>

		<h3>Silverlight runtime</h3>
		<div id="silverlight_uploader" style="width: 500px; height: 330px;">Your browser doesn't have Silverlight installed.</div>
	</div>

	<div style="float: left; margin-right: 20px">
		<h3>HTML 4 runtime</h3>
		<div id="html4_uploader" style="width: 500px; height: 330px;">Your browser doesn't have HTML 4 support.</div>
		
		<h3>HTML 5 runtime</h3>
		<div id="html5_uploader" style="width: 500px; height: 330px;">Your browser doesn't support native upload.</div>
	</div>

	<br style="clear: both" />

	<input type="submit" value="Send" />
</form>

<script type="text/javascript">
$(function() {
	// Setup flash version
	$("#flash_uploader").pluploadQueue({
		// General settings
		runtimes : 'flash',
		url : '../upload.php',
		chunk_size : '1mb',
		unique_names : true,
		
		filters : {
			max_file_size : '10mb',
			mime_types: [
				{title : "Image files", extensions : "jpg,gif,png"},
				{title : "Zip files", extensions : "zip"}
			]
		},

		// Resize images on clientside if we can
		resize : {width : 320, height : 240, quality : 90},

		// Flash settings
		flash_swf_url : '<%=basePath%>plupload-2.1.2/js/Moxie.swf'
	});


	// Setup silverlight version
	$("#silverlight_uploader").pluploadQueue({
		// General settings
		runtimes : 'silverlight',
		url : '../upload.php',
		chunk_size : '1mb',
		unique_names : true,
		
		filters : {
			max_file_size : '10mb',
			mime_types: [
				{title : "Image files", extensions : "jpg,gif,png"},
				{title : "Zip files", extensions : "zip"}
			]
		},

		// Resize images on clientside if we can
		resize : {width : 320, height : 240, quality : 90},

		// Silverlight settings
		silverlight_xap_url : '<%=basePath%>plupload-2.1.2/js/Moxie.xap'
	});

	// Setup html5 version
	$("#html5_uploader").pluploadQueue({
		// General settings
		runtimes : 'html5',
		url : '../upload.php',
		chunk_size : '1mb',
		unique_names : true,
		
		filters : {
			max_file_size : '10mb',
			mime_types: [
				{title : "Image files", extensions : "jpg,gif,png"},
				{title : "Zip files", extensions : "zip"}
			]
		},

		// Resize images on clientside if we can
		resize : {width : 320, height : 240, quality : 90}
	});


	// Setup html4 version
	$("#html4_uploader").pluploadQueue({
		// General settings
		runtimes : 'html4',
		url : '../upload.php',
		unique_names : true,
		
		filters : {
			mime_types: [
				{title : "Image files", extensions : "jpg,gif,png"},
				{title : "Zip files", extensions : "zip"}
			]
		}
	});
});
</script>

</body>
</html>
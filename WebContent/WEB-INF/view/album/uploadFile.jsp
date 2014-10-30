<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>上传</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>plupload-2.1.2/js/jquery.plupload.queue/css/jquery.plupload.queue.css" type="text/css" media="screen" />

<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="<%=basePath%>plupload-2.1.2/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="<%=basePath%>plupload-2.1.2/js/i18n/zh_CN.js"></script>
</head>
<body>
	<form id="form1">    		  
		<div id="uploader" style="height: 600px;">
			You browser doesn't have Flash, Silverlight, Gears, BrowserPlus or HTML5 support.
		</div>		
		<input id="albumid" name="albumid" type="hidden" value="${albumid}"/>		
    </form>
    <script type="text/javascript">
	$(function() {
		$("#uploader").pluploadQueue({
			// General settings
			runtimes : 'flash',
			url : '<%=basePath%>album/upload',
			max_file_size : '20mb', 
			chunk_size : '1mb',
			unique_names : true,			
			filters : {			
				max_file_size : '20mb', 
				mime_types: [
					{title : "Image files", extensions : "jpg,gif,png"}
				]
			},
			multipart_params: {
				albumid: $("#albumid").val(),			 
			},
			// Resize images on clientside if we can
			resize : {width : 1440, height : 900, quality : 90},

			// Flash settings
			flash_swf_url : '<%=basePath%>plupload-2.1.2/js/Moxie.swf',
			silverlight_xap_url : '<%=basePath%>plupload-2.1.2/js/Moxie.xap',
			init:{
				UploadComplete : function(){
					window.location.href = window.location.href;							
				}		
			}
		});		
		

		// Client side form validation
		// 这一块主要是防止在上传未结束前表带提交，具体大家可酌情修改编写 
		$('#form1').submit(function(e) {
	        var uploader = $('#uploader').pluploadQueue();
	 
	        // Files in queue upload them first
	        if (uploader.files.length > 0) {
	            // When all files are uploaded submit form
	            uploader.bind('StateChanged', function() {
	                if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
	                    $('#form1').submit();
	                }
	            });
	                 
	            uploader.start();
	        } else {
	            alert('You must queue at least one file.');
	        }
	 
	        return false;
	    });
	});
</script>
</body>
</html>
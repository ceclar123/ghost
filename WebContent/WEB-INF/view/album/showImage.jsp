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
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>supersized_v3.2.7/css/supersized.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=basePath%>supersized_v3.2.7/theme/supersized.shutter.css" type="text/css" media="screen" />
<style type="text/css">
ul#demo-block {
	margin: 0 15px 15px 15px;
}

ul#demo-block li {
	margin: 0 0 10px 0;
	padding: 10px;
	display: inline;
	float: left;
	clear: both;
	color: #aaa;
	background: url('<%=basePath%>supersized_v3.2.7/img/bg-black.png');
	font: 11px Helvetica, Arial, sans-serif;
}

ul#demo-block li a {
	color: #eee;
	font-weight: bold;
}
</style>

<script type="text/javascript" src="<%=basePath%>supersized_v3.2.7/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>supersized_v3.2.7/js/jquery.easing.min.js"></script>
<script type="text/javascript" src="<%=basePath%>supersized_v3.2.7/js/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="<%=basePath%>supersized_v3.2.7/theme/supersized.shutter.min.js"></script>

<script type="text/javascript">
	jQuery(function($) {
		$.supersized({
					slide_interval : 3000, // Length between transitions
					transition : 3, // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
					transition_speed : 3000, // Speed of transition
					slide_links : 'blank', // Individual links for each slide (Options: false, 'num', 'name', 'blank')
					slides : ${data}
				});
	});
</script>
</head>
<body>
	<!--Thumbnail Navigation-->
	<div id="prevthumb"></div>
	<div id="nextthumb"></div>

	<!--Arrow Navigation-->
	<a id="prevslide" class="load-item"></a>
	<a id="nextslide" class="load-item"></a>

	<div id="thumb-tray" class="load-item">
		<div id="thumb-back"></div>
		<div id="thumb-forward"></div>
	</div>

	<!--Time Bar-->
	<div id="progress-back" class="load-item">
		<div id="progress-bar"></div>
	</div>

	<!--Control Bar-->
	<div id="controls-wrapper" class="load-item">
		<div id="controls">

			<a id="play-button"><img id="pauseplay" src="<%=basePath%>supersized_v3.2.7/img/pause.png" /></a>

			<!--Slide counter-->
			<div id="slidecounter">
				<span class="slidenumber"></span> / <span class="totalslides"></span>
			</div>

			<!--Slide captions displayed here-->
			<div id="slidecaption"></div>

			<!--Thumb Tray button-->
			<a id="tray-button"><img id="tray-arrow" src="<%=basePath%>supersized_v3.2.7/img/button-tray-up.png" /></a>

			<!--Navigation-->
			<ul id="slide-list"></ul>
		</div>
	</div>
</body>
</html>
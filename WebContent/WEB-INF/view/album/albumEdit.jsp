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
<title>相册编辑</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function fn_verify() {
		var name = $("#name").val();
		var desc = $("#desc").val();

		if (name == "") {
			alert("相册名称不能为空");
			return false;
		}
		if (desc == "") {
			alert("相册描述不能为空");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h1>相册编辑</h1>
	<form action="<%=basePath%>album/save" method="post">
		<input id="id" name="id" type="hidden" value="${id}" />
		<div style="text-align: center;">
			<table cellpadding="1" cellspacing="4" border="1" width="400px">
				<tr>
					<th>相册名称：</th>
					<td><input id="name" name="name" type="text" width="150px" /></td>
				</tr>
				<tr>
					<th>相册描述：</th>
					<td><input id="desc" name="desc" type="text" width="150px" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input id="btnOK" name="btnOK" type="submit" value="保存" onclick="return fn_verify()" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
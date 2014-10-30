<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	var fileIndex = 2;
	function fn_addFile() {
		var txt = "<tr id='tr" + fileIndex + "'><td><input type='file' id='file" + fileIndex + "' name='file" + fileIndex + "' style='width: 300px;' /></td>";
		txt = txt + "<td><a href='javascript:fn_delFile(\"" + fileIndex
				+ "\");'>删除附件</a></td</tr>";

		$("#tabFile").append(txt);
		fileIndex++;
	}
	function fn_delFile(id) {
		$("#tr" + id).remove();
	}
</script>
</head>
<body>
	<form id="fileUpload" name="fileUpload" method="post"
		action="fileUpload" enctype="multipart/form-data">
		<table id="tabFile" cellpadding="1" cellspacing="4" border="1"
			width="400px">
			<tr id="tr1">
				<td><input type="file" id="file1" name="file1"
					style="width: 300px;" /></td>
				<td><a href="javascript:fn_addFile();">添加附件</a></td>
			</tr>
		</table>
		<table cellpadding="1" cellspacing="4" border="1" width="400px">
			<tr>
				<td style="text-align: center;"><input type="submit"
					id="fileSubmit" name="fileSubmit" value="上 传" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
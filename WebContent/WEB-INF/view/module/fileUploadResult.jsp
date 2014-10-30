<%@ page language="java" import="org.bond.ghost.entity.UploadFileEntity,java.util.List" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>上传结果</title>
<link href="<%=basePath%>favicon.ico" rel="icon" type="image/x-icon" />
<link href="<%=basePath%>favicon.ico" rel="shortcut icon" type="image/x-icon" />
</head>
<body>
	<table cellpadding="1" cellspacing="4" border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>文件名</th>
				<th>路径</th>
				<th>大小</th>
				<th>结果</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				Object value = request.getAttribute("result");
				if (value != null) {
					List<UploadFileEntity> uploadFile = (List<UploadFileEntity>) value;

					if (uploadFile != null) {
						for (UploadFileEntity item : uploadFile) {
							out.println("<tr>");
							out.print("<td>" + i + "</td>");
							out.print("<td>" + item.getFileName() + "</td>");
							out.print("<td>" + item.getFilePath() + "</td>");
							out.print("<td>" + item.getFileSize() + "</td>");
							out.print("<td>" + item.getMessage() + "</td>");
							out.println("</tr>");

							i++;
						}
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>
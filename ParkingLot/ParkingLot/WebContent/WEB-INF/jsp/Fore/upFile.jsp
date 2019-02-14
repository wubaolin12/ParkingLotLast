<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table align="center" width="50%">
		<tr>
			<td><s:fielderror cssStyle="color:red" /></td>
		</tr>
	</table>
	<form action="<%=path%>demo/upload.action" method="post"
		enctype="multipart/form-data">
		<table align="center" width="50%" border="1">
			<tr>
				<td>file <input type="hidden" value="${u_id}" id="u_id"
					name="u_id"></td>
				<td id="more"><input type="file" name="myfile" /> <%-- 					 <s:file name="myfile"></s:file> --%>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
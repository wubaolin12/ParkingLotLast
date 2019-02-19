<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    


<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>


<html>
<body>
<h2>Hello 魔装少女!</h2>
<form action="<%=path%>testdemo/test1" method="post" id="form1">
    <input type="submit" name="submit" value="button">
</form>
</body>
</html>
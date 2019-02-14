<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />   
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">

function addMore()
{
	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "myfile";
	
	button.type = "button";
	button.value = "Remove";
	
	button.onclick = function()
	{
		td.removeChild(br);
		td.removeChild(input);
		td.removeChild(button);
	}
	
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
	
}

</script>

</head>

<body>

	<table align="center" width="50%">
			<tr>
				<td>

				</td>
			</tr>
		</table>


		<form action="${path}/login/addPicture.action" theme="simple" method="post" enctype="multipart/form-data">

			<table align="center" width="50%" border="1">
				<tr>
					<td>
						username
					</td>
					<td>
						<s:textfield name="username"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						password
					</td>
					<td>
						<s:password name="password"></s:password>
					</td>
				</tr>


				<tr>
					<td>
						file
					</td>

					<td id="more">
					  <input type="file" required="required" name="pic"/>
						
						<input type="button" value="Add More.." onclick="addMore()">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="提交">
					</td>

					<td>
						<input type="reset" value="取消">

					</td>
				</tr>
			</table>

		</form>

</body>

</html>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.great.bean.Sche"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>员工排班</title>

  <link rel='stylesheet' type='text/css' href='${path}/static/css/jquery-ui-1.8.11.custom.css' />
  <link rel='stylesheet' type='text/css' href='${path}/static/css/jquery.weekcalendar.css' />
  <style type='text/css'>
  body {
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    margin: 0;
  }

  h1 {
    margin: 0 0 1em;
    padding: 0.5em;
  }

  p.description {
    font-size: 0.8em;
    padding: 1em;
    position: absolute;
    top: 3.2em;
    margin-right: 400px;
  }

  #message {
    font-size: 0.7em;
    position: absolute;
    top: 1em;
    right: 1em;
    width: 350px;
    display: none;
    padding: 1em;
    background: #ffc;
    border: 1px solid #dda;
  }
  </style>

  <script type='text/javascript' src='${path}/static/css/jquery-1.4.4.min.js'></script>
  <script type='text/javascript' src='${path}/static/css/jquery-ui-1.8.11.custom.min.js'></script>

  <script type="text/javascript" src="${path}/static/css/date.js"></script>
  <script type='text/javascript' src='${path}/static/css/jquery.weekcalendar.js'></script>
  <script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
  <script type="text/javascript" src="${path}/static/lib/laypage/1.2/laypage.js"></script>
  
  <script type="text/javascript">



</script>
  <script type='text/javascript'>
 

</script>

</head>
<body>

	<div>
		<form action="${path}/workPrijectHandler/FindWorkProject.action" method="post"
			onsubmit="return checkForm()">
			<div id="searchdiv" style="margin-bottom: 20px;">
				<input type="hidden" name="getUserID2" id="getUserID2"
					value="${GETUSERID}" size=15 /> <span style="margin-left: 30px">员工：</span><select
					id="getUserID" name="getUserID" style="margin-left: 30px">
					<option value="${GETUSERID}">${GETUSERID}</option>
					<c:forEach items="${UserList}" var="u" varStatus="ee">
						<option value="${u.u_id}">${u.u_id}--${u.u_name}</option>
					</c:forEach>
				</select> <input type="submit" id="action" name="action" value="查询"
					style="margin-left: 80px">
			</div>
		</form>
	</div>
  <div id='calendar'></div>
</body>
</html>
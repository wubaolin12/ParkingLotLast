<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    操作成功，<a href="#" onclick="article_save()">点击此处</a>返回 <br>
    
    
  <!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="${path}/static/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">

function article_save(){
	/* alert("combo-success。") */
	/* parent.replace(location.href); */
		parent.location.reload(); 

 	var index = parent.layer.getFrameIndex(window.name); 
	parent.layer.close(index); 

	
}


</script>

  </body>
</html>

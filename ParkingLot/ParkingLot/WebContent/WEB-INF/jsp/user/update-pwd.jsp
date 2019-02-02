<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码页面</title>
<style>
	.top { color:#333333; text-align:center; width:100%; font:italic bold 30px Georgia, "Times New Roman", Times, serif}
	.main { height:325px; width:45%;  margin:2% auto; padding-top:1% ; border:3px #666666 solid;border-radius:5px }
	.main div { margin:5% 25%; width:100% ; font:18px "黑体"; color:#363636}
	#sub input {  margin-left:4%; width:20%; height:28px; border:1.5px #666666 solid; background-color:#fCfCfC;}
	.inp {  height:25px; width:200px}
	#hint { font:15px "黑体"; color:#363636; color:#FF3366}
</style>
<%-- <script type="text/javascript" src="<%=basePath %>JSP/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>JSP/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>JSP/js/jquery.validate.cn.js"></script> --%>

</head>

<body>
<a href="<%=basePath %>UpdatePWDServlet" ></a>
 <div style="width:100%; height:100%" >

	<div class="main">
	<div class="top" style="font-size: 25px ;margin:0% auto; ">修改密码</div>
		<form action="updateUserPwd.action" onsubmit="return check()" method=post">
			<div id="d_opwd">旧密码：
				<input id="oldpwd" name="oldpwd" class="inp" type="password" style="width: 150px" placeholder="请输入旧密码"/>
				<span id="pwdtip"></span>
			</div>
			<div id="d_npwd">新密码：
				<input id="newpwd" name="newpwd" class="inp" type="password" style="width: 150px" placeholder="请输入新密码"/>				
			</div>
			
			<div id="d_cpwd">确认密码：
				<input id="cpwd" name="cpwd" class="inp" type="password" style="width:150px" placeholder="请确认密码" onblur="checkpwd()"/>							
			</div>
			<div><label id="lbtip" value=""></label></div>
			<table>
				<tr>
					<td><div><span id="pwdtip2" value="1"><input id="pwdtip3" type="hidden" value="0"></div></span></td>
				</tr>
				<tr>
					<div id="sub"><input type="submit" value="修改密码"  name="action" onsubmit="return check()"/></div>
				</tr>
			</table>
<!-- 			<div id="sub"><input type="submit" value="提交"  name="action" onsubmit="return check()"/><input type="reset" value="返回"/></div> -->
			
			
		</form>
		
	
 </div>
 </div>
 
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
 <script type="text/javascript">
	function check(){
		
		var pwd1 = document.getElementById("newpwd").value;
		var pwd2 = document.getElementById("cpwd").value;
		var tip  = document.getElementById("pwdtip3").value
		
		if(pwd1!=""&&pwd1!=null&&pwd2!=""&&pwd2!=null){
			if(pwd1==pwd2&&tip=="旧密码正确"){
				
			return true;
			}else{
				return false;
			}
		}else{
			
			document.getElementById("pwdtip2").innerHTML = "提示：密码为空或者两次密码不一致";
			return false;
		}
	};
	function checkpwd(){
		var pwd1 = document.getElementById("newpwd").value;
		var pwd2 = document.getElementById("cpwd").value;
		if(pwd1!=""&&pwd1!=null&&pwd2!=""&&pwd2!=null){
			if(pwd1==pwd2){
				
				document.getElementById("pwdtip2").innerHTML="输入密码一致,可以修改";
				}else{
				document.getElementById("pwdtip2").innerHTML="输入密码不一致 ";	
				}
		}else{
		
			document.getElementById("pwdtip2").innerHTML = "提示：账户或密码都不能为空！";
			
		}
	};



 
	$(function() {
		$("#oldpwd").on("blur",function(){
		
			alert(11111111);
			var pwd=document.getElementById("oldpwd").value;
			
			$.ajax({
				url :"PWDcheckAjax.action" ,
				type :"post",
				dataType:"text", 
				data :"checkpwd="+pwd,
				success:function(redata){
					
					document.getElementById("pwdtip").innerHTML =redata;
					document.getElementById("pwdtip3").value=redata;
				}
			});
		});		
	});
</script>
</body>
</html>
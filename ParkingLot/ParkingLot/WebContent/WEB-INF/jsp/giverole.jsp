<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>富裕用户角色</title>
<style type="text/css">
	.table{margin:2% auto;}
.top { color:#333333; text-align:center; width:100%; font:italic bold 40px Georgia, "Times New Roman", Times, serif}
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>lib/jquery/1.9.1/jquery.min.js"></script> 
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.validate.cn.js"></script>
<script type="text/javascript">


  $(function(){
	$("#uname").on("blur",function(){
	  alert('ddd');
		var uname= $("#uname").val();
		$.ajax({
			url:"<%=basePath %>RegisterCheckServlet",
			type:"post",
			dataType:"text",
			data:"uname="+ uname ,
			success : function(redata){
				alert(radata);
			}
		});
	});
});  


function checkData()
{
	var name =document.getElementById("checkPwdresult").value;
	var pwd  =document.getElementById("upwd").value;
	var email=document.getElementById("email").value;
	var num=document.getElementById("phnum").value;
	
	apos=email.indexOf("@");
	dotpos=email.lastIndexOf(".");
	
	if(name== "" || pwd =="")
	{
		alert("用户名或密码不能为空")
		return false;
	}else if(apos<1||dotpos-apos<2){
		document.getElementById("checkemail").innerHTML = "邮箱格式不正确";
		return false
	}else if(num.length<11){
		document.getElementById("checknum").innerHTML = "密码不能小于11位";
		return false
	}else{
		return true;
	}
		
	}
	function checkEmail()
	{
	
	var email=document.getElementById("email").value;
	apos=email.indexOf("@")
	dotpos=email.lastIndexOf(".")
	if (apos<1||dotpos-apos<2) 
		{
		document.getElementById("checkemail").innerHTML = "邮箱格式不正确";
		return false
	}
	else 
	{
		document.getElementById("checkemail").innerHTML = "正确邮箱";
		return true
	}

}

function checknum()
{
	var num=document.getElementById("phnum").value;
	if(num.length<11)
	{
		document.getElementById("checknum").innerHTML = "密码不能小于11位";
		return false
	}else
	{
		document.getElementById("checknum").innerHTML = "密码格式正确";
		return true
	}
}
function checkrPwd()
{
	var pwd =document.getElementById("upwd").value;
	var rpwd=document.getElementById("rupwd").value;
	if(pwd!=rpwd)
	{
		document.getElementById("checkrPwdresult").innerHTML = "密码不一致";
		return false
	}else
	{
		document.getElementById("checkrPwdresult").innerHTML = "密码一致";
		return true
	}
}

function check_ename(){
	var ename=$("#phnum").val();
	$.post("demo/checkName.action",{
		"phnum":phnum
	},function(data){
		//回调函数的参数就是返回的Infoh属性
		var info=data;
		if(info.success){
			
		}
	});
}
</script>
</head>
	<body>
<div class="top">赋予用户角色</div>
<form id="register" action="emp/giverole.action" onSubmit="return checkData()">

<!-- 	<tr>
	     <td colspan="2"> 账号</td>
	     <td> <input type="text" name="uid" id="uid"/>
				     </td>
        </tr> -->
     <div>
	     给用户：
	      <input type="text" name="u_id" style="display: none;" value="${newuser.u_id}" />${newuser.u_name}
				     
   </div>   
         

	 <div>
	     赋予
	     <select name="role_id" id="role_id">
	     <c:forEach items="${prlist}" var="rl" varStatus="rr">
		    <option value ="${rl.role_id}">${rl.role_name}</option>	        
	        </c:forEach>
            </select>
          		  角色
	    	
	</div>


	
	<div>
	      <input type="submit" value="增加">
		    <input type="reset" value="取消">		
                                            
      </div>

</form>

</body>

</html>
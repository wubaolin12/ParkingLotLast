<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />


<!DOCTYPE html>
<html lang="en">

<head>
<title>登陆</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="${path}/static/login/bootstrap.min.css" />
<link rel="stylesheet" href="${path}/static/login/css/camera.css" />
<link rel="stylesheet" href="${path}/static/login/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${path}/static/login/matrix-login.css" />
<link rel="stylesheet" href="${path}/static/login/font-awesome.css" />
<script type="text/javascript" src="${path}/static/login/js/jquery-1.5.1.min.js"></script>
<!-- 软键盘控件start -->
<link href="${path}/static/login/form.css" rel="stylesheet" type="text/css" />
<!-- 软键盘控件end -->
<style type="text/css">
/*
   body{
    -webkit-transform: rotate(-3deg);
    -moz-transform: rotate(-3deg);
    -o-transform: rotate(-3deg);
	padding-top:20px;
    }
    */
.cavs {
	z-index: 1;
	position: fixed;
	width: 95%;
	margin-left: 20px;
	margin-right: 20px;
}
</style>
<script>

  		//window.setTimeout(showfh,3000); 
  		var timer;
  		
  		function updatecode(){
  			
  			document.getElementById("code").setAttribute("src", "${path}/login/rand.action?id="+Math.random());
  		};
  		
		function showfh(){
			fhi = 1;
			//关闭提示晃动屏幕，注释掉这句话即可
			timer = setInterval(xzfh2, 10); 
		};
		var current = 0;
		function xzfh(){
			current = (current)%360;
			document.body.style.transform = 'rotate('+current+'deg)';
			current ++;
			if(current>360){current = 0;}
		};
		var fhi = 1;
		var current2 = 1;
		function xzfh2(){
			if(fhi>50){
				document.body.style.transform = 'rotate(0deg)';
				clearInterval(timer);
				return;
			}
			current = (current2)%360;
			document.body.style.transform = 'rotate('+current+'deg)';
			current ++;
			if(current2 == 1){current2 = -1;}else{current2 = 1;}
			fhi++;
		};
	</script>
</head>
<body>

	<!--小键盘承载器-->
	<canvas class="cavs"></canvas>
	<div
		style="width: 100%; text-align: center; margin: 0 auto; position: absolute;">
		<!-- 登录 -->
		<div id="windows1">
			<div id="loginbox">
				<form action="" method="post" name="loginForm" id="loginForm">
					<div class="control-group normal_text">
						<h3>
							<img src="${path}/static/login/logo.png" alt="Logo" />
						</h3>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box">
								<span class="add-on bg_lg"> <i><img height="37"
										src="${path}/static/login/user.png" /></i>
								</span><input type="text" name="user.u_name" id="loginname" value=""
									placeholder="请输入用户名" />
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box">
								<span class="add-on bg_ly"> <i><img height="37"
										src="${path}/static/login/suo.png" /></i>
								</span><input type="password" name="user.u_pwd" id="password"
									placeholder="请输入密码" class="keypad" keypadMode="full"
									allowKeyboard="true" value="" />
							</div>
						</div>
					</div>
					<div style="float: right; padding-right: 10%;">
						<div style="float: left; margin-top: 3px; margin-right: 2px;">
							<font color="white">记住密码</font>
						</div>
						<div style="float: left;">
							<input name="form-field-checkbox" id="saveid" type="checkbox"
								onclick="savePaw();" style="padding-top: 0px;" />
						</div>
					</div>
					<div class="form-actions">
						<div style="width: 86%; padding-left: 8%;">

							<div style="float: left; padding-top: 2px;">
								<i><img src="${path}/static/login/yan.png" /></i>
							</div>
							<div style="float: left;" class="codediv">
								<input type="text" name="code" id="codetext" class="login_code"
									style="height: 16px; padding-top: 4px;" />
							</div>
							<div style="float: left;">
								<i><img style="height: 22px;" id="code" alt="点击更换"
									title="点击更换" src="${path}/login/rand.action"
									; onclick="updatecode();" /></i>
							</div>
						<!--  <c:if test="${pd.isZhuce == 'yes' }">
						<span class="pull-right" style="padding-right:3%;"><a href="javascript:changepage(1);" class="btn btn-success">注册</a></span>
						</c:if>-->
						 <span class="pull-right"><a onclick="severCheck();" class="flip-link btn btn-info" id="to-recover">登录</a></span> 
						<!--<span class="pull-right"><input type="submit"  class="flip-link btn btn-info" id="to-recover" value="登录"></a></span> -->
					</div>
					</div>
				</form>
				<div class="controls">
					<div class="main_input_box">
						<font color="white"><span id="nameerr">Copyright ©
								传一科技 2018</span></font>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<!-- 背景图片 -->
			<div data-src="${path}/static/images/1.jpg"></div>
			<div data-src="${path}/static/images/2.jpg"></div>
			<div data-src="${path}/static/images/3.jpg"></div>
			<div data-src="${path}/static/images/5.jpg"></div>
		</div>
		<!-- #camera_wrap_3 -->
	</div>

	<script type="text/javascript">
		//服务器校验
		function severCheck(){
			if(check()){
				var loginname = $("#loginname").val();
				var password = $("#password").val();
				var code = $("#codetext").val();
				
				$.ajax({
					type: "POST",
					url: '${path}/login/loginAjax.action',
					contentType:"application/json;charset=utf-8",
					data:'{"name":"测试商品","price":99.9}',
			    	
					data:'{"u_name":'+loginname+',"u_pwd":'+password+',"code":'+code+'}',
	  				contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
	  				 dataType:"text",
					cache: false,
					success: function(res){
							switch(res){
							
							case "success":
								
						    alert('验证成功')
							saveCookie();
							window.location.href="${path}/main/main.action";
							
							break;
							
							case "usererror" :
							$("#loginname").tips({
								side : 1,
								msg : "用户名或密码有误",
								bg : '#FF5080',
								time : 15
							});
							showfh();
							alert('账户/密码有误');
							$("#loginname").focus();
							
							break;
							
							case "stateerror":
								
								alert('该用户被禁用');
								break;
							
							case "codeerror" :
							$("#code").tips({
								side : 1,
								msg : "验证码输入有误",
								bg : '#FF5080',
								time : 15
							});
							showfh();
							$("#code").focus();
							alert('验证码有误');
							break;
							
							default:
							$("#loginname").tips({
								side : 1,
								msg : "用户名或密码有误",
								bg : '#FF5080',
								time : 15
							});
							showfh();
							alert('账户/密码有误');
							$("#loginname").focus();
							break;
						}
					}
				});
			}
		}
	
		$(document).ready(function() {
			changeCode1();
			$("#codeImg").bind("click", changeCode1);
			$("#zcodeImg").bind("click", changeCode2);
		});

		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				$("#to-recover").trigger("click");
			}
		});

		function genTimestamp() {
			var time = new Date();
			return time.getTime();
		}

		function changeCode1() {
			$("#codeImg").attr("src", "code.do?t=" + genTimestamp());
		}
		function changeCode2() {
			$("#zcodeImg").attr("src", "code.do?t=" + genTimestamp());
		}

		//客户端校验
		function check() {

			if ($("#loginname").val() == "") {
				$("#loginname").tips({
					side : 2,
					msg : '用户名不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#loginname").focus();
				return false;
			} else {
				$("#loginname").val(jQuery.trim($('#loginname').val()));
			}
			if ($("#password").val() == "") {
				$("#password").tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#password").focus();
				return false;
			}
			if ($("#codetext").val() == "") {
				$("#codetext").tips({
					side : 1,
					msg : '验证码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#code").focus();
				return false;
			}
			$("#loginbox").tips({
				side : 1,
				msg : '正在登录 , 请稍后 ...',
				bg : '#68B500',
				time : 10
			});

			return true;
		}

		function savePaw() {
			if (!$("#saveid").attr("checked")) {
				$.cookie('loginname', '', {
					expires : -1
				});
				$.cookie('password', '', {
					expires : -1
				});
				$("#loginname").val('');
				$("#password").val('');
			}
		}

		function saveCookie() {
			if ($("#saveid").attr("checked")) {
				$.cookie('loginname', $("#loginname").val(), {
					expires : 7
				});
				$.cookie('password', $("#password").val(), {
					expires : 7
				});
			}
		}
		
		jQuery(function() {
			var loginname = $.cookie('loginname');
			var password = $.cookie('password');
			if (typeof(loginname) != "undefined"
					&& typeof(password) != "undefined") {
				$("#loginname").val(loginname);
				$("#password").val(password);
				$("#saveid").attr("checked", true);
				$("#code").focus();
			}
		});

	</script>
	<script src="${path}/static/login/js/bootstrap.min.js"></script>
	<script src="${path}/static/js/jquery-1.7.2.js"></script>
	<script src="${path}/static/login/js/jquery.easing.1.3.js"></script>
	<script src="${path}/static/login/js/jquery.mobile.customized.min.js"></script>
	<script src="${path}/static/login/js/camera.min.js"></script>
	<script src="${path}/static/login/js/templatemo_script.js"></script>
	<script src="${path}/static/login/js/ban.js"></script>
	<script type="text/javascript" src="${path}/static/js/jQuery.md5.js"></script>
	<script type="text/javascript" src="${path}/static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="${path}/static/js/jquery.cookie.js"></script>

	<!-- 软键盘控件start -->
	<script type="text/javascript" src="${path}/static/login/keypad/js/keypad.js"></script>
	<script type="text/javascript" src="${path}/static/login/keypad/js/framework.js"></script>
	<!-- 软键盘控件end -->
	
	<!-- 登录拦截返回登录页面时全屏 -->
	<script type="text/javascript">
    if (window != top)
    {
        top.location.href = location.href;
    }
</script>
</body>

</html>
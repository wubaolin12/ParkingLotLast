<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加管理员 - 管理员管理 - H-ui.admin v3.1</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*用户名:</span></label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="cust_acc" name="cust_acc">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>初始密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						value="" placeholder="密码" id="cust_pwd" name="cust_pwd">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off"
						placeholder="确认新密码" id="password2" name="password2">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>性别：</label>
				<div class="formControls col-xs-8 col-sm-9 skin-minimal">
					<div class="radio-box">
						<input name="cust_sex" type="radio" value="男" id="sex-1" checked> <label
							for="sex-1">男</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex-2" name="cust_sex" value="女"> <label
							for="sex-2">女</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex-3" name="cust_sex" value="保密"> <label
							for="sex-2">保密</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>手机：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="cust_phone" name="cust_phone">
						<label id="phoneFlag" style="color: red"></label>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>年龄：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="cust_age" name="cust_age">
				</div>
			</div>
	
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${path}/static/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${path}/static/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-admin-add").validate({
						rules : {
							cust_acc : {
								required : true,
								minlength : 4,
								maxlength : 16
							},
							cust_pwd : {
								required : true,
							},
							password2 : {
								required : true,
								equalTo : "#cust_pwd"
							},
							cust_sex : {
								required : true,
							},
							cust_phone : {
								required : true,
								minlength : 11,
								maxlength : 11,
								remote:{
									url:"${path}/custManageHandler/CustPhoneValidate.action",
									type : "post",
									dataType : "text",
									data:{cust_phone:function(){
											var p = $("#cust_phone").val();
											return p;
										}
									},
									dataFilter : function(data) {
										 if (data == "true") {
											 document.getElementById("phoneFlag").innerHTML="";
											 return true;
										 } else {
											document.getElementById("phoneFlag").innerHTML="*该手机号已被注册！";
												return false;
										 }
									}
									
								}
							},
							email : {
								required : true,
								email : true,
							},
								adminRole : {
								required : true,
							},
						},
						onkeyup : false,
						focusCleanup : true,
						success : "valid",
						submitHandler : function(form) {
							var cust_acc = $("#cust_acc").val();
							var cust_pwd = $("#cust_pwd").val();
							var cust_sex = $("#cust_sex").val();
							var cust_age = $("#cust_age").val();
							var cust_phone = $("#cust_phone").val();
								$(form).ajaxSubmit({
													type : 'post',
													url : "${path}/custManageHandler/CustAdd.action",
													data:'{"cust_acc":'+cust_acc+',"cust_pwd":'+cust_pwd+',"cust_sex":'+cust_sex+
													',"cust_age":'+cust_age+',"cust_phone":'+cust_phone+'}',
													success : function(data) {
													layer.msg('添加成功!',{icon : 1,time : 1000});
														},
														error : function(
																XmlHttpRequest,
																textStatus,
																errorThrown
																) {
															layer.msg('添加失败!',{icon : 1,time : 1000});
														    }
													   });
									var index = parent.layer
											.getFrameIndex(window.name);
									parent.$('.btn-refresh').click();
									parent.layer.close(index);
								}
							});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
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
					class="c-red">*</span>手机：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="cust_phone" name="cust_phone">
						<label id="phoneFlag" style="color: red"></label>
				</div>
			</div>
		<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*车牌号:</span></label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="carnum" name="carnum">
						<label id="carNumFlag" style="color: red"></label>
				</div>
			</div>
		<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*选择套餐:</span></label>
				<div class="formControls col-xs-8 col-sm-9">
					<div class="radio-box">
						<input name="pm_id" type="radio" value="注册会员" id="pm_id" onclick="chose()" checked > <label
							for="sex-1">注册会员</label>
					</div>
						<input type="radio" id="pm_id" name="pm_id" value="包月会员"  onclick="chose()"> <label
							for="sex-2">包月套餐</label>
				</div>
				<div class="radio-box">
				<span class="select-box" id="vipchose" style="width:150px;visibility: hidden;">
					<select class="select" name="adminRole" id="adminRole" >
						<option value="0"></option>
					<c:forEach items="${comList}" var="c" varStatus="cc">
						<option value="${c.co_id}">${c.co_standard}天-${c.co_price}</option>
					</c:forEach>
					</select>
				</span> 
					</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
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
	function chose(){
		var radios = document.getElementById("form-admin-add").pm_id;//获取id为list下的所有name为user的值的集合
		for(var i=0;i<radios.length;i++){//循环值得集合
				if(radios[i].checked){//通过checked属性判断是否被选中
				var radid = radios[i].value//将被选择的radio的值赋给变量userid
				}
		}
		if(radid=="包月会员"){
			document.getElementById("vipchose").style.visibility = "visible";
		}else{
			document.getElementById("vipchose").style.visibility = "hidden"; 
		}
	}
	</script>
	<script type="text/javascript">
		$(function() {
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-admin-add").validate({
						rules : {
							carnum : {
								required : true,
								remote:{
									url:"${path}/custManageHandler/CarAddNumV.action",
									type : "post",
									dataType : "text",
									data:{
										carnum:function(){
										var p = $("#carnum").val();
										return p;
									},
									cust_phone:function(){
									var p1 = $("#cust_phone").val();
									return p1;
								}
							},
							dataFilter : function(data) {
								if (data == "true") {
									document.getElementById("carNumFlag").innerHTML="";
									return true;
								} else {
									document.getElementById("carNumFlag").innerHTML="*该车牌已被注册！";
									return false;
								}
							}
						}
					},
							cust_phone : {
								required : true,
								minlength : 11,
								maxlength : 11,
								remote:{
									url:"${path}/custManageHandler/CustPhoneValidate.action",
									type : "post",
									dataType : "text",
									data:{
										cust_phone:function(){
											var p = $("#cust_phone").val();
											return p;
										}
									},
									dataFilter : function(data) {
										// 									 和之前的一个电话号码验证用同一个action方法
//										只不过之前的结果需求刚好相反，之前的是查询有结果时data是false，
//                      				         但要空的时候添加注册客户CUST，需要data是true是通过，
//										现在是需要查询的到才能为其添加车联所以返回data是false是通过
										 if (data == "false") {
											 document.getElementById("phoneFlag").innerHTML="";
											 return true;
										 } else {
											document.getElementById("phoneFlag").innerHTML="*该手机号不存在！";
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
							var cust_phone = $("#cust_phone").val();
							var carnum = $("#carnum").val();
							var adminRole = $("#adminRole").val();
							var pm_id = $("#pm_id").val();
								$(form).ajaxSubmit({
													type : 'post',
													url : "${path}/custManageHandler/CarAddH.action",
													data:'{"cust_phone":'+cust_phone+',"carnum":'+carnum+',"adminRole":'+adminRole+',"pm_id":'+pm_id+'}',
													success : function(data) {
													layer.msg(
															'添加成功!',{icon : 1,time : 1000});
														},
														error : function(
																XmlHttpRequest,
																textStatus,
																errorThrown
																) {
															layer.msg({icon : 1,time : 1000});
														    }
													   });
									var index = parent.layer.getFrameIndex(window.name);
									parent.$('.btn-refresh').click();
									parent.layer.close(index);
								}
							});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
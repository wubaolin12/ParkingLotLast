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
					class="c-red">*车牌号：${Carkxj.c_num}</span></label>
				<div class="formControls col-xs-8 col-sm-9">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*金额：${Stopkxj.sct_money}元 </span> </label>
				</div>
				<div class="formControls col-xs-8 col-sm-9">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*进场时间：${Stopkxj.sct_starttime}</span> </label>
				</div>
				<div class="formControls col-xs-8 col-sm-9">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*出场时间：${Stopkxj.sct_overtime}</span> </label>
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
	<script type="text/javascript
	
	"
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

			$("#form-admin-add")
					.validate(
							{
								rules : {
									carnum : {
										required : true,
										remote : {
											url : "${path}/custManageHandler/CarAddNumV.action",
											type : "post",
											dataType : "text",
											data : {
												carnum : function() {
													var p = $("#carnum").val();
													alert(p);
													return p;
												},
												cust_phone : function() {
													var p1 = $("#cust_phone")
															.val();
													alert(p1);
													return p1;
												}
											},
											dataFilter : function(data) {
												alert(data);
												if (data == "true") {
													document
															.getElementById("carNumFlag").innerHTML = "";
													return true;
												} else {
													document
															.getElementById("carNumFlag").innerHTML = "*该车牌已被注册！";
													return false;
												}
											}
										}
									},
									cust_phone : {
										required : true,
										minlength : 11,
										maxlength : 11,
										remote : {
											url : "${path}/custManageHandler/CustPhoneValidate.action",
											type : "post",
											dataType : "text",
											data : {
												cust_phone : function() {
													var p = $("#cust_phone")
															.val();
													alert(p);
													return p;
												}
											},
											dataFilter : function(data) {
												alert(data);
												// 									 和之前的一个电话号码验证用同一个action方法
												//										只不过之前的结果需求刚好相反，之前的是查询有结果时data是false，
												//                      				         但要空的时候添加注册客户CUST，需要data是true是通过，
												//										现在是需要查询的到才能为其添加车联所以返回data是false是通过
												if (data == "false") {
													document
															.getElementById("phoneFlag").innerHTML = "";
													return true;
												} else {
													document
															.getElementById("phoneFlag").innerHTML = "*该手机号不存在！";
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
									alert(carnum);
									var adminRole = $("#adminRole").val();
									var pm_id = $("#pm_id").val();
									$(form)
											.ajaxSubmit(
													{
														type : 'post',
														url : "${path}/custManageHandler/CarAddH.action",
														data : '{"cust_phone":'
																+ cust_phone
																+ ',"carnum":'
																+ carnum
																+ ',"adminRole":'
																+ adminRole
																+ ',"pm_id":'
																+ pm_id + '}',
														success : function(data) {
															alert(data);
															alert(data);
															layer
																	.msg(
																			'添加成功!',
																			{
																				icon : 1,
																				time : 1000
																			});
														},
														error : function(
																XmlHttpRequest,
																textStatus,
																errorThrown) {
															layer
																	.msg(
																			'添加失败!',
																			{
																				icon : 1,
																				time : 1000
																			});
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
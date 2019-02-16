<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<%
String path=request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<title>传一智能停车场登录</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhaijaan" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet">
<!-- CSS -->
<link rel="stylesheet" href="${path}/static/fore-static/css/bootstrap.css" type="text/css" media="screen">
<link rel="stylesheet" href="${path}/static/fore-static/css/bootstrap-responsive.css" type="text/css" media="screen">
<link rel="stylesheet" href="${path}/static/fore-static/css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="${path}/static/fore-static/css/font-awesome.css" type="text/css" media="screen">
<!--[if lt IE 8]>
	<div><a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/images/upgrade.jpg"border="0"></a></div>  
<![endif]-->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>      
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
<![endif]-->
</head>

<body class="main">
	<!-- START MOUNTAIN EFFECT -->
<div class="mountainbg">
		<div class="mountaincover">
			<div class="mountain">
				<div class="mountain-top">
					<div class="mountain-cap-1"></div>
					<div class="mountain-cap-2"></div>
					<div class="mountain-cap-3"></div>
				</div>
			</div>
			<div class="mountain-two">
				<div class="mountain-top">
					<div class="mountain-cap-1"></div>
					<div class="mountain-cap-2"></div>
					<div class="mountain-cap-3"></div>
				</div>
			</div>
			<div class="mountain-three">
				<div class="mountain-top">
					<div class="mountain-cap-1"></div>
					<div class="mountain-cap-2"></div>
					<div class="mountain-cap-3"></div>
				</div>
			</div>
			<div class="cloud"></div>
			<div class="hot-air-balloon"><img src="${path}/static/fore-static/images/bicycle.png" alt=""></div>
		</div>
	</div>
	<!-- END MOUNTAIN EFFECT -->
	<div id="inner">
		<div id="content">
			<div class="container">
				<div class="row">
					
					<div class="span8 offset1" >
						<!-- START CAROUFREDSEL SLIDER -->
						 <!-- START CONTACT US -->
						<div class="pages">
								<div class="pages_title">传一智能停车场APP</div>
								<h5>欢迎登录</h5>
							
							<!-- START COMMENT -->
							
							<div id="note"></div>
							<div id="fields">
								<form id="ajax-contact-form" class="form-horizontal" action="<%=path%>fore/foreLoginSubmit.do" onSubmit="return nonull()" method="post">
									<div class="block1 clearfix">
										<div class="block3">
											<div class="control-group">
												<label class="control-label" for="cust_acc">用户名</label>
												<div class="controls">
													手机号：<input type="text" id="cust_phone" name="cust_phone"  onkeyup="this.value=this.value.replace(/\D/g,'')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11"   >		
														 </div>
											
											</div>
											<div class="control-group">
												<label class="control-label" for="cust_pwd"></label>
												<div class="controls">
													密 &nbsp; &nbsp;码：<input type="password" id="cust_pwd" name="cust_pwd" >
												 </div>
											</div>
											
										</div>
									</div>
                                    
									<button type="submit" class="submit">登录</button>
                                    <button type="button" class="submit" onclick="toReg()" style="margin-left:7%">注册</button>
                                     <button type="button" class="submit" onclick="javascript:location.href='${path}/Face/forefacelogin.do'" style="margin-left:7%">人脸识别登录</button>
								</form>
							</div>
							<!-- END COMMENT -->
						</div>
						<!-- END CONTACT US -->
						<!-- END CAROUFREDSEL SLIDER -->
					</div>
				</div>
			</div>
		</div>
	
		
		
	</div>

<!-- JS -->
<script type="text/javascript" src="${path}/static/fore-static/js/jquery.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/superfish.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/jquery.ui.totop.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/jquery.caroufredsel.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/jquery.touchSwipe.min.js"></script>
<script type="text/javascript" src="${path}/static/fore-static/js/bootstrap.js"></script>
<script>
	// CAROUFSEDSEL SLIDER 
	$(document).ready(function () {
		$('#caroufredsel_slider1').carouFredSel({
			auto: {
				timeoutDuration: 9000
			}
			, responsive: true
			, direction: "left"
			, width: '100%'
			, scroll: {
				items: 1
				, duration: 1000
				, easing: "easeOutExpo"
				, fx: "fade"
			}
			, items: {
				width: '1000'
				, height: 'variable'
				, visible: {
					min: 1
					, max: 1
				}
			}
			, mousewheel: false
			, swipe: {
				onMouse: true
				, onTouch: true
			}
			, pagination: ".pagination1"
		});
		$(window).bind("resize", updateSizes_vat).bind("load", updateSizes_vat);

		function updateSizes_vat() {
			$('#caroufredsel_slider1').trigger("updateSizes");
		}
		updateSizes_vat();
	});
	$(window).load(function () {});

	
	function nonull(){
		var flag=true;
		var telV=document.getElementById("cust_phone").value;
		var emaV=document.getElementById("cust_pwd").value;
		if(telV==""||telV.length!=11){
		 alert("请输入11位手机号");
		 flag=false;
		}
		if(emaV==""){
			 alert("请填写密码");
			flag=false;
		}
		return flag;
	}
	
	function toReg(){
		location.href='<%=path%>fore/foreReg.do';
	}
</script>
</body>

</html>

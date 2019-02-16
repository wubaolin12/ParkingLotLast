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
<title>余额充值</title>
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
					<div class="span3">
						<div class="box1">
							<header>
								<!-- START LOGO -->
								<div class="logo_wrapper">
									<a href="index.html" class="logo"><img src="${path}/static/fore-static/images/logo.png" alt="Kinder Garten Logo"></a>
								</div>
								<!-- END LOGO -->
							</header>
							<!-- START NAVIGATION MENU -->
							<nav>
								<div class="menu_wrapper">
									<div class="navbar navbar_">
										<div class="navbar-inner navbar-inner_">
											<a class="btn btn-navbar btn-navbar_" data-toggle="collapse" data-target=".nav-collapse_"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
											<div class="nav-collapse nav-collapse_ collapse">
												<ul class="nav sf-menu clearfix">
													<li ><a href="${path}/appointmentParkLotHandler/appointmentParkLotJsp.do">预约停车<span class="over1"></span></a></li>
													<li  ><a href="${path}/carManagHandler/jumpCarMangerJSP.do">车辆管理<span class="over1"></span></a></li>													
													<li><a href="${path}/userinformation/toUserInformation.do">个人资料<span class="over1"></span></a></li>
                                                    <li><a href="${path}/userinformation/toUserSetting.do">个人设置<span class="over1"></span></a></li>
													<li><a href="${path}/findcar/findcar.do">反向寻车<span class="over1"></span></a></li>
													<li><a href="${path}/Face/face.do">注册人脸识别<span class="over1"></span></a></li>
													<li class="active"><a href="${path}/pay/toRecharge.do">余额充值<span class="over1"></span></a></li>
                                                    <li><a href="javascript:exitUser()">退出<span class="over1"></span></a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</nav>
							<!-- END NAVIGATION MENU -->
						</div>
					</div>
					<div class="span8 offset1" >
						<!-- START CAROUFREDSEL SLIDER -->
						<div class="box2 "  >
							<div class="caroufredsel_slider1_wrapper">
								<a class="prev1" href="index.html#"></a>
								<a class="next1" href="index.html#"></a>
								<ul id="caroufredsel_slider1" class="clearfix">
									<li>
										<div class="caroufredsel_slide1"> <img src="${path}/static/fore-static/images/slider/遮车布.PNG" alt="Slider2" class="img"  >
											<div class="txt1">办理三个月以上套餐送遮车布</div>
										</div>
									</li>
									<li>
										<div class="caroufredsel_slide1"> <img src="${path}/static/fore-static/images/slider/摇头狗.PNG" alt="Slider2" class="img"  onclick="window.open('https://detail.tmall.com/item.htm?spm=a230r.1.14.22.69ae651e0tKjc1&id=584172873947&ns=1&abbucket=15')"

>
											<div class="txt1"  onclick="window.open('https://detail.tmall.com/item.htm?spm=a230r.1.14.22.69ae651e0tKjc1&id=584172873947&ns=1&abbucket=15')">淘宝广告：卖萌摇头狗</div>
										</div>
									</li>
									
								</ul>
								<div class="pagination1" id="caroufredsel_pag1"></div>
							</div>
						</div>
						<!-- END CAROUFREDSEL SLIDER -->
					</div>
				</div>
			</div>
		</div>
	<div class="pages_wrapper" >
			<div class="container">
				<div class="row">
					<div class="span8">
					   <!-- START CONTACT US -->
						<div class="pages">
							<!-- START COMMENT -->
							<h3>余额充值</h3>
                            <h5>您的当前余额：${ForeUser.cust_money}元</h5>
							<div id="note"></div>
							<div id="fields">
							<form name="ajax-contact-form" action="${path}/pay/moneyTo_recharge.do" method=post
			 id="ajax-contact-form" class="form-horizontal" onSubmit="return Recharge()">
										<div class="block3">
											<div class="control-group">
												<div class="controls">
													<input type="text" id="WIDtotal_amount" name="WIDtotal_amount" value="充值数量" onBlur="if(this.value=='') this.value='充值数量'" onFocus="if(this.value =='充值数量' ) this.value=''"
													 onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">元</div>
											</div>
										<button type="submit" class="submit">充值</button>	
											<!-- 下面的input为隐藏区域 -->
											<div style="display:none">
											订单名称:<input id="WIDsubject" name="WIDsubject" />
											商户订单号:<input id="WIDout_trade_no" name="WIDout_trade_no" />
											商品描述:<input id="WIDbody" name="WIDbody" />
											</div>
										
									</div>
						    </form>
						    
							</div>
							<!-- END COMMENT -->
						</div>
						<!-- END CONTACT US -->
					</div>
				
				 </div>
			</div>
		</div>
		
		<!-- START FOOTER -->
		<footer>
			<div class="social_wrapper">
				<ul class="social clearfix">
					<li><a href="${path}/fore/success1.do"><i class="fa fa-facebook"></i></a></li>
					<li><a href="${path}/fore/success1.do"><i class="fa fa-twitter"></i></a></li>
					<li><a href="${path}/fore/success1.do"><i class="fa fa-instagram"></i></a></li>
					<li><a href="${path}/fore/success1.do"><i class="fa fa-youtube"></i></a></li>
					<li><a href="${path}/fore/success1.do"><i class="fa fa-pinterest"></i></a></li>
				</ul>
			</div>
			<div class="copyright">Copyright &copy;传一智能停车场</div>
		</footer>
		<!-- END FOOTER -->
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
	
	function exitUser(){
		 if(confirm("你确定要退出吗？")==true){
				location.href='<%=path%>fore/foreExit.do';
		}
	}
	
	function GetDateNow() {
		var vNow = new Date();
		var sNow = "";
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
		document.getElementById("WIDout_trade_no").value =  sNow;
		document.getElementById("WIDsubject").value = "传一智能停车场系统个人充值";
	}
	GetDateNow();
	//充值提交
	function Recharge(){
		var flag=false;
		var number= document.getElementById('WIDtotal_amount').value;
		var str="你确定要充值"+number+"元吗？";
		if(number>0){
			 if(confirm(str)==true){
				 flag=true;
				 //var form = document.getElementById('alipayment');
					//form.submit();
			}
		}else{
			alert("请输入大于0的数字");
		}
		return flag;
	}
	
	
</script>
</body>

</html>

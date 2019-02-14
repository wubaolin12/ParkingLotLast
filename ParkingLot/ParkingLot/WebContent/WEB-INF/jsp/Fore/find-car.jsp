<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

    
<!DOCTYPE html>
<html lang="zxx" style="">

<head>
<title>反向寻车</title>
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
	<link rel="stylesheet" href="${path}/static/fore-static/css/ie.css" type="text/css" media="screen">
<![endif]-->
<link href="${path}/static/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
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
													<li><a href="index.html">预约停车<span class="over1"></span></a></li>
													<li class="active"><a href="about.html">反向寻车<span class="over1"></span></a></li>
													<li><a href="services.html">个人资料<span class="over1"></span></a></li>
                                                    <li><a href="contact.html">个人设置<span class="over1"></span></a></li>
													<li><a href="contact.html">余额充值<span class="over1"></span></a></li>
                                                    <li><a href="contact.html">退出<span class="over1"></span></a></li>
												</ul>
										</div>
									</div>
								</div>
							</div>
						</nav>
						<!-- END NAVIGATION MENU -->
					</div>
				</div>
				<div class="span8 offset1">
					<!-- START CAROUFREDSEL SLIDER -->
					<div class="box2 "  >
							<div class="caroufredsel_slider1_wrapper">
								<a class="prev1" href="index.html#"></a>
								<a class="next1" href="index.html#"></a>
								<ul id="caroufredsel_slider1" class="clearfix">
									<li>
										<div class="caroufredsel_slide1"> <img src="${path}/static/fore-static/images/slider/遮车布.png" alt="Slider2" class="img"  >
											<div class="txt1">办理三个月以上套餐送遮车布</div>
										</div>
									</li>
									<li>
										<div class="caroufredsel_slide1"> <img src="${path}/static/fore-static/images/slider/摇头狗.png" alt="Slider2" class="img"  onclick="window.open('https://detail.tmall.com/item.htm?spm=a230r.1.14.22.69ae651e0tKjc1&id=584172873947&ns=1&abbucket=15')"

>
											<div class="txt1">广告：卖萌摇头狗</div>
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
	<div class="pages_wrapper">
		<div class="container">
			<div class="row">
				<div class="span8">
					<div class="pages">
						<!-- START ABOUT US -->
						<div class="pages_title">反向寻车</div>
						<p>输入车牌号</p>
						<input type="text" name="c_num" id="c_num" class="form-default"/>
						
						<input type="button" value="查看车辆" onclick="findCar()"/>
				
						
						<!-- END ABOUT US -->
						<div class="divider1"></div>
						<!-- START OUR TEACHER -->
						<div id="carMsg" style="display:none">
						<h3>车辆停放信息</h3>
						<ul class="thumbnails thumbnails1">
							<li>
								<div class="thumbnail clearfix">
									<div class="caption">
										<h6>车牌号：<span id="cnum" style="color:black"></span></h6>  
										<h6>车位号：<span id="pnum" style="color:black"></span></h6> 
										<span id="pic">
<%-- 										<a href="/picture/${c.p_imgpath}" data-lightbox="gallery"  --%>
<%-- 										data-title="车牌：${c.car.c_num}<br/>车位：${c.p_fore}${c.p_num}"> --%>
<!-- 										查看图片</a> -->
										</span>
										</div>
								</div>  
							</li>
							
						</ul>
						<!-- END OUR TEACHER -->
						<div class="divider1"></div>
						<!-- START OUR CLIENTS -->
						<h3>导航到车位</h3>
						<ul class="thumbnails thumbnails1">
							<li>
								<div class="thumbnail clearfix">
									<div class="client1">
										<a href="${path}/BirdMap/birdmap.do">
											<div class="client1_inner">
												<div class="c1">
													<div class="txt2">跳转到导航
													</div>
												</div>
											</div>
										</a>
									</div>
								</div>
							</li>
						</ul>
						</div>
						<!-- END OUR TEACHER -->
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- START FOOTER -->
	<footer>
		<div class="social_wrapper">
			<ul class="social clearfix">
				<li><a href="index.html#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="index.html#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="index.html#"><i class="fa fa-instagram"></i></a></li>
				<li><a href="index.html#"><i class="fa fa-youtube"></i></a></li>
				<li><a href="index.html#"><i class="fa fa-pinterest"></i></a></li>
			</ul>
		</div>
		<div class="copyright">Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></div>
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

<script type="text/javascript" src="${path}/static/lib/lightbox2/2.8.1/js/lightbox.min.js"></script> 
<script>
function findCar(){
	var car=document.getElementById("c_num").value;
	if(car==""||car==null){
		alert("请输入车牌号");
		return;
	}
	$.ajax({
		url:"${path}/findcar/carMsg.do",
		type:"POST",
		data:'{"c_num":'+JSON.stringify(car)+'}',
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		success:function(data){
			alert(data.p_fore);
			document.getElementById("carMsg").style.display="block";
			document.getElementById("cnum").innerHTML=data.car.c_num;
			document.getElementById("pnum").innerHTML=data.p_fore+data.p_num;
			
			var pic=document.getElementById("pic");
			pic.innerHTML="<a href='/picture/"+data.p_imgpath+
			"' data-lightbox='gallery' data-title='车牌:"+data.car.c_num+"<br/>车位："+data.p_fore+data.p_num+"'>查看图片</a>";
			
		}
		
	});
}










	// CAROUFSEDSEL SLIDER 1 
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
		// CAROUFSEDSEL SLIDER 2
		$('#slider2 .carousel.main ul').carouFredSel({
			auto: {
				timeoutDuration: 8000
			}
			, responsive: true
			, prev: '.prev3'
			, next: '.next3'
			, width: '100%'
			, scroll: {
				items: 1
				, duration: 1000
				, easing: "easeOutExpo"
			}
			, items: {
				width: '400'
				, height: 'variable', //	optionally resize item-height			  
				visible: {
					min: 1
					, max: 3
				}
			}
			, mousewheel: false
			, swipe: {
				onMouse: true
				, onTouch: true
			}
		});
		$(window).bind("resize", updateSizes_vat).bind("load", updateSizes_vat);

		function updateSizes_vat() {
			$('#caroufredsel_slider1').trigger("updateSizes");
			$('#slider3 .carousel.main ul').trigger("updateSizes");
		}
		updateSizes_vat();
	});
	$(window).load(function () {});
	// TESTIMONIALS
	$(document).ready(function () {
		$('#testimonials').carouFredSel({
			auto: {
				timeoutDuration: 8000
			}
			, responsive: true
			, prev: '.prev_testimonials'
			, next: '.next_testimonials'
			, width: '100%'
			, scroll: {
				items: 1
				, duration: 1000
				, easing: "easeOutExpo"
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
		});
		$(window).bind("resize", updateSizes_vat).bind("load", updateSizes_vat);

		function updateSizes_vat() {
			$('#testimonials').trigger("updateSizes");
		}
		updateSizes_vat();
	});
	$(window).load(function () {});
</script>
</body>

</html>

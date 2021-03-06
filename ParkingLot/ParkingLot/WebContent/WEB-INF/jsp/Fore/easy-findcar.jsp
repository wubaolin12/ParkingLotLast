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

	<div class="pages_wrapper">
		<div class="container">
			<div class="row">
				<div class="span8">
					<div class="pages">
						<!-- START ABOUT US -->
						<div class="pages_title">反向寻车</div>
						<p>输入车牌号</p>
						<input type="text" name="c_num" id="c_num" class="form-default"/>
						
						<input type="button" value="查看车辆" onclick="findCar()" class="btn btn-success"/>
				
						
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
						<form id="mapform" action="${path}/find/birdmap.do" method="post">
							<input type="hidden" id="p_mapid" name="p_mapid"/>
							<input type="hidden" id="p_feum" name="p_feum"/>
						</form>
						<ul class="thumbnails thumbnails1">
							<li>
								<div class="thumbnail clearfix">
									<div class="client1">
										<a href="javascript:;" onclick="gotoMap()">
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

<script type="text/javascript" src="${path}/static/lib/lightbox2/2.8.1/js/lightbox.min.js"></script> 
<script>
function gotoMap(){
	document.getElementById("mapform").submit();
}

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
			document.getElementById("carMsg").style.display="block";
			document.getElementById("cnum").innerHTML=data.car.c_num;
			document.getElementById("pnum").innerHTML=data.p_fore+data.p_num;
			
			var pic=document.getElementById("pic");
			pic.innerHTML="<a href='/picture/"+data.car.c_pic+
			"' data-lightbox='gallery' data-title='车牌:"+data.car.c_num+"<br/>车位："+data.p_fore+data.p_num+"'>查看图片</a>";
			
			document.getElementById("p_mapid").value=data.p_mapid;
			document.getElementById("p_feum").value=data.p_feum;
		},
	error:function(data){
		alert("对不起！查无此车");
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

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
<title>人脸识别登录</title>
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
<script type="text/javascript" src="<%=path%>static/js/jquery-1.8.3.min.js"></script>
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
								<div class="pages_title">人脸识别登录</div>
								
							
							<!-- START COMMENT -->
							
							<div id="note"></div>
							<div id="fields">
	<div id="ajax-contact-form" class="form-horizontal">								
	<video id="video" width="300px" height="300px" autoplay="autoplay" style="margin-left:7%"></video>
	<canvas id="canvas" width="300px" height="300px"></canvas>
	<button id="snap" class="submit" onclick="takePhoto()">拍照</button>	
		<button id="snap" class="submit" onclick="back()">返回</button>	
	
					</div>			
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

window.onload = function (){
    let constraints = {
      video: {width: 300, height: 300},
      audio: true
  };
  //获得video摄像头区域
  let video = document.getElementById("video");
  //这里介绍新的方法，返回一个 Promise对象
  // 这个Promise对象返回成功后的回调函数带一个 MediaStream 对象作为其参数
  // then()是Promise对象里的方法
  // then()方法是异步执行，当then()前的方法执行完后再执行then()内部的程序
  // 避免数据没有获取到
  let promise = navigator.mediaDevices.getUserMedia(constraints);
  promise.then(function (MediaStream) {
      video.srcObject = MediaStream;
      video.play();
  });
}
function takePhoto() {
//获得Canvas对象
let video = document.getElementById("video");
let canvas = document.getElementById("canvas");
let ctx = canvas.getContext('2d');
ctx.drawImage(video, 0, 0);
var imgData = canvas.toDataURL();
	//获取图像在前端截取22位以后的字符串作为图像数据
	var imgData1 = imgData.substring(22);
	var username = $("#username").val();
	$.ajax({
			type: "post",
			url: "<%=path%>faceServlte/face.do?tag=login",
			data: {"img":imgData1,"username":username},
			success: function(data){
			if(data=="登陆成功"){
				alert(data);
			//	alert("${pageContext.request.contextPath}");
				location.href="<%=path%>fore/success1.do";
				}else{
					alert("未存在此人.请重试!!!!");
				}
			},error:function(msg){
				alert("检测到不是你的脸");
			}
		});
}


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
	//$(window).load(function () {});

	
	
	
	function back(){
		location.href="<%=path%>fore/foreLogin.do";
	}
</script>
</body>

</html>

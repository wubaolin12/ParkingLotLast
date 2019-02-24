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
<title>自助缴费</title>
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
	
	<!-- END MOUNTAIN EFFECT -->
	<div id="inner">
	<div class="pages_wrapper" >
			<div class="container">
				<div class="row">
					<div class="span8">
					   <!-- START CONTACT US -->
						<div class="pages">
							<!-- START COMMENT -->
							<h3>自助缴费</h3>
							<h5>缴费成功后，请迅速出场，否则将重新计费</h5>
							<div id="note"></div>
							<div id="fields">
							<form name="ajax-contact-form" action="<%=path %>/self/foreCar.do" method=post
			 id="ajax-contact-form" class="form-horizontal" onSubmit="return Recharge()">
										<div class="block3">
											<div class="control-group">
												<div class="controls" align="left">
													<input type="text" id="number" name="number" value="车牌号" onBlur="if(this.value=='') this.value='车牌号'" onFocus="if(this.value =='车牌号' ) this.value=''"
									                 ></div>
											</div>
										<button type="submit" class="submit" >查询车牌号</button>	
									</div>
						    </form>
							</div>
							<!-- END COMMENT -->
						</div>
						<!-- END CONTACT US -->
					</div>
				
				 </div>
				 <br/>
				  <div>
						        <% int selfFlag=0;
						      int selfMoney=0;
						    if(request.getAttribute("selfFlag")!=null){
						    selfFlag=(int)request.getAttribute("selfFlag"); 
						    selfMoney=(int)request.getAttribute("selfMoney"); 
						    if(selfFlag==0){%>
						    <h5>缴费情况：已缴费 </h5>
						    <%}else{ %>
						   <h5>缴费情况： 未缴费 </h5> <br/> <h5>本次停车费用：  <%=selfMoney %>元</h5>
						    <%} %>
						   
						    <%if(selfFlag==1&&selfMoney>0){ %>
						   <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
										<input class="btn btn-warning" type="button"
											value="&nbsp;&nbsp;缴费&nbsp;&nbsp;" onclick="moneyToSelf()">
									</div> 
						    <%}
						    } %>
						    
						   		 <div style="display:none">
									    <form name="alipayment" action="${path}/self/foreMoneyTo_Self.pay" method=post
											 id="alipayment" class="form-horizontal" >
										订单名称:<input id="WIDsubject" name="WIDsubject" />
										商户订单号:<input id="WIDout_trade_no" name="WIDout_trade_no" />
										商品描述:<input id="WIDbody" name="WIDbody" />
										商品价格:<input id="WIDtotal_amount" name="WIDtotal_amount"  value="<%=selfFlag==1?selfMoney:0 %>"/>
										</form>
								</div>
							</div>
			</div>
		</div>
		  
		<!-- START FOOTER -->
		<footer>
			
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
		document.getElementById("WIDsubject").value = "传一智能停车场系统自助缴费";
	}
	GetDateNow();
	//充值提交
	function Recharge(){
		var flag=false;
		var number= document.getElementById('number').value;
		if(number!='车牌号'&&number!=''){
			flag=true;
		}else{
			alert("请输入车牌号");
		}
		return flag;
	}
	function moneyToSelf(){
		 if(confirm("确定要自助缴费吗？")==true){
			 var form = document.getElementById('alipayment');
			form.submit();
		}
		
	}
</script>
</body>

</html>

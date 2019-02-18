<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>车辆出场LED效果</title>

<link rel="stylesheet" type="text/css" href="<%=path%>static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>static/css/demo.css">
<link rel="stylesheet" href="<%=path%>static/dist/jquery.vidbacking.css" type="text/css">
<link rel="stylesheet" href="<%=path%>static/css/style2.css" type="text/css">
</head>
<body>
<TABLE border=0 cellSpacing=0 cellPadding=0 width=1000 
      background=<%=path%>static/img/led.png align=center height=40>
        <TBODY>
        <TR>
          <TD height:30%; width:100%>
		  <span id="systimeshow" style="color:#FF0000">
		  <script language="javascript">getCurDate();</script></span>
		  <script language="javascript">
				function getCurDate()
					{
						 var d = new Date();
						 var week;
						 switch (d.getDay()){
							 case 1: week="星期一"; break;
							 case 2: week="星期二"; break;
							 case 3: week="星期三"; break;
							 case 4: week="星期四"; break;
							 case 5: week="星期五"; break;
							 case 6: week="星期六"; break;
							 default: week="星期天";
						 }
						 var years = d.getFullYear();
						 var month = add_zero(d.getMonth()+1);
						 var days = add_zero(d.getDate());
						 var hours = add_zero(d.getHours());
						 var minutes = add_zero(d.getMinutes());
						 var seconds=add_zero(d.getSeconds());
						 var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
						 var divT=document.getElementById("systimeshow"); 
							 divT.innerHTML= ndate;
						}
						 
						function add_zero(temp)
						{
							 if(temp<10) return "0"+temp;
							 else return temp;
						}
					setInterval("getCurDate()",100); 
		  </script>
		  </TD>
           <TD width=850>
		  <MARQUEE 
            style="FILTER: glow(color=red); LINE-HEIGHT: 60px; WIDTH: 100%; FONT-FAMILY: '黑体','黑体_GB2312','黑体';
			 COLOR: #ffff00; FONT-SIZE: 50px; text-shadow: #ff0000 1px 1px 0px" 
            scrollAmount=8><B><FONT 
            face=Verdana><%int moneyFlag=(int)session.getAttribute("moneyFlag");
          System.out.println("moneyFlag="+moneyFlag);  
		  if (moneyFlag==0){ %> 开 闸 ！
		  <%}else{ %>
		  闸 未 开 ！
		  <%} %>
		  车牌：${Carkxj.c_num} 本次费用：${Stopkxj.sct_money}元 入场时间：${Stopkxj.sct_starttime} 出场时间：${Stopkxj.sct_overtime}   谢谢惠顾！  </FONT></B>
			</MARQUEE>
		  </TD>
		  
		</TR>
		</TBODY>
		</TABLE>
		<div   align="center">	
		  <%
		  if (moneyFlag==1){ %>
		  <input type="button"  value="缴费即可开闸" id="hqbutton" name="hqbutton" onclick="toPay(${Stopkxj.sct_money})"/>
		  <% }%>
		</div>
		
			<div   align="center">			
		<img src="<%=path%>static/img/1.gif"></img>
		</div>
		
		<video poster="<%=path%>static/images/screenshot1.jpg" autoplay muted loop class="vidbacking">
		<source src="<%=path%>static/images/Rallye.mp4" type="video/mp4">
</video>
<div style="display:none">
	<form name="alipayment" action="<%=path%>outPay/moneyTo_out.pay" method="post"
			 id="alipayment"  target="_blank">
			<div id="body1"  name="divcontent">
					商户订单号 ：<input id="WIDout_trade_no" name="WIDout_trade_no" />
					订单名称 ：<input id="WIDsubject" name="WIDsubject" />
					付款金额 ：<input id="WIDtotal_amount" name="WIDtotal_amount" />
					商品描述：<input id="WIDbody" name="WIDbody" />
			</div>
		</form>
	</div>
<script src="<%=path%>static/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="<%=path%>static/dist/jquery.vidbacking.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('body').vidbacking({
			'masked': true
		});
	});
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
		document.getElementById("WIDsubject").value = "传一智能停车场系统出场缴费";
	}
	GetDateNow();
	function toPay(money){
		alert("缴费"+money+"元");
		document.getElementById("WIDtotal_amount").value = money;
		var form = document.getElementById('alipayment');
		form.submit();
	}
</script>
</body>
</html>

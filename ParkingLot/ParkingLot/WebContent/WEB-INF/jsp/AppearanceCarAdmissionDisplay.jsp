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
            face=Verdana>车牌：${Carkxj.c_num} 本次费用：${Stopkxj.sct_money}元 入场时间：${Stopkxj.sct_starttime} 出场时间：${Stopkxj.sct_overtime}   谢谢惠顾！</FONT></B>
			</MARQUEE>
		  </TD>
		</TR>
		</TBODY>
		</TABLE>
</body>
</html>

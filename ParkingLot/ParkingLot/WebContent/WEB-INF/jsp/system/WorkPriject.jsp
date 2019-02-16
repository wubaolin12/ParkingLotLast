<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.great.bean.Sche"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>员工排班</title>

  <link rel='stylesheet' type='text/css' href='${path}/static/css/jquery-ui-1.8.11.custom.css' />
  <link rel='stylesheet' type='text/css' href='${path}/static/css/jquery.weekcalendar.css' />
  <style type='text/css'>
  body {
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    margin: 0;
  }

  h1 {
    margin: 0 0 1em;
    padding: 0.5em;
  }

  p.description {
    font-size: 0.8em;
    padding: 1em;
    position: absolute;
    top: 3.2em;
    margin-right: 400px;
  }

  #message {
    font-size: 0.7em;
    position: absolute;
    top: 1em;
    right: 1em;
    width: 350px;
    display: none;
    padding: 1em;
    background: #ffc;
    border: 1px solid #dda;
  }
  </style>

  <script type='text/javascript' src='${path}/static/css/jquery-1.4.4.min.js'></script>
  <script type='text/javascript' src='${path}/static/css/jquery-ui-1.8.11.custom.min.js'></script>

  <script type="text/javascript" src="${path}/static/css/date.js"></script>
  <script type='text/javascript' src='${path}/static/css/jquery.weekcalendar.js'></script>
  <script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
  <script type="text/javascript" src="${path}/static/lib/laypage/1.2/laypage.js"></script>
  
  <script type="text/javascript">



</script>
  <script type='text/javascript'>
  var year = new Date().getFullYear();
  var month = new Date().getMonth();
  var day = new Date().getDate();

  var jlist= ${Jlist};

  var events=[];
  for (var i = 0; i < jlist.length; i++) {
		var rm = jlist[i];
		var sdate=jlist[i].s_date;
		var end=parseInt(rm.sstate.ss_overtime);
		var start=parseInt(rm.sstate.ss_starttime);
		var ndate=new Date(sdate);
         var syear =ndate.getFullYear();//获取完整的年份(4位,1970-????)
         var smonth = ndate.getMonth() ;//获取当前月份(0-11,0代表1月)
         var sday = ndate.getDate();//获取当前日(1-31)
		events.push({

 			"id" :rm.s_id,
			"start":new Date(syear, smonth, sday, start),
			"end":new Date(syear, smonth, sday, end),
			"title" : "工作"  
		})
	} 
   var eventData=events ; 
  $(document).ready(function() {
   

	  
	 $('#calendar').weekCalendar({
      timeslotsPerHour: 2,
      timeslotHeigh:30,
      hourLine: true,
      data: eventData,
      
      height: function($calendar) {
    	
        return $(window).height() - $('h1').outerHeight(true);
      },
      eventRender : function(calEvent, $event) {
        if (calEvent.end.getTime() < new Date().getTime()) {
          $event.css('backgroundColor', '#aaa');
          $event.find('.time').css({'backgroundColor': '#999', 'border':'1px solid #888'});
        }
        
      },
    

       eventNew: function(calEvent, $event) {

        var time = new Date(calEvent.start);
        var time2 = new Date(calEvent.end);

         var year =time.getFullYear();//获取完整的年份(4位,1970-????)
         var month = time.getMonth() + 1;//获取当前月份(0-11,0代表1月)
         var day = time.getDate();//获取当前日(1-31)
         var hours = time.getHours();
        
        var hours2 = time2.getHours();
        var Minutes= time2.getMinutes();
        
        var getUserID = document.getElementById("getUserID").value;
        var state =0;
        if(hours>=0&&hours<8){
        	state=1;
        }else if(hours>=8&&hours<16){
        	state=2;
        }else if(hours>=16&&hours<24){
        	state=3;
        }
        var s_date=year+"-"+month+"-"+day;
        var u_id=document.getElementById("getUserID").value;
 
        var currentDate = new Date();
        var currentnyear=currentDate.getFullYear();    //获取完整的年份(4位,1970-????)
        var currentmonth =currentDate.getMonth();       //获取当前月份(0-11,0代表1月)
        var currentday=currentDate.getDate();        //获取当前日(1-31)
        
        if(year>=currentnyear){
        	
        	if(month>=currentmonth){
        		
        		if(day>=currentday){
        	        $.ajax({
        	            url:'${path}/workPrijectHandler/CheckWorkAjax.action',
        				dataType:"text", 
        				data:{"ss_id":state,"s_date":s_date,"u_id":u_id},
        				type:"post",
        				
        				success:function(data){
        					alert(data);
        					if(data=="该日期已有排班"){
         							
         							var r=confirm("该日期已有排班,是否修改!");
         							if (r==true)
         							  {
         							  alert("修改排班!");
         							 $.ajax({
          		        	            url:'${path}/workPrijectHandler/updateWorkAjax.action',
          		        				dataType:"text", 
          		        				data:{"ss_id":state,"s_date":s_date,"u_id":u_id},
          		        				type:"post",
          		        				success:function(data){
          		        	                 location.href="${path}/workPrijectHandler/FindWorkProject.action?getUserID="+u_id;

          		        				},
          		        				error:function(data) {
          		        					console.log(data.msg);
          		        				}
          							});
         							  
         							  }
         							else
         							  {
         							  	alert("取消修改!");
     		        	                 location.href="${path}/workPrijectHandler/FindWorkProject.action?getUserID="+u_id;

         							  }
         							
        						
        					}else{
        					      $.ajax({
        		        	            url:'${path}/workPrijectHandler/AddWorkTestAjax.action',
        		        				dataType:"text", 
        		        				data:{"ss_id":state,"s_date":s_date,"u_id":u_id},
        		        				type:"post",
        		        				
        		        				success:function(data){
        		        	                 location.href="${path}/workPrijectHandler/FindWorkProject.action?getUserID="+u_id;

        		        				}
        							});
        					}
        					
        	            }
        	        });
        	        
        	 
        		}else{
        			alert("该日期已过，不能排班");
	                 location.href="${path}/workPrijectHandler/FindWorkProject.action?getUserID="+u_id;

        		}
        	}else{
        		alert("该月已过，不能排班");
        	}
        	
        }else{
        	alert("该年已过");
        } 
        

        alert('You\'ve added a new event. You would capture this event, add the logic for creating a new event with your own fields, data and whatever backend persistence you require.');
      },
      
    });

     function displayMessage(message) {
      $('#message').html(message).fadeIn();
    } 

    $('<div id="message" class="ui-corner-all"></div>').prependTo($('body'));
  });

</script>

</head>
<body>

<!-- 容器 -->
	<div>
		<form action="${path}/workPrijectHandler/FindWorkProject.action" method="post"
			onsubmit="return checkForm()">
			<div id="searchdiv" style="margin-bottom: 20px;">
				<input type="hidden" name="getUserID2" id="getUserID2"
					value="${GETUSERID}" size=15 /> <span style="margin-left: 30px">员工：</span><select
					id="getUserID" name="getUserID" style="margin-left: 30px">
					<option value="${GETUSERID}">${GETUSERID}</option>
					<c:forEach items="${UserList}" var="u" varStatus="ee">
						<option value="${u.u_id}">${u.u_id}--${u.u_name}</option>
					</c:forEach>
				</select> <input type="submit" id="action" name="action" value="查询"
					style="margin-left: 80px">
			</div>
		</form>
	</div>
  <div id='calendar'></div>
</body>
</html>
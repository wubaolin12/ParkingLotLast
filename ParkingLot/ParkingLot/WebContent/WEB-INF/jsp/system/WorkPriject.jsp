<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
  <script type='text/javascript'>
  var year = new Date().getFullYear();
  var month = new Date().getMonth();
  var day = new Date().getDate();
  
  var eventData = {
    events : [
      {'id':1, 'start': new Date(year, month, day, 12), 'end': new Date(year, month, day, 13, 35),'title':'Lunch with Mike'},
      {'id':2, 'start': new Date(year, month, day, 14), 'end': new Date(year, month, day, 14, 45),'title':'Dev Meeting'},
      {'id':3, 'start': new Date(year, month, day + 1, 18), 'end': new Date(year, month, day + 1, 18, 45),'title':'Hair cut'},
      {'id':4, 'start': new Date(year, month, day - 1, 8), 'end': new Date(year, month, day - 1, 9, 30),'title':'Team breakfast'},
      {'id':5, 'start': new Date(year, month, day + 1, 14), 'end': new Date(year, month, day + 1, 15),'title':'Product showcase'}
    ]
  };

  $(document).ready(function() {
    $('#calendar').weekCalendar({
      timeslotsPerHour: 6,
      timeslotHeigh: 30,
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
        alert(calEvent.start);
        var time = new Date(calEvent.start);
        alert(time);
        alert(1);
         var year =time.getFullYear();//获取完整的年份(4位,1970-????)
         var month = time.getMonth() + 1;//获取当前月份(0-11,0代表1月)
         var day = time.getDate();//获取当前日(1-31)
         var hours = time.getHours();
        var getUserID = document.getElementById("getUserID").value;
        alert("年"+year);
        alert("月"+month);
        alert("日"+day);
        alert("時"+hours);
        var state =0;
        if(hours>=0&&hours<8){
        	state=1;
        }else if(hours>=8&&hours<16){
        	state=2;
        }else if(hours>=16&&hours<24){
        	state=3;
        }
        alert("狀態"+state);
        alert(typeof state);
        alert(typeof year);
        alert(typeof month);
        alert(typeof day);
        alert(getUserID);
        $.ajax({
            url:'${path}/workPrijectHandler/SetWorkProject.action',
			data:'{"state":'+state+',"year":'+year+',"month":'+month+',"day":'+day+',"getUserID":'+getUserID+'}',
			type:'post',
			contentType:"application/json;charset=utf-8",
			sussccess:function(data){
                 alert("完成");
            }
        });
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
  <h1>Week Calendar Demo</h1>
  <p class="description">
    This calendar demonstrates a basic calendar. Events triggered are
    displayed in the message area. Appointments in the past are shaded grey.
  </p>
<!-- 容器 -->
	<div>
		<form action="${path}/workPrijectHandler/FindWorkProject.action" method="get"
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
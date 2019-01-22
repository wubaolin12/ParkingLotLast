<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>  
<html>
<head>  
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>Hello, World</title>  
<style type="text/css">  
html{height:100%}  
body{height:100%;margin:0px;padding:0px}  
#container{height:100%}  
</style>  
<script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=jZPlFCrgYx4PvqVXBnkHsnMy9QCtMC6E">
</script>
</head>  
 
<body>  
<div id="container"></div> 
<script type="text/javascript"> 
var map = new BMap.Map("container");
// 创建地图实例  
var point = new BMap.Point(118.079255, 24.450783);
 
// 创建点坐标  
map.centerAndZoom(point, 15);


var marker = new BMap.Marker(point);        // 创建标注    
marker.setIcon('/BaseMap/markers.png')
map.addOverlay(marker); 


var opts = {
		  width : 200,     // 信息窗口宽度
		  height: 100,     // 信息窗口高度
		  title : "海底捞王府井店" , // 信息窗口标题
		  enableMessage:true,//设置允许信息窗发送短息
		  message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
		}
		var infoWindow = new BMap.InfoWindow("地址：北京市东城区王府井大街88号乐天银泰百货八层", opts);  // 创建信息窗口对象 


//监听，可以将自己的停车场放到这边
marker.addEventListener("click", function(){    
    alert("孔大爷的停车场");    
    map.openInfoWindow(infoWindow,point); //开启信息窗口
});  



map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
// 初始化地图，设置中心点坐标和地图级别  
window.setTimeout(function(){  
    map.panTo(new BMap.Point(118.079255, 24.450783));    
}, 2000);

map.addControl(new BMap.NavigationControl());    
map.addControl(new BMap.ScaleControl());    
map.addControl(new BMap.OverviewMapControl());    
map.addControl(new BMap.MapTypeControl());    
map.setCurrentCity("厦门"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用   

var opts = {offset: new BMap.Size(150, 5)}
map.addControl(new BMap.ScaleControl(opts));


</script>  
</body>  
</html>
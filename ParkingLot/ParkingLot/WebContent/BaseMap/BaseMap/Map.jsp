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
.infoBoxContent{font-size:12px;}
	.infoBoxContent .title{background:url(<%=path%>static/map/tipbox.jpg) no-repeat;height:42px;width:272px;}
	.infoBoxContent .title strong{font-size:14px;line-height:42px;padding:0 10px 0 5px;}
	.infoBoxContent .title .price{color:#FFFF00;}
	.infoBoxContent .list{width:268px;border:solid 1px #4FA5FC;border-top:none;background:#fff;height:260px;}
	.infoBoxContent .list ul{margin:0;padding:5px;list-style:none;}
	.infoBoxContent .list ul li {float:left;width:255px;border-bottom:solid 1px #4FA5FC;padding:2px 0;}
	.infoBoxContent .list ul .last{border:none;}
	.infoBoxContent .list ul img{width:53px;height:42px;margin-right:5px;}
	.infoBoxContent .list ul p{padding:0;margin:0;}
	.infoBoxContent .left{float:left;}
	.infoBoxContent .rmb{float:right;color:#EB6100;font-size:14px;font-weight:bold;}
	.infoBoxContent a{color:#0041D9;text-decoration:none;}
 
</style>  
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jZPlFCrgYx4PvqVXBnkHsnMy9QCtMC6E">
</script>
<script type="text/javascript" src="<%=path%>/BaseMap/InfoBox_min.js"></script>
<script src="<%=path%>/BaseMap/Map.js"></script>
<link rel="stylesheet" href="<%=path%>/BaseMap/MapStyle.css">
<script type="text/javascript" src="<%=path%>/BaseMap/Jquery.js"></script>
</head>  
 
<body> 
<div id="myPageTop">
<a href="javascript:void(0);" id="show">
查找路线
</a>
<div class="pageShow">
<h3>搜索地址</h3>
<input id="local" placeholder="模糊地址搜索">
<span>—&nbsp;—</span>
<a id="city" href="javascript:void(0);">
点击搜索
</a>
<h3>搜索行车路径</h3>
<input id="star" placeholder="行车开始地址">
<span>—&nbsp;—</span>
<input id="end" placeholder="行车结束地址">
<span>—&nbsp;—</span>
<a id="car" href="javascript:void(0);">
点击搜索
</a>
<h3>搜索公交路径</h3>
<input id="bStar" placeholder="公交开始地址">
<span>—&nbsp;—</span>
<input id="bEnd" placeholder="公交结束地址">
<span>—&nbsp;—</span>
<a id="bus" href="javascript:void(0);">
点击搜索
</a>
<h3>搜索步行路径</h3>
<input id="wStar" placeholder="步行开始地址">
<span>—&nbsp;—</span>
<input id="wEnd" placeholder="步行结束地址">
<span>—&nbsp;—</span>
<a id="walk" href="javascript:void(0);">
点击搜索
</a>
</div>
</div> 
<div id="container"></div> 
<div id="panel"></div>
<!-- 
<script type="text/javascript">

window.onload=function(){var map=new BMap.Map("container");var point=new BMap.Point(118.079255, 24.450783);


var stCtrl = new BMap.PanoramaControl();  
stCtrl.setOffset(new BMap.Size(20, 20));  
map.addControl(stCtrl);




map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
var top_left_navigation = new BMap.NavigationControl({type:BMAP_NAVIGATION_CONTROL_SMALL}); //左上角，添加默认缩放平移控件

var html = ["<div class='infoBoxContent'><div class='title'><strong>出售胡红旗</strong><span class='price'>均价43000</span></div>",
	"<div class='list'><ul><li><div class='left'><img src='house3.jpg'/></div><div class='left'><a target='_blank' href='http://map.baidu.com'>中海雅园南北通透四居室</a><p>4室2厅，205.00平米，3层</p></div><div class='rmb'>760万</div></li>"
	,"<li><div class='left'><img src='house1.jpg'/></div><div class='left'><a target='_blank' href='http://map.baidu.com'>中海雅园四居室还带保姆间</a><p>2室1厅，112.00平米，16层</p></div><div class='rmb'>300万</div></li>"
	,"<li><div class='left'><img src='house2.jpg'/></div><div class='left'><a target='_blank' href='http://map.baidu.com'>《有钥匙 随时看》花园水系</a><p>3室2厅，241.00平米，16层</p></div><div class='rmb'>400万</div></li>"
	,"<li><div class='left'><img src='house3.jpg'/></div><div class='left'><a target='_blank' href='http://map.baidu.com'>富力城D区正规楼王大三居</a><p>3室3厅，241.00平米，17层</p></div><div class='rmb'>600万</div></li>"
	,"<li class='last'><div class='left'><img src='house1.jpg'/></div><div class='left'><a target='_blank' href='http://map.baidu.com'>富力城豪，身份人士的象征</a><p>4室2厅，213.90平米，25层</p></div><div class='rmb'>700万</div></li>"
	,"</ul></div>"
	,"</div>"];
	var infoBox = new BMapLib.InfoBox(map,html.join(""),{
		boxStyle:{
			background:"url('../tipbox.png') no-repeat center top"
			,width: "270px"
			,height: "300px"
		}
		,closeIconMargin: "1px 1px 0 0"
		,enableAutoPan: true
		,align: INFOBOX_AT_TOP
	});

	//var marker = new BMap.Marker(poi);
	var marker = new BMap.Marker(point);        // 创建标注    
	map.addOverlay(marker);





//监听，可以将自己的停车场放到这边
marker.addEventListener("click", function(){    
    alert("孔大爷的停车场");    
	infoBox.open(marker);
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






map.centerAndZoom(point,12);map.addControl(new BMap.ScaleControl());map.addControl(new BMap.OverviewMapControl());map.addControl(new BMap.MapTypeControl());map.enableScrollWheelZoom()
var marker=new BMap.Marker(point);marker.enableDragging();var local=new BMap.LocalSearch(map,{renderOptions:{map:map}});local.search('');var driving=new BMap.DrivingRoute(map,{renderOptions:{map:map,autoViewport:true}});var walking=new BMap.WalkingRoute(map,{renderOptions:{map:map}});var transit=new BMap.TransitRoute(map,{renderOptions:{map:map,panel:"results"}});$(function(){$('#city').on('click',function(){$('.pageShow').slideToggle();local.search($('#local').val());})
$('#car').on('click',function(){$('.pageShow').slideToggle();driving.search($('#star').val(),$('#end').val());})
$('#bus').on('click',function(){$('.pageShow').slideToggle();transit.search($('#bStar').val(),$('#bEnd').val());})
$('#walk').on('click',function(){$('.pageShow').slideToggle();walking.search($('#wStar').val(),$('#wEnd').val());})})
$("#show").on('click',function(){$('.pageShow').slideToggle();})}
</script> -->

</body>  
</html>
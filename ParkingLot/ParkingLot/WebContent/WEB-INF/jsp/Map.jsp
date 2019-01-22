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
	.infoBoxContent .title{background:url(<%=path%>/static/map/tipbox.png) no-repeat;height:42px;width:272px;}
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
<script type="text/javascript" src="<%=path%>/static/map/InfoBox_min.js"></script>
<script src="<%=path%>/static/map/Map.js"></script>
<link rel="stylesheet" href="<%=path%>/static/map/MapStyle.css">
<script type="text/javascript" src="<%=path%>/static/map/Jquery.js"></script>
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

</body>  
</html>
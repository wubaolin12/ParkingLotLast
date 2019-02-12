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
	//infoBox.open(marker);
    
    location.href="BirdMap/birdmap.action";
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
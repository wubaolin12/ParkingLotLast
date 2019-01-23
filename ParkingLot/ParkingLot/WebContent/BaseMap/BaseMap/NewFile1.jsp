<%@ page language="java" contentType="text/html; charset=utf-8"
    %>

<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta charset="UTF-8">
  <title>孔大帅的停车场</title>
   <link href="../lib/bootstrap.min.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/iconfont/iconfont.css" rel="stylesheet">
</head>
<style type="text/css">
  #pannel {
    position: absolute;
    left: 2%;
    bottom: 10%;
    z-index: 999;
  }
	
  .search {
            position: absolute;
            padding-left: 10px;
            top: 60px;
            left: 150px;
            font-size: 13px;
            height: auto;
            border: 1px solid #e6e6e6;
            background: #fff;
            /* box-shadow: 3px 3px 5px #bdbdbd; */
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            z-index: 999;
            border-radius: 4px;
        }

        .searchText {
            width: 300px;
            height: 20px;
            outline: none;
            border: none;
            margin: 0 0 0 14px;
            font-size: 13px;
            -webkit-appearance: none;
        }

        #shopSearch {
            position: absolute;
            min-width: 240px;
            max-height: 500px;
            top: 120px;
            left: 150px;
            border: 1px solid #e6e6e6;
            background: #fff;
            box-shadow: 3px 3px 5px #bdbdbd;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            z-index: 999;
            display: none;
            overflow-y: scroll;
            overflow-x: hidden;
        }

        #router {
            position: absolute;
            padding: 20px;
            width: 457px;
            top: 120px;
            left: 150px;
            height: 130px;
            padding: 22px 18px;
            /*margin-left: px;*/
            border: 1px solid #e6e6e6;
            background: #fff;
            box-shadow: 3px 3px 5px #bdbdbd;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            z-index: 999;
            display: none;
        }

        .router .routerInput {
            height: 40px;
            padding: 6px 0;
            box-sizing: border-box;
        }

        .router .routerInput .routerText {
            width: 250px;
            border: none;
            outline: 0;
            height: 20px;
            font-size: 16px;
            border-bottom: 1px solid #dedede;
            margin-left: 6px;
        }

        #shopSearch>ul {
            list-style-type: none;
            padding: 10px;
        }

        .list ul>li {
            list-style: none;
            padding: 10px 12px;
            font-size: 13px;
            color: #5d5d5d;
            cursor: pointer;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
        }

        .list ul>li>span {
            padding-right: 18px;
        }

        .list ul>li:hover {
            background: #bbb;
            color:#fff;
        }

        #navTo {
            position: absolute;
            top: 46px;
            left: 338px;
        }


	button,input[type="button"] {
			padding: 7px 11px;
			background-color: #fff;
			border: none;
			cursor: pointer;
			border-radius: 3px;
		}
  #description {
    position: absolute;
    left: 50%;
    top: 86px;
    padding: 10px 25px;
    background: rgba(255, 255, 255, 255);
    border-radius: 4px;
    margin-left: -140px;
    opacity: 0.7;
  }

  #tool-tip {
    position: absolute;
    color: #fff;
    font-size: 18px;
    height: 25px;
    line-height: 25px;
    padding: 0 5px;
    z-index: 2;
    pointer-events: none;
    background-color: rgba(0, 0, 0, 0.3);
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    display: none;
  }

  .container-fluid h1 {
    text-align: center;
  }

</style>

<body ms-controller="ctrl" class="ms-controller">
 	<div id="map-container"></div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<h1>
				<a href="/" title="孔大帅的大楼" target="_blank">孔大帅的大楼</a>
				
			</h1>

			<div class="tips-right">
				<span class="tip1"></span> <span class="tip2"></span>
			</div>
		
		</div>
	
  </nav>
  <div id="description">
    暂无导航提示信息
  </div>
  
   <!-- 搜索 -->
    <div class="search">
        <span id="btnSearch" class="glyphicon glyphicon-search" aria-hidden="true"></span>
        <input id="searchText" type="text" class="searchText" placeholder="搜索关键字">
       
    </div>

    <!-- 查询显示列表 -->
    <div id="shopSearch" class="layer list">
        <ul>
        </ul>
    </div>
  
  <div id="pannel">
    <input type="button" class="btn btn-default btnclass" onclick="clearNavi()" value="清除" />
    <input type="button" class="btn btn-default btnclass" onclick="startNavi1()" value="开始第一人称导航" />
    <input type="button" class="btn btn-default btnclass" onclick="startNavi2()" value="开始第三人称导航" />
      <input type="button" id="btnPick"  class="btn btn-default btnclass"  value="开启模型拾取" />
    <input type="button" id="btnPickend" class="btn btn-default btnclass"  value="关闭模型拾取" />
 
  </div>
 
 
  <div class="viewmode-floor btn-floor-vertical" data-toggle="buttons">
    <button id="btn2D" class="btn btn-default">2D</button>
    <button id="btn3D" class="btn btn-default">3D</button>
    <button id="displaySearch" class="btn btn-default" onclick="hidde()">隐藏搜索信息</button>
  </div>
  
  
	
	<!-- data-backdrop="false" -->
	<div id="dlgModelInfo" class="modal fade">
		<div class="modal-dialog bottom">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">模型信息</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">楼层</div>
							<div class="col-md-9" id="m-fnum"></div>
						</div>
						<div class="row">
							<div class="col-md-3">ID</div>
							<div class="col-md-9" id="m-ID"></div>
						</div>
						<div class="row">
							<div class="col-md-3">typeID</div>
							<div class="col-md-9" id="m-type"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标x</div>
							<div class="col-md-9" id="m-x"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标y</div>
							<div class="col-md-9" id="m-y"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- data-backdrop="false" -->
	<div id="dlgLabellInfo" class="modal fade">
		<div class="modal-dialog bottom">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">标注信息</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">楼层</div>
							<div class="col-md-9" id="l-fnum"></div>
						</div>
						<div class="row">
							<div class="col-md-3">ID</div>
							<div class="col-md-9" id="l-ID"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标x</div>
							<div class="col-md-9" id="l-x"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标y</div>
							<div class="col-md-9" id="l-y"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- data-backdrop="false" -->
	<div id="dlgPOIInfo" class="modal fade">
		<div class="modal-dialog bottom">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">POI信息</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">楼层</div>
							<div class="col-md-9" id="p-fnum"></div>
						</div>
						<div class="row">
							<div class="col-md-3">ID</div>
							<div class="col-md-9" id="p-ID"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标x</div>
							<div class="col-md-9" id="p-x"></div>
						</div>
						<div class="row">
							<div class="col-md-3">坐标y</div>
							<div class="col-md-9" id="p-y"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
  
  
 	<script src="../lib/esmap.min.js"></script>
	<script src="../lib/jquery-2.1.4.min.js"></script>
	<script src="../lib/jquery.qrcode.min.js"></script>
	<script src="../lib/tips_controls.js"></script>
	<script src="../lib/bootstrap.min.js"></script>
	<!-- 信息控件，基于Jquery库   -->
	<script src="../lib/js/layerFloor.js"></script>
	<script src="../lib/config.js"></script>
	
	
  <script type="text/javascript">
    //定义全局map变量
    var map;
    var esmapID = getQueryString('id') || defaultOpt.mapID;
    var styleid = getQueryString("styleid") || defaultOpt.themeID;
    // 导航对象
    var navi;
    // 点击计数
    var clickCount = 0;
    var locateMarkLayer = null;
    var h = 1;
    var curfnum = null;
    var floorControl;
    var mapCoord = null;
    window.onload = function () {
      if (navi) {
        navi.stop();
        navi = null;
      }
      // 楼层控制控件配置参数
      var ctlOpt = new esmap.ESControlOptions({
        position: esmap.ESControlPositon.RIGHT_TOP,
        imgURL: 'image/wedgets/'
        // allLayer: true
        // size:"normal"
      })
      // 放大、缩小控件配置
      var ctlOpt1 = new esmap.ESControlOptions({
        position: esmap.ESControlPositon.LEFT_TOP, // 位置 左上角
        // 位置x,y的偏移量
        offset: {
          x: 20,
          y: 70
        },
        imgURL: 'image/wedgets/'
      })
			var container = document.getElementById('map-container');
      map = new esmap.ESMap({
        container:container, // 渲染dom
        mapDataSrc: "../data", //地图数据位置
        mapThemeSrc: "../data/theme", //主题数据位置

        focusAlphaMode: false, //对不可见图层启用透明设置 默认为true
        focusAnimateMode: true, //开启聚焦层切换的动画显示
        focusAlpha: 0.9, //对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
        viewModeAnimateMode: true, //开启2维，3维切换的动画显示
        defaultScaleLevel: 3,
        moveToAnimateMode: true //开启moveTo动画效果
      });

      map.openMapById(10005);
      map.showCompass = true; //显示指南针 
      //地图加载完成回调
      map.on('loadComplete', function () {
    		//创建楼层控件
			floorControl = new esmap.ESScrollFloorsControl(map, ctlOpt);

			//单层多层切换按钮
			var toolControl = new esmap.ESToolControl(map);

			var zoomControl = new esmap.ESZoomControl(map, ctlOpt1);
			
        createNavi();
        bingEvents();
      });
      //判断起点是否是同一处坐标
      var lastCoord = null;
      var curfnum = null;
      var h = 1;
      //点击地图事件。开始选点开始后，点击地图一次为起点，第二次点击为终点
      map.on('mapClickNode', function (event) {
        if (event.nodeType == 4) {
          curfnum = event.floor;
          h = 1;
          mapCoord = event.hitCoord;
        }
        if (event.nodeType == 5) {
          curfnum = event.FloorNum;
          h = event.data_.RoomHigh;
          mapCoord = event.hitCoord;
        }
      })
      //为模型填充div添加点击事件
      container.onclick = function () {
        var fnum = curfnum;
        fnum&&mapCoord&&show(fnum, mapCoord);
      };
      container.ontouchend = function(){
        var fnum = curfnum;
        fnum&&mapCoord&&show(fnum, mapCoord);
      }
      show = function (fnum, coord) {
        if (!navi) return;
        if (coord != null) {
          //第三次点击清除路径，重现设置起点起点
          if (clickCount == 2) {
            navi.clearAll();
            clickCount = 0;
            lastCoord = null;
          }

          //第一次点击添加起点
          if (clickCount == 0) {
            lastCoord = coord;
            navi.setStartPoint({
              x: coord.x,
              y: coord.y,
              fnum: fnum,
              height: h,
              url: 'image/start.png',
              size: 64
            });
          } else if (clickCount == 1) { //添加终点并画路线
            //判断起点和终点是否相同
            if (lastCoord.x == coord.x) {
              alert("起点和终点不能相同!,请重新选点")
              return;
            }
            navi.setEndPoint({
              x: coord.x,
              y: coord.y,
              fnum: fnum,
              height: h,
              url: 'image/end.png',
              size: 64
            });
            // 画导航线
            navi.drawNaviLine();
          }
          clickCount++;
        }
        curfnum = null;
      };
      
      <!-- 孔大帅的收缩框  -->
      
      $("#searchText").focus(function(){
          if(finded){
              var result = document.getElementById("shopSearch");
              result.style.display = "block";
          }
      })
      var search = document.getElementById("searchText");
      //联想功能
      search.onkeyup = function () {
          find(this.value);
          if (this.value == "") {
              var result = document.getElementById("shopSearch");
              result.style.display = "none";
              removeMark();
          }
      }

      
      var finded;
      //查询函数
      function find(keyword) {
          var a = {
              nodeType: esmap.ESNodeType.MODEL,
              // nodeType: esmap.ESNodeType.facility,
              keyword: keyword
          };
          esmap.ESMapUtil.search(map, "all", a, function (e) {
              // console.log(e);
              var a = [];
              for (var t = 0; t < e.length; t++) {
                  var n = e[t].name,
                      id = e[t].ID;
                  var floor = map.getFloor(e[t].FloorNum)
                  "poi" !== n &&
                      "洗手间" !== n &&
                      "步行梯" !== n &&
                      "直升电梯" !== n &&
                      "手扶电梯" !== n &&
                      "出入口" !== n &&
                      "停车场入口" !== n &&
                      "财务部" !== n &&
                      "总经理室" !== n &&
                      "无障碍停车位" !== n &&
                      "收银台" !== n &&
                      "办公室" !== n &&
                      "正门广场" !== n &&
                      a.push("<li data-fid=" + e[t].FloorNum + " data-x=" + e[t].mapCoord.x + " data-y=" + e[
                              t].mapCoord.y +
                          '>  <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span><span style="font-size:12px;">' +
                           floor.floorDesc + "</span><span>" + e[t].name + "</span><span>" +
                          id +
                          "</span> </li>")
              }
              if (a.length > 0) {
                  finded = true;
                  var shopSearch = document.getElementById("shopSearch");
                  var ul = shopSearch.getElementsByTagName("ul")[0];
                  ul.innerHTML = a.join("");
                  shopSearch.style.display = "block";

                  var li = ul.getElementsByTagName("li");
                  for (var i = 0; i < li.length; i++) {
                      li[i].addEventListener("click", (function (num) {
                          return function (event) {
                              event.preventDefault();
                              map.moveTo({
                                  x: this.getAttribute("data-x"),
                                  y: this.getAttribute("data-y"),
                                  // z:e.z,
                                  FloorNum: this.getAttribute("data-fid"),
                                  time: 0.5
                              });
                              var floorNum = this.getAttribute("data-fid");
                              // map.scaleLevelTo(1);
                              var btns = document.getElementsByClassName("layer-floors-wrap");
                              for (var j = 0; j < btns.length; j++) {
                                  if (btns[j].getAttribute("data-floornum") == floorNum) {
                                      btns[j].click();
                                  }
                              }
                              if (e[num].nodeType == 5) {
                                  var coordx = e[num].mapCoord.x,
                                      coordy = e[num].mapCoord.y;
                                  addMarker(coordx, coordy, e[num].FloorNum);
                              }
                          }
                      })(i), "false")
                  }
              } else {
                  finded = false;
                  console.log("未匹配")
              }
          })
      }

      function addMarker(x, y, fnum) {
          removeMark();
          locateMarkLayer = new esmap.ESLayer('imageMarker');
          var floor = map.getFloor(fnum)
          im = new esmap.ESImageMarker({
              x: x,
              y: y,
              url: 'image/user.png',
              size: 64,
              id: 1,
              name: 'myMarker',
              callback: function () {
                  im.alwaysShow();
                  jump = im.jump({
                      times: 5,
                      duration: 1,
                      delay: 0.5,
                      height: 2
                  });
              }
              // rotate:1,  //控制标注随着地图旋转。(size需要重新设置)
              // ,zoom:1//控制标注随着地图缩小。
          });

          locateMarkLayer.addMarker(im);
          floor.addLayer(locateMarkLayer);
      }

      function removeMark() {
          if (!locateMarkLayer) return;
          locateMarkLayer.removeAll();
          var fnum = locateMarkLayer.FloorNum;
          map.getFloor(fnum).removeLayer(locateMarkLayer);
          locateMarkLayer = null;
      }

   
      
      
      <!-- 孔大帅的信息框 -->
      
      
  	//地图加载完成事件
  	map.on('loadComplete', function() {
  		var fnum = map.focusFloorNum;
  		var floorLayer = map.getFloor(fnum);
  		var gpos = floorLayer.mapCoord;

  		//添加文本标签图层
  		var layer1 = new esmap.ESLayer("textMarker");
  		var tm = new esmap.ESTextMarker({
  			//x: gpos.x - 30,
  			y : gpos.y - 30,
  			name : "出售胡红旗",
  			fontsize : 34,
  			fillcolor : "72，61，139", //填充色
  			fontsize : "12.0", //字体大小
  			strokecolor : "255,255,0" //边框色
  		});
  		layer1.addMarker(tm);
  		floorLayer.addLayer(layer1);

  		 var results = esmap.ESMapUtil.searchModel({
  	        key:"ID",    
  	        data:[70136]
  	    })
  	    
  	   
  		//改变方块房子颜色,id,name二选择一，都可以是数组, fnum可选择，参数color:'#FF0000'
  	    map.changeModelColor({id:[70136],fnum:[1],color:'#FF0000'}) 
  	
  	});

  	var startPick = true; // 控制是否弹出信息框

  	//点击事件
  	map.on('mapClickNode', function(event) {
  		console.log(event);
  		if (event.nodeType == esmap.ESNodeType.NONE
  				|| event.nodeType == esmap.ESNodeType.FLOOR)
  			return;
  		var model = event;
  		if (!startPick)
  			return;
  		if (event.nodeType != esmap.ESNodeType.MODEL)
  			model.o3d_.flash({
  				scale : 1.3,
  				time : 0.3
  			}); //闪烁
  		var d;
  		switch (event.nodeType) {
  		case esmap.ESNodeType.MODEL:
  			d = {
  				type : event.typeID,
  				ID : event.ID,
  				fnum : event.FloorNum,
  				name : !event.name ? "暂无" : event.name,
  				x : event.label ? event.label.mapCoord.x
  						: event.mapCoord.x,
  				y : event.label ? event.label.mapCoord.y
  						: event.mapCoord.y,
  				z : event.label ? event.label.mapCoord.z
  						: event.mapCoord.z
  			};
  			gui.showModelInfo(d);

  			break; //打开对话框
  		case esmap.ESNodeType.TEXT_MARKER:
  			d = {
  				type : event.nodeType,
  				ID : event.ID,
  				name : !event.name ? "暂无" : event.name,
  				fnum : event.FloorNum,
  				x : event.x,
  				y : event.y,
  				z : event.z
  			};
  			gui.showLabelInfo(d);
  			break; //打开对话框
  		case esmap.ESNodeType.FACILITY:
  		case esmap.ESNodeType.IMAGE_MARKER: {
  			d = {
  				type : event.nodeType,
  				fnum : event.FloorNum,
  				name : !event.name ? "暂无" : event.name,
  				ID : event.ID,
  				x : event.mapCoord.x,
  				y : event.mapCoord.y,
  				z : event.mapCoord.z
  			};
  			gui.showPOIInfo(d);
  		}
  			;
  			break;
  		}
  		map.moveTo(d);
  	});

        //开启点击查询
      $('#btnPick').on('click', function() {
          startPick = true;
      });

      //关闭点击查询
      $('#btnPickend').on('click', function() {
          startPick = false;
          map.selectNull();
      }); 
      
      <!--    -->
      
    };

    function createNavi() {
      if (map.mapService.sourceData.navs.length == 0 || map.mapService.sourceData.navs[0].Nodes.length == 0) {
        console.warn("地图导航数据信息不存在！");
        return;
      }
      if (!navi) {
        //初始化导航对象
        navi = new esmap.ESNavigation({
          map: map,
          locationMarkerUrl: 'image/pointer.png',
          locationMarkerSize: 150,
          speed: 1,
          followAngle: true,
          followPosition: true,
          followGap: 3,
          tiltAngle: 30,
          audioPlay: true,
          // scaleLevel:0,
          mode: 1,
          offsetHeight: 1,
          // 设置导航线的样式
          lineStyle: {
            color: '#58a2e4',
            //设置线为导航线样式
            lineType: esmap.ESLineType.ESARROW,
            // lineType: esmap.ESLineType.FULL,
            lineWidth: 6,
            offsetHeight: 0.5,
            smooth: true,
            seeThrough: false,
            noAnimate: true
            // 设置边线的颜色   
            // godEdgeColor: '#920000',
            // 设置箭头颜色
            // godArrowColor: "#ffffff"
          },
          scaleAnimate: true,
          isMultiFloors: false
        });
      }

      navi.on("walking", function (data) {
        //显示导航展示信息
        showDis(data);
      })

      navi.on("complete", function () {
        console.log("停止");
        document.getElementById('description').innerText = "到达终点";
      })
    }

    function clearNavi() {
      if (navi)
        navi.clearAll();
      clickCount = 0;
      document.getElementById("description").innerText = "暂无导航提示信息";
    }

    function startNavi1() {
      navi.followAngle = true;
      navi.followPosition = true;
      navi.scaleAnimate = true;
      if(navi.isSimulating){
        navi.stop();
        navi.reset();
      }
      navi.simulate();
    }
    function startNavi2() {
      if(navi.isSimulating){
        navi.stop();
        navi.reset();
      }
      navi.followAngle = false;
      navi.followPosition = false;
      navi.scaleAnimate = false;
      navi.simulate();
    }
    
    //绑定事件
    function bingEvents() {
      // 2维显示事件
      document.getElementById('btn2D').onclick = function () {
        map.viewMode = esmap.ESViewMode.MODE_2D; // 2维模式
      };

      // // 3维显示事件
      document.getElementById('btn3D').onclick = function () {
        map.viewMode = esmap.ESViewMode.MODE_3D;; // 3维模式
      };
    }
    //显示路径数据
    function showDis(data) {
      //距终点的距离
      var distance = data.remain;
      //路线提示信息
      var info = navi.naviDescriptions[data.index];
      var f = info[0] + parseInt(data.distanceToNext) + info[2];
      //普通人每分钟走80米。
      var time = distance / 80;
      var m = parseInt(time);
      var s = Math.floor((time % 1) * 60);
      document.getElementById('description').innerHTML = '<p>距终点：' + distance.toFixed(1) + ' 米</p><p>大约需要：  ' + m + '  分钟   ' + s +
        '   秒</p><p>路线提示：' + f + ' </p>';
    };
    
 
    function hidde(){
        var result = document.getElementById("shopSearch");
            result.style.display = "none";
       /*      if (!startNavi) return;
            var fnum = curfnum;
            if (!fnum) return;
            //获取地图视图的边框
            show(fnum, mapCoord); */
    }
    
  </script>
</body>

</html>
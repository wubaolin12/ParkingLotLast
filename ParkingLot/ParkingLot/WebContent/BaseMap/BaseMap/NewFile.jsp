<%@ page language="java" contentType="text/html; charset=utf-8"%>


<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="UTF-8">
    <title>室内地图基本信息查询示例|室内地图三维地图引擎|易景空间地图</title>
    <meta name="keywords" content="室内地图基本查询示例,室内地图,三维地图引擎,三维地图制作,室内定位,易景空间地图" />
    <meta name="description" content="室内地图基本查询示例,易景室内三维地图引擎提供地图浏览、缩放、旋转、图层显隐等基础功能，支持自定义室内地图显示风格及样式，可自动绘制楼层热力图、散点图等专题地图，快速进行空间大数据分析展示。支持跨楼层精准的点到点之间的最短、最优路径计算，支持对路径结果进行导航和动画,并提供丰富的地图主题资源供二次开发调用。" />
    <link rel="shortcut icon" type="image/ico" href="../image/favicon.ico">
    <link href="../lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/iconfont/iconfont.css" rel="stylesheet">
    <style type="text/css">
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
    </style>
</head>

<body>
    <div id="map-container"></div>
    <div class="loading">
        <div class="lodingImg"></div>
    </div>

    <nav class="navbar navbar-inverse">
        <h1><a href="/" title="室内地图-室内三维地图" target="_blank">易景室内三维地图引擎</a> （基本信息查询示例）</h1>
        
        <div class="tips-right">
                <span class="tip1"></span>
                <span class="tip2"></span>
            </div>
            <div class="tips-msg">
                <div class="msg msg1">
                    <div class="erweima"></div>
                    <p>手机扫一扫进入体验</p>
                </div>
                <div class="msg msg2">
                    <h4>基本信息查询示例</h4>
                    <p>1. 根据关键字搜索店铺/地点</p>
    
                    <div style="display: none">室内地图基本查询示例,易景室内三维地图引擎提供地图浏览、缩放、旋转、图层显隐等基础功能，支持自定义室内地图显示风格及样式，可自动绘制楼层热力图、散点图等专题地图，快速进行空间大数据分析展示。支持跨楼层精准的点到点之间的最短、最优路径计算，支持对路径结果进行导航和动画,并提供丰富的地图主题资源供二次开发调用。</div>
                </div>
            </div>
    </nav>

    <!-- 搜索 -->
    <div class="search">
        <span id="btnSearch" class="glyphicon glyphicon-search" aria-hidden="true"></span>
        <input id="searchText" type="text" class="searchText" placeholder="搜索关键字"> |
        <button type="button" id="startnav" class="btn btn-default" style="border: none">
            <span id="btnNav" class="glyphicon glyphicon-map-marker"></span>
            导航
        </button>
    </div>

    <!-- 查询显示列表 -->
    <div id="shopSearch" class="layer list">
        <ul>
        </ul>
    </div>

    <!--  导航选点 -->
    <div id="router" class="layer router">
        <div class="routerInput">
            <span class="glyphicon glyphicon-flag"></span>
            <input id="startText" class="routerText" type="" name="" placeholder="点击地图可选择起点" readonly>
        </div>
        <div class="routerInput">
            <span class="glyphicon glyphicon-flag"></span>
            <input id="endText" class="routerText" type="" name="" placeholder="点击地图可选择终点" readonly>
        </div>
        <div id="navigation" class="navigation">
            <button type="button" id="navTo" class="btn btn-default">
                <span class="glyphicon glyphicon-share-alt"></span>
                导航
            </button>
        </div>
    </div>

    <div id="dlgModelInfo" class="modal fade">
        <div class="modal-dialog bottom">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3">地址</div>
                            <div class="col-md-9" id="address"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">营业时间</div>
                            <div class="col-md-9" id="businesshour"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <script src="../lib/config.js"></script>
    <script src="../lib/esmap.min.js"></script>
    <script src="../lib/jquery-2.1.4.min.js"></script>
    <script src="../lib/jquery.qrcode.min.js"></script>
    <script src="../lib/tips_controls.js"></script>
    <script src="../lib/bootstrap.min.js"></script>

    <script type="text/javascript">
        var map; //定义全局map变量
        var startNavi = false;
        var esmapID = getQueryString('id') || defaultOpt.mapID;
        var styleid = getQueryString("styleid") || defaultOpt.themeID;
        var locateMarkLayer = null;
        var lineStyle = { // 配置线
            color: '#f40000',
            lineWidth: 8,
            alpha: 1.0,
            dash: {
                size: 1,
                gap: 1 //0：双向，实线。    1：单向，虚线。
            }
        }
        // 点击计数
        var clickCount = 0;
        var lastCoord = null;
        var curfnum = null;
        var navi = null;
        var mapCoord = null;
        var h = 1;
        $(function () {
            //楼层控制控件配置参数
            var ctlOpt = new esmap.ESControlOptions({
                position: esmap.ESControlPositon.RIGHT_TOP,
                imgURL: "image/wedgets/"
            });
            //放大、缩小控件配置
            var ctlOpt1 = new esmap.ESControlOptions({
                position: esmap.ESControlPositon.LEFT_TOP, //位置 左上角
                //位置x,y的偏移量
                offset: {
                    x: 20,
                    y: 80
                },
                imgURL: "image/wedgets/"
            });
            var floorControl;
            map = new esmap.ESMap({
                container: $('#map-container')[0], //渲染dom
                mapDataSrc: defaultOpt.mapDataUrl, //地图数据位置
                mapThemeSrc: defaultOpt.mapThemeUrl, // 主题数据位置
                themeID: styleid,
                focusAlphaMode: false, //对不可见图层启用透明设置 默认为true
                focusAnimateMode: true, //开启聚焦层切换的动画显示
                focusAlpha: 0.9, //对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
                viewModeAnimateMode: true, //开启2维，3维切换的动画显示
                defaultScaleLevel: 3,
                moveToAnimateMode: true //开启moveTo动画效果
            });
            //打开地图数据
            map.openMapById(esmapID); //sceneId
            map.on('loadComplete', function () {
                //创建楼层，放大、缩小控件
                floorControl = new esmap.ESScrollFloorsControl(map, ctlOpt);
                var zoomControl = new esmap.ESZoomControl(map, ctlOpt1);
            });

            //显示指南针
            map.showCompass = true;
            map.on("mapClickNode", function (e) {
                mapCoord = e.hitCoord
                if (e.nodeType == 4) {
                    curfnum = e.floor;
                    h = 1;
                }
                if (e.nodeType == 5 && startNavi == true) {
                    h = e.data_.RoomHigh;
                    curfnum = e.FloorNum;
                    var starter = document.getElementById("startText");
                    var ender = document.getElementById("endText");
                    if (clickCount == 0) {
                        starter.value = e.name;
                    } else if (clickCount == 1) {
                        ender.value = e.name;
                    } else {
                        starter.value = e.name;
                        ender.value = '';
                    }

                }
            })
            //为模型填充div添加点击事件
            $('#map-container')[0].onclick = onclick;
            $('#map-container')[0].ontouchend = onclick;
            $("#navTo").click(function () {
                //导航开始
                if (navi) {
                    navi.simulate();
                    navi.on("walking", function () {
                        console.log("导航进行中")
                    })
                }
            })
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
            //导航选点
            var startnav = document.getElementById("startnav");
            startnav.onclick = function () {
                startNavi = !startNavi;
                if (startNavi) {
                    var router = document.getElementById("router");
                    router.style.display = "block";
                    createNavi();
                } else {
                    var router = document.getElementById("router");
                    router.style.display = "none";
                    document.getElementById("startText").value = '';
                    document.getElementById("endText").value = '';
                    if (navi)
                        navi.clearAll();
                }
            }
        })

        show = function (fnum, coord) {
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
                        height:h,
                        fnum: fnum,
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
                        height:h,
                        fnum: fnum,
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
        function clearResults(){

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

        function createNavi() {
            if (!map.mapService.sourceData.navs || map.mapService.sourceData.navs[0].Nodes.length == 0) {
                alert("地图导航数据信息不存在！");
                var router = document.getElementById("router");
                router.style.display = "none";
                return;
            }
            if (!navi) {
                navi = new esmap.ESNavigation({
                    map: map,
                    locationMarkerUrl: 'image/pointer.png',
                    locationMarkerSize: 150,
                    speed: 1,
                    followAngle: true,
                    followPosition:true,
                    followGap:3,
                    tiltAngle: 30,
                    scaleLevel: 0,
                    // 设置导航线的样式
                    lineStyle: {
                        color: '#33cc61',
                        //设置线为导航线样式
                        lineType: esmap.ESLineType.ESARROW,
                        lineWidth: 6,
                        //设置边线的颜色   
                        godEdgeColor: '#920000',
                        //设置箭头颜色
                        godArrowColor: "#ff0000"
                    }
                });
            }
        }
        function onclick(){
            var result = document.getElementById("shopSearch");
                result.style.display = "none";
                if (!startNavi) return;
                var fnum = curfnum;
                if (!fnum) return;
                //获取地图视图的边框
                show(fnum, mapCoord);
        }
    </script>
</body>

</html>
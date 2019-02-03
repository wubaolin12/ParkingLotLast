<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path=request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+request.getContextPath()+"/";
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>停车场车辆查看</title>
<link href="${path}/static/lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		车辆管理 <span class="c-gray en">&gt;</span> 停车场车辆查看 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	
	<!-- 上传图片 -->
	<c:import url="test-upload.jsp"></c:import>
	
	<!-- 显示停车场车辆情况 -->
	<div id="parklist" class="page-container">
		<div class="text-c"> 
			
			<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">车位区号：</label>
		
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="p_fore" size="1" id="p_fore">
				<option value="所有">所有</option>
				<c:forEach items="${pForeList}" var="d" varStatus="dd">
				<option value="${d.p_fore}">${d.p_fore}区</option>
				</c:forEach>
			</select>
			</span> </div>
		</div>
		
		
			
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">维护状态：</label>
		
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="p_state" size="1" id="p_state">
				<option value="所有">所有</option>
				<option value="开放">开放</option>
				<option value="维护">维护</option>
			</select>
			</span> </div>
		</div>
		<div>
		<label class="form-label col-xs-4 col-sm-3">车牌号：</label>
		
		<input type="text" class="input-text" style="width: 250px"
				placeholder="只输入一个x 视为空车牌" id="c_num" name="c_num"></div>
			<div>		
		<label class="form-label col-xs-4 col-sm-3">车位号：</label>
		
		<input type="text" class="input-text" style="width: 250px"
				placeholder="输入车位号(纯数字)" id="p_num" name="p_num"></div>
			<div align="right">
				<button type="submit" class="btn btn-success radius" id="findPark" name="findPark" onclick="findPark()">
					
					<i class="Hui-iconfont">&#xe665;</i> 搜车位
				</button>
			</div>
			<br/>
			
		</div>
		
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="91">车位ID</th>
						<th width="102">车位状态</th>
						<th width="101">车辆车牌号</th>
						<th width="102">车位区号</th>
						<th width="150">车位号</th>
						<th width="149">维护状态</th>
						<th width="314">选项</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${parkList}" var="c" varStatus="cc">
						<tr class="text-c">
						
							<td>${c.p_id}</td>
							<td>${c.param.pm_name}</td>
							<td>
								<c:if test="${ c.car==null}"></c:if>
							    <c:if test="${ c.car!=null}">${c.car.c_num}</c:if></td>
							<td>${c.p_fore}</td>
							<td>${c.p_num}</td>
							<td>${c.p_state}</td>
							<td>
							<a href="/picture/${c.p_imgpath}" data-lightbox="gallery" 
								data-title="车牌：${c.car.c_num}<br/>车位：${c.p_fore}${c.p_num}">
							查看图片</a>
							<a href="javascript:upload('${c.p_id}','${c.p_fore}','${c.p_num}')">上传图片</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${path}/static/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${path}/static/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/lib/laypage/1.2/laypage.js"></script>
	
<script type="text/javascript" src="${path}/static/lib/lightbox2/2.8.1/js/lightbox.min.js"></script> 
	<script type="text/javascript">
	
		/*-显示上传图片-*/
		function upload(pid,pfore,pnum){
			document.getElementById("parkLocal").innerHTML=pfore+pnum;
			document.getElementById("parklist").style.display="none";
			document.getElementById("img-upload").style.display="block";
			document.getElementById("p_id").value=pid;
		}
	
		$(function() {
			$('.table-sort').dataTable({
				"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
				"bStateSave" : true,//状态保存
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : []
				} // 制定列不参与排序
				]
			});

		});
		/*用户-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-查看*/
		function member_show(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-停用*/
		function member_stop(obj, id) {
			layer
					.confirm(
							'确认要停用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-defaunt radius">已停用</span>');
												$(obj).remove();
												layer.msg('已停用!', {
													icon : 5,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}

		/*用户-启用*/
		function member_start(obj, id) {
			layer
					.confirm(
							'确认要启用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-success radius">已启用</span>');
												$(obj).remove();
												layer.msg('已启用!', {
													icon : 6,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}
		/*用户-编辑*/
		function member_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*密码-修改*/
		function change_password(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '',
					dataType : 'json',
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
		
		function findPark(){
			var p_stateV=document.getElementById("p_state").value;
			var p_foreV=document.getElementById("p_fore").value;
			var p_numV=document.getElementById("p_num").value;
			var c_numV=document.getElementById("c_num").value;
			
			if(p_numV==''){
				p_numV=parseInt('0');
			}
			location.href='<%=path%>ParkView/findPark.action?p_num='+p_numV+
					'&p_fore='+p_foreV+'&p_state='+p_stateV+'&c_num='+c_numV;
		}
		
		
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  

<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<%-- 	<div class="text-c"> 日期范围：
	<form action="<%=basePath %>emp/seachUser.action?currentpage=${pageel.currentpage}">
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名称/用户Id/电话" id="" name="searchword">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</form>
	</div> --%>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
	<a href="javascript:;" onclick="member_add('添加用户','addEmpPage.action','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> 
	<span class="r">共有数据：<strong>${pageel.cordnum}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="30">ID</th>
				<th width="50">用户名</th>
				 <th width="40">性别</th>
				<th width="70">手机</th>
				<th width="50">状态</th>
				<th width="50">角色</th>
				<th width="80">操作</th>
			</tr>
		</thead>
		<tbody>
		<%-- ------${ulist}-----${currentpage} --%>
		<c:forEach items="${ulist}" var="ul" varStatus="uu">
			<tr class="text-c" id="${ul.user.u_id}">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${ul.user.u_id}</td>
				<td class="u_name"><u style="cursor:pointer" class="text-primary" >${ul.user.u_name}</u></td>
				<td class="u_sex">${ul.user.u_sex}</td>
				<td class="u_phone">${ul.user.u_phone}</td>
				<td class="td-status"><span class="label label-success radius">${ul.param.pm_name}</span></td>
				<td class="role_id">${ul.role.role_name}</td>
				<td class="td-manage">
				<c:if test="${ul.param.pm_name=='启用'}">
				<a style="text-decoration:none" onClick="member_stop(this,'${ul.user.u_id}','${pageel.currentpage}')" href="javascript:;" title="禁用"><i class="Hui-iconfont">&#xe631;</i></a> 
				</c:if>
				<c:if test="${ul.param.pm_name=='禁用'}">
				<a style="text-decoration:none" onClick="member_start(this,'${ul.user.u_id}','${pageel.currentpage}')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a> 
				</c:if>
				<a title="重置密码" href="javascript:;" onclick="member_resetpwd(this,'${ul.user.u_id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
				<a style="text-decoration:none" class="ml-5" onclick="admin_edit('菜单编辑','toUpadatePage.action?u_id=${ul.user.u_id}','${ul.user.u_id}','800','500')" title="修改">修改</a>
				<a title="删除" href="javascript:;" onclick="member_del(this,'${ul.user.u_id}','${pageel.currentpage}')" class="ml-5" >删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>

<div style="  width:100%; height:30px;text-align: center;0 " >
	<a  href="<%=basePath %>emp/prev.action?currentpage=${pageel.currentpage}" onclick="return checkPage()">上一页</a>
	<input type="hidden"  name="currentpage" id="currentpage"  >${pageel.currentpage}
	/<input type="hidden" name="totalpage" id="totalpage"  >${pageel.totalpage}
	<a  href="<%=basePath %>emp/next.action?currentpage=${pageel.currentpage}" onclick="return checkNextPage()">下一页</a>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath %>static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath %>static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath %>static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath %>static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}


/*用户-重置密码*/
function member_resetpwd(obj,id){

	layer.confirm('确认重置密码？',function(index){
		$.ajax({
			type: 'POST',
			url: '<%=basePath %>emp/resetPwd.action',
			dataType: 'text',
			data :"u_id="+id,
			success: function(data){
				layer.close(layer.index);
				alert('重置密码成功！');
				
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-停用*/
function member_stop(obj,id,page){
	
	var pnum=page;
	
	layer.confirm('确认要禁用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '<%=basePath %>emp/userOff.action',
			dataType: 'text',
			data :"u_id="+id,
			success: function(data){
		
				location.href="<%=basePath %>emp/refreshUlist.action?currentpage="+pnum+"&u_id="+id
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id,page){
	
	var pnum=page;
	alert(pnum);
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '<%=basePath %>emp/userOn.action',
			dataType: 'text',
			data :"u_id="+id,
			success: function(data){

				location.href="<%=basePath %>emp/refreshUlist.action?currentpage="+pnum+"&u_id="+id
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*用户-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id,page){
	var pnum=page;
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '<%=basePath %>emp/delUser.action',
			dataType: 'text',
			data :"u_id="+id,
			success: function(data){
/* 				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000}); */
				location.href="<%=basePath %>emp/refreshUlist.action?currentpage="+pnum+"&u_id="+id

			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script> 
</body>
</html>
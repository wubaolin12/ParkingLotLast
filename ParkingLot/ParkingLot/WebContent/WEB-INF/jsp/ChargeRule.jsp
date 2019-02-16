<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${path}/static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${path}/static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${path}/static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>收费规则管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 收支管理 <span class="c-gray en">&gt;</span> 收费规则设置 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<!-- 	<div class="text-c"> 日期范围： -->
<!-- 		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class=" " style="width:120px;"> -->
<!-- 		- -->
<!-- 		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;"> -->
<!-- 		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name=""> -->
<!-- 		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button> -->
<!-- 	</div> -->
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="member_add('修改计费规则 ','${path}/ChargeRule/jumpAdd.action','','650')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 新规则添加</a>  <a href="javascript:;" onclick="member_add('修改计费规则 ','${path}/ChargeRule/jumpUpdate.action','','650')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 修改计费规则</a>   </span>  

	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="150">规则类型ID</th>
				<th width="150">开始时间</th>
				<th width="150">结束时间</th>
				<th width="150">起步价</th>
				<th width="150">自增价格</th>
				<th width="70">操作点击</th>
<!-- 				<th width="100">操作</th> -->
			</tr>
		</thead>
		<tbody>
			
			 <c:forEach items="${ruleList}" var="rule" >
			<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${rule.crpm_id}</td>
				<td>${rule.cr_starttime}</td>
				<td>${rule.cr_overtime}</td>
				<td>${rule.cr_fristmoney}</td>
				<td>${rule.cr_addmoney}</td>
				
				<c:if test="${rule.pm_id==11}">
				<td class="td-status"><span class="label label-success radius" onclick="change()">已启用</span></td>
				</c:if>
				
				<c:if test="${rule.pm_id==10}">
				<td class="td-status">
				<span class="label label-failed radius" onclick="changeState('${rule.crpm_id}',10,'确认启用吗？ ')">未启用</span>
				</td>
				</c:if>
		
<!-- 				<td class="td-manage"> <a style="text-decoration:none" onClick="member_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td> -->
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${path}/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">



function change(){
	alert("方案已启用！")
}

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
//规则状态修改 
function changeState(cr_id,pm_id,talk){
	
	layer.confirm(talk,function(index){

		$.ajax({
			type: 'POST',
			url: '${path}/ChargeRule/changeState.action',
			dataType: 'text',
			data: {
				"cr_id":cr_id,
				"pm_id":pm_id
			},
			success: function(data){
// 				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
// 				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
// 				$(obj).remove();
				layer.msg('已启用',{icon: 6,time:1000});
                location.href="${path}/ChargeRule/jumpshow.action"
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
// function member_start(obj,id){
// 	layer.confirm('确认要启用吗？',function(index){
// 		$.ajax({
// 			type: 'POST',
// 			url: '',
// 			dataType: 'json',
// 			success: function(data){
// 				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
// 				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
// 				$(obj).remove();
// 				layer.msg('已启用!',{icon: 6,time:1000});
// 			},
// 			error:function(data) {
// 				console.log(data.msg);
// 			},
// 		});
// 	});
// }
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
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
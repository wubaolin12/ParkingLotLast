<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

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
<link rel="stylesheet" type="text/css" href="${path}/static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加新规则方案</title>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-user-add">
		<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> 
	<span class="l"> 
<!-- 	<a href="javascript:;" onclick="selectA()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> A规则</a>  --> 
<!-- 		<input type="text" id = "planName" name = "planName" placeholder="请输入新方案名"> -->
<!-- 		<a class="btn btn-primary radius" href="javascript:;" onclick="getRuleData()"><i class="Hui-iconfont">&#xe600;</i>添加新方案名</a> </span>  </div> -->
	
	
	
		<div class="cl pd-5 bg-1 bk-gray"> 
	<span class="l"> 
<!-- 	<a href="javascript:;" onclick="selectA()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> A规则</a>  --> 
		
		
		<select id = "select" name="select"> 
		<c:forEach items="${ruleSelect}" var="r">
		<option value="${r.pm_id}">${r.pm_name} </option> 
		
		</c:forEach>
		</select>  
		
		
		<a class="btn btn-primary radius" href="javascript:;" onclick="getRuleData()"><i class="Hui-iconfont">&#xe600;</i>选择方案添加规则</a> </span>  </div>
	
	
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>

			
			<tr>
				<th scope="col" colspan="6">计费规则添加</th>
			</tr>
			<tr class="text-c">
				<th width="25">操作</th>
				<th width="40">方案规则</th>
				<th width="100">开始时间</th>
				<th width="100">结束时间</th>
				<th width="100">起步价</th>
				<th width="100">自增价格</th>
			</tr>
		</thead>
		<tbody id="tbody1">
			<tr class="text-c">
				<td><input type="button" value="添加"  id = "add" name="add" onclick="addNewRule()"  ></td>
				<td><input type="hidden" id = "pam"  value="${value}" name="">${text}</td>
				<td><input type="text"   id = "start"  value="" name="startTime"></td>
				<td><input type="text"   id = "over"  value="" name="overTime"></td>
				<td><input type="text"   id = "startPrice"  value="" name="startPrice"></td>
				<td class="f-14"><input  id = "addPrice" type="text" value="" name="addPrice"></td>
			</tr>			
		</tbody>
		
	</table>
</div>

<!-- 	<div class="row cl"> -->
<!-- 		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3"> -->
<!-- 			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;修改规则&nbsp;&nbsp;"> -->
<!-- 		</div> -->
<!-- 	</div> -->
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">

function addNewRule(){
	
	var pam = document.getElementById("pam").value;
	
	if(pam == ""){
		alert("请先选择方案再添加规则！");
	}else{
	var start = document.getElementById("start").value;

	var over = document.getElementById("over").value;

	var startPrice = document.getElementById("startPrice").value;

	var addPrice = document.getElementById("addPrice").value;
	
	$.ajax({
		url:"${path}/ChargeRule/addNewRule.action",
		type: "post",
		dataType:"text",
		data:{"pam":pam,
			"start":start,
			"over":over,
			"startPrice":startPrice,
			"addPrice":addPrice		
		},
		success:function(result){
	
			if(result == "true"){
				alert("添加成功");
				window.parent.location.reload(); //刷新父页面
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				parent.layer.close(index);  // 关闭layer
				
			}else{
				alert("错误！")
			}
			
		}
	})
	
	}
	
	
}


function getRuleData(){

	var myselect=document.getElementById("select");
	
	var index=myselect.selectedIndex ;
	//方案规则参数id 
	var value = myselect.options[index].value;
	//方案规则名
	var text = myselect.options[index].text;
	
	window.location.href="${path}/ChargeRule/planNameAdd.action?value="+value+"&text="+text;
}


// function getRuleData(){

	
// 	var myselect=document.getElementById("select");
	
// 	var index=myselect.selectedIndex ;
// 	//方案规则参数id 
// 	var value = myselect.options[index].value;
// 	//方案规则名
// 	var text = myselect.options[index].text;
	
// 	alert(value);
	
// 	alert(text);
		
// 		$.ajax({
// 		url :"${path}/ChargeRule/planNameAdd.action",
// 		type : "post",
// 		dataType : "text",
// 		data : "planName=" + planName,
// 		success : function(redata) {
		
// 			alert(redata);
// // 			$("#tbody").empty();
// // 			var str = "";
// // 			for (var i = 0; i < redata.length; i++) {
// // 				var trobj = document.createElement("tr");
// // 				str = 
// // 					  "<td><input type='text' value='"+redata[i].cr_id+"' name=''></td>"+
// // 					  "<td><input type='text' value='"+redata[i].cr_starttime+"' name=''></td>"+
// // 					  "<td><input type='text' value='"+redata[i].cr_overtime+"' name=''></td>"+
// // 					  "<td><input type='text' value='"+redata[i].cr_fristmoney+"' name=''></td>"+
// // 					  "<td><input type='text' value='"+redata[i].cr_addmoney+"' name=''></td>"+	
					  
// // 					  '<td><input type="button" value="确认修改" name=""></td>'+
// // 					  '<td><input type="text" value="'+redata[i].cr_id+'" name=""></td>'+
// // 					  '<td><input type="text" value="'+redata[i].cr_starttime+'" name=""></td>'+
// // 					  '<td><input type="text" value="'+redata[i].cr_overtime+'" name=""></td>'+
// // 					  '<td><input type="text" value="'+redata[i].cr_fristmoney+'" name=""></td>'+
// // 					  '<td><input type="text" value="'+redata[i].cr_addmoney+'" name=""></td>';

// // 						trobj.innerHTML(str);
						
// // 						trobj.innerHTML = str ;
						
// // 						$("#tbody").append(trobj);
// // 					}
// 				},
// 				error : function() {
// 					alert("ajax出错");
// 				}
// 			});
// }




</script>
</body>
</html>
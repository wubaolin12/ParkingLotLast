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
<title>添加产品分类</title>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-user-add">
		<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> 
	<span class="l"> 
<!-- 	<a href="javascript:;" onclick="selectA()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> A规则</a>  -->
		<select id = "select"> 
		<c:forEach items="${ruleSelect}" var="r">
		<option value="${r.pm_id}">${r.pm_name} </option> 
		</c:forEach>
		</select>  
		<a class="btn btn-primary radius" href="javascript:;" onclick="getRuleData()"><i class="Hui-iconfont">&#xe600;</i>选择计费规则</a> </span>  </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">计费规则设置</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="40">规则id</th>
				<th width="100">开始时间</th>
				<th width="100">结束时间</th>
				<th width="100">起步价</th>
				<th width="100">自增价格</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<tr class="text-c">
				<td></td>
				<td></td>
				<td><input type="text" value="" name=""></td>
				<td><input type="text" value="" name=""></td>
				<td><input type="text" value="" name=""></td>
				<td class="f-14"><input type="text" value="" name=""></td>
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



function getRuleData(){
	var select = document.getElementById("select").value;	
	var tr ;
	var cr_id ;
	var cr_starttime ;
	var cr_overtime ;
	var cr_fristmoney ;
	var cr_addmoney ;
		$.ajax({
		url :"${path}/ChargeRule/ruleData.action",
		type : "post",
		dataType : "json",
		data : "select=" + select,
		success : function(redata) {
		
// 			var data = redata.list;

// 			var page = redata.page;
// 			document.getElementById("pagenow").value = page;
			
			$("#tbody").empty();
			var str = "";
			for (var i = 0; i < redata.length; i++) {
				var trobj = document.createElement("tr");
				trobj.id="tr"+i;
				str = 
// 					  "<td><input type='text' value='"+redata[i].cr_id+"' name=''></td>"+
// 					  "<td><input type='text' value='"+redata[i].cr_starttime+"' name=''></td>"+
// 					  "<td><input type='text' value='"+redata[i].cr_overtime+"' name=''></td>"+
// 					  "<td><input type='text' value='"+redata[i].cr_fristmoney+"' name=''></td>"+
// 					  "<td><input type='text' value='"+redata[i].cr_addmoney+"' name=''></td>"+	
					  
					 // '<td><input type="button" value="确认修改" name="" onclick="updateRule(\''+this.cr_id+'\',\''+this.cr_starttime+'\',\''+this.cr_overtime+'\',\''+this.cr_fristmoney+'\',\''+this.cr_addmoney+'\')"></td>'+
					  '<td><input type="button" value="确认修改" name="" onclick="updateRule2(this)"></td>'+

					  // 					  '<td><input type="text" value="'+redata[i].cr_id+'" name="" id="cr_id"></td>'+
					  
					  '<td>'+redata[i].cr_id+'</td>'+					  
					  '<td><input type="text" value="'+redata[i].cr_starttime+'" name="" onchange="valuechage(this)"></td>'+
					  '<td><input type="text" value="'+redata[i].cr_overtime+'" name="" onchange=""></td>'+
					  '<td><input type="text" value="'+redata[i].cr_fristmoney+'" name="" onchange="valuechage(this)"></td>'+
					  '<td><input type="text" value="'+redata[i].cr_addmoney+'" name="" onchange="valuechage(this)"></td>';

// 						trobj.innerHTML(str);
						trobj.innerHTML = str ;
						
						$("#tbody").append(trobj);
					}
				},
				error : function() {
					alert("ajax出错");
				}
			});
}


function valuechage(component){
	var tr = component.parentNode.parentNode;
	 cr_id = tr.childNodes[1].firstChild.value;
	 cr_starttime = tr.childNodes[2].firstChild.value;
	 cr_overtime = tr.childNodes[3].firstChild.value;
	 cr_fristmoney = tr.childNodes[4].firstChild.value;
	 cr_addmoney =tr.childNodes[5].firstChild.value;
	
}

// function test(obj){
// 	alert(obj);
// // 	var test =obj.parentNode.parentNode.html();
// 	alert("dsds"+obj.parentNode)
// 	var tr =obj.parentNode;
// 	var ss=$(tr).find("input [name='cr_starttime']").val();
// 	alert(ss);
//  	p =u.find("input[name=cr_starttime]");
// 	 m=m.val();
// 	alert("dsds"+u)
// 	alert("dsds"+p)
// 	alert("dsds"+m)

	
// }


function updateRule(cr_id,cr_starttime,cr_overtime,cr_fristmoney,cr_addmoney){

// 	var test =obj.parentNode.parentNode.html();
	$.ajax({
		url :"${path}/ChargeRule/updateRule.action",
		type : "post",
		dataType : "text",
		data :{
			"cr_id":cr_id,
			"cr_starttime":cr_starttime,
			"cr_overtime":cr_overtime,
			"cr_fristmoney":cr_fristmoney,
			"cr_addmoney":cr_addmoney
		},
		success : function(redata) {
				alert(redata);

				},
				error : function() {
					alert("ajax出错");
				}
			});


}
function updateRule2(component){
	var tr = component.parentNode.parentNode;
	 cr_id = tr.childNodes[1].innerText;
	 cr_starttime = tr.childNodes[2].firstChild.value;
	 cr_overtime = tr.childNodes[3].firstChild.value;
	 cr_fristmoney = tr.childNodes[4].firstChild.value;
	 cr_addmoney =tr.childNodes[5].firstChild.value;
// 	var test =obj.parentNode.parentNode.html();
	$.ajax({
		url :"${path}/ChargeRule/updateRule.action",
		type : "post",
		dataType : "text",
		data :{
			"cr_id":cr_id,
			"cr_starttime":cr_starttime,
			"cr_overtime":cr_overtime,
			"cr_fristmoney":cr_fristmoney,
			"cr_addmoney":cr_addmoney
		},
		success : function(redata) {
				alert(redata);

				},
				error : function() {
					alert("ajax出错");
				}
			});


}
</script>
</body>
</html>
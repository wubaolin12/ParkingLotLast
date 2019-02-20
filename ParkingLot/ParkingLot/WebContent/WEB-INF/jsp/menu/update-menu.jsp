<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
<title>修改菜单</title>
<link href="${path}/static/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<form  id="form-article-add" action="updateMenu.action?menu_id=${menuObject.menu_id}" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="display: none;" id="menu_id" value="${menuObject.menu_id}"><input type="text" class="input-text" value="${menuObject.menu_name}" placeholder="" id="menu_name" name="menu_name">
			</div>
		</div>

	<div class="row cl" style="height: 20px"></div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单路径：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${menuObject.menu_link}" placeholder="" id="menu_link" name="menu_link">
			</div>
		</div>
		
		<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级菜单：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" class="input-text" value="${menuObject.fmenu.menu_name}" placeholder="" id="menu_pid" name="menu_pid"> --%>
				<select id="menu_pid" name="menu_pid">
					<option value="${menuObject.fmenu.menu_id}">${menuObject.fmenu.menu_name}</option>
					<c:forEach items="${fmlist}" varStatus="ff" var="fl">
						<option value="${fl.menu_id}">${fl.menu_name}</option>
					</c:forEach>
					<option value="0">系统</option>
				</select>
			</div>
		</div>
	<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="bt1" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交修改</button>
<!-- 				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
 -->				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${path}/static/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="${path}/static/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">
function article_save(){
	alert("刷新父级的时候会自动关闭弹层。")
	window.parent.location.reload();
}

$('#bt1').on('click', function(){
	/* alert(11111); */
	var index = parent.layer.getFrameIndex(window.name); 
  	var menu_name=document.getElementById("menu_name").value;
	var menu_link=document.getElementById("menu_link").value;
  	var menu_pid=document.getElementById("menu_pid").value;
  	var menu_id=document.getElementById("menu_id").value; 	
  	
	var utr="#"+menu_id;

	if(menu_name!=''&&menu_name!=null&&menu_link!=''&&menu_link!=null&&menu_pid!=''&&menu_pid!=null){
		
	    $.ajax({
			url :"updateMenuAjax.action" ,
			type :"post",
			dataType:"json", 
			data :{"menu_name":menu_name,"menu_link":menu_link,"menu_pid":menu_pid,"menu_id":menu_id},
			success:function(redata){
	/* 			alert(redata.co_price); */	
				parent.$(utr).find(".menu_name").empty();
				parent.$(utr).find(".menu_name").prepend(redata.menu_name);
				parent.$(utr).find(".menu_link").empty();
				parent.$(utr).find(".menu_link").prepend(redata.menu_link);
				parent.$(utr).find(".menu_pid").empty();
				parent.$(utr).find(".menu_pid").prepend(redata.fmenu.menu_name);
				parent.layer.close(index);
			}
		});

	}else{
		alert("请填入数据");
	}
});


</script>
</body>
</html>
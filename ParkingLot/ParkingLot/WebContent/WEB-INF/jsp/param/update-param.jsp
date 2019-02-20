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
<title>更改参数</title>
<link href="${path}/static/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<form  id="form-article-add" action="updatePram.action?pm_id=${paramObject.pm_id}" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>参数名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" style="display: none;" id="pm_id" value="${paramObject.pm_id}"><input type="text" class="input-text" value="${paramObject.pm_name}" placeholder="" id="pm_name" name="pm_name">
			</div>
		</div>

	<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>参数类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${paramObject.pm_type}" placeholder="" id="pm_type" name="pm_type">
			</div>
		</div>
		


			<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="bt1" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
<!-- 				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> -->
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
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
  	var pm_name=document.getElementById("pm_name").value;
	var pm_type=document.getElementById("pm_type").value;
  	var pm_id=document.getElementById("pm_id").value;
	var utr="#"+pm_id;

	if(pm_name!=''&&pm_name!=null&&pm_type!=''&&pm_type!=null){
		
	    $.ajax({
			url :"updateParamAjax.action" ,
			type :"post",
			dataType:"json", 
			data :{"pm_name":pm_name,"pm_type":pm_type,"pm_id":pm_id},
			success:function(redata){
	/* 			alert(redata.co_price); */	
				parent.$(utr).find(".pm_name").empty();
				parent.$(utr).find(".pm_name").prepend(redata.pm_name);
				parent.$(utr).find(".pm_type").empty();
				parent.$(utr).find(".pm_type").prepend(redata.pm_type);
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
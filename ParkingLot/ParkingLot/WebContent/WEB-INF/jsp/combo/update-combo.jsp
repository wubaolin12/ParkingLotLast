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
<title>编辑套餐</title>
<link href="${path}/static/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-container">
	<form  id="form-article-add" action="updateCombo.action?co_id=${comboObject.co_id}" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>套餐规格/天：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="co_id" style="display: none;" value="${comboObject.co_id}"><input type="text" class="input-text" value="${comboObject.co_standard}" placeholder="" id="co_standard" name="co_standard">
			</div>
		</div>

	<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>套餐价格/元：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${comboObject.co_price}" placeholder="" id="co_price" name="co_price">
			</div>
		</div>

			<div class="row cl" style="height: 20px"></div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="bt1" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
<!--  				<button id="bt1" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> 
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

$('#bt1').on('click', function(){
	/* alert(11111); */
	var index = parent.layer.getFrameIndex(window.name); 
    parent.$('#parentIframe').text('我被改变了');
  	var co_standard=document.getElementById("co_standard").value;
	var co_price=document.getElementById("co_price").value;
  	var co_id=document.getElementById("co_id").value;
	var utr="#"+co_id;

	if(co_standard!=''&&co_standard!=null&&co_price!=''&&co_price!=null){
		if(co_standard>0&&co_price>0){
	    $.ajax({
			url :"updateComboAjax.action" ,
			type :"post",
			dataType:"json", 
			data :{"co_standard":co_standard,"co_price":co_price,"co_id":co_id},
			success:function(redata){
	/* 			alert(redata.co_price); */	
				parent.$(utr).find(".co_standard").empty();
				parent.$(utr).find(".co_standard").prepend(redata.co_standard);
				parent.$(utr).find(".co_price").empty();
				parent.$(utr).find(".co_price").prepend(redata.co_price);
				parent.layer.close(index);
			}
		});
		}else{
			alert("套餐的价格或者天数不能小于0");
		}
	}else{
		alert("请填入数据");
	}
});


function article_save(){
	alert("刷新父级的时候会自动关闭弹层。")
	window.parent.location.reload();
}


</script>
</body>
</html>
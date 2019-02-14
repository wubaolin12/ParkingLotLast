<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HTML5移动端裁剪图片上传头像代码 - A5源码</title>
<link href="${path}/static/headlib/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="format-detection" content="telephone=no, email=no" />
<!--[if IE]>
<script src="js/html5shiv.min.js"></script>
<![endif]-->
</head>
<body>
<header>
<img src="${path}/static/headlib/images/rpw_back_n.png">
<span>填写企业信息</span>
<div class="clear"></div>
</header>
<form action="${path}/login/addPicture.action" theme="simple" method="post" enctype="multipart/form-data">

<section class="logo-license">
<div class="half">
	<a class="logo" id="logox">
		<img id="bgl" src="${path}/static/headlib/images/logo_n.png">

	</a>
	<p>企业LOGO</p>
</div>
<div class="half">
	<div class="uploader blue">
		<input type="text" class="filename" readonly/>
		<a class="license">
			<img id="img-1" src="${path}/static/headlib/images/logo_n.png">
		</a>
		<input id="file0" class="file-3" type="file" size="30" onchange="javascript:setImagePreview();" accept="image/*" capture="camera" />
	</div>
	<div class="yulan">
		<img src="" id="img0" >
		<div class="enter">
			<button class="btn-2 fl">取消</button>
			<button class="btn-3 fr">确定</button>
		</div>
	</div>

   <!-- <p>营业执照</p>-->
</div>
<div class="clear"></div>
</section>

<article class="htmleaf-container">
<div id="clipArea" ></div>
<div class="foot-use">
	<div class="uploader1 blue">
		<input type="button" name="file" class="button" value="打开">
		<input id="file" type="file" onchange="javascript:setImagePreview();" accept="image/*" multiple  />
	</div>
	<button id="clipBtn">截取</button>
</div>
<div id="view"></div>
</article>

<article class="info">
<ul>
   <li>
	   <div class="left">
		  企业名称:
	   </div>
	   <div class="right">
		 <input placeholder="例:厦门软件园">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   企业电话:
	   </div>
	   <div class="right">
		   <input placeholder="例:0592-88888888">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   手机号码:
	   </div>
	   <div class="right">
		   <input placeholder="例:138 8888 8888">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   企业地址:
	   </div>
	   <div class="right">
		   <input placeholder="例:福建省厦门市思明区软件园二期">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   商家描述:
	   </div>
	   <div class="right">
		   <input placeholder="例:A5源码是一家">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   所属行业:
	   </div>
	   <div class="right">
		   <div class="mask"></div>
		   <div id="divselect">
			   <small>请选择行业分类</small>
			   <ul class="all">
				   <li><a href="javascript:;">计算机/互联网/通信/电子</a></li>
				   <li><a href="javascript:;">会计/金融/银行/保险</a></li>
				   <li><a href="javascript:;">毛衣/消费/制造/营运</a></li>
				   <li><a href="javascript:;">制药/医疗</a></li>
				   <li><a href="javascript:;">广告/媒体</a></li>
				   <li><a href="javascript:;">计算机/互联网/通信/电子</a></li>
				   <li><a href="javascript:;">会计/金融/银行/保险</a></li>
				   <li><a href="javascript:;">毛衣/消费/制造/营运</a></li>
				   <li><a href="javascript:;">制药/医疗</a></li>
				   <li><a href="javascript:;">广告/媒体</a></li>
			   </ul>
		   </div>
		   <input name="" type="hidden" value="" id="inputselect">
	   </div>
	   <div class="right second">
		   <div class="mask"></div>
		   <div id="divselectx">
			   <small>请选择行业</small>
			   <ul class="all">
				   <li><a href="javascript:;">计算机</a></li>
				   <li><a href="javascript:;">会计/金融/银行/保险</a></li>
				   <li><a href="javascript:;">毛衣/消费/制造/营运</a></li>
				   <li><a href="javascript:;">制药/医疗</a></li>
				   <li><a href="javascript:;">广告/媒体</a></li>
				   <li><a href="javascript:;">计算机/互联网/通信/电子</a></li>
				   <li><a href="javascript:;">会计/金融/银行/保险</a></li>
				   <li><a href="javascript:;">毛衣/消费/制造/营运</a></li>
				   <li><a href="javascript:;">制药/医疗</a></li>
				   <li><a href="javascript:;">广告/媒体</a></li>
			   </ul>
		   </div>
		   <input name="" type="hidden" value="" id="inputselectx">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   所属区域:
	   </div>
	   <div class="right">
		   <div class="mask"></div>
		   <div id="divselecty">
			   <small>请选择所属区域</small>
			   <ul class="all">
				   <li><a href="javascript:;">北京</a></li>
				   <li><a href="javascript:;">上海</a></li>
				   <li><a href="javascript:;">重庆</a></li>
				   <li><a href="javascript:;">山东</a></li>
				   <li><a href="javascript:;">山西</a></li>
				   <li><a href="javascript:;">陕西</a></li>
				   <li><a href="javascript:;">安徽</a></li>
				   <li><a href="javascript:;">四川</a></li>
				   <li><a href="javascript:;">辽宁</a></li>
				   <li><a href="javascript:;">河北</a></li>
			   </ul>
		   </div>
		   <input name="" type="hidden" value="" id="inputselecty">
	   </div>
	   <div class="clear"></div>
   </li>
</ul>
</article>
<article class="btn-1">
<button type="submit">确认提交</button>
</article>
</form>



<script src="${path}/static/headlib/js/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
<script src="${path}/static/headlib/js/iscroll-zoom.js"></script>
<script src="${path}/static/headlib/js/hammer.js"></script>
<script src="${path}/static/headlib/js/jquery.photoClip.js"></script>
<script>
var obUrl = ''
//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
$("#clipArea").photoClip({
	width: 250,
	height: 250,
	
	file: "#file",
	view: "#view",
	ok: "#clipBtn",
	loadStart: function() {
		console.log("照片读取中");
	},
	loadComplete: function() {
		console.log("照片读取完成");
	},
	clipFinish: function(dataURL) {
		console.log(dataURL);
	}
});
</script>
<script>
$(function(){
$("#logox").click(function(){
$(".htmleaf-container").show();
})
	$("#clipBtn").click(function(){
		$("#logox").empty();
		$('#logox').append('<img src="' + imgsource + '" align="absmiddle" style=" width: 8rem;height: 8rem; margin-left:0rem;margin-top: 0rem">');
		$(".htmleaf-container").hide();
	})
});
</script>
<script type="text/javascript">
$(function(){
	jQuery.divselect = function(divselectid,inputselectid) {
		var inputselect = $(inputselectid);
		$(divselectid+" small").click(function(){
			$("#divselect ul").toggle();
			$(".mask").show();
		});
		$(divselectid+" ul li a").click(function(){
			var txt = $(this).text();
			$(divselectid+" small").html(txt);
			var value = $(this).attr("selectid");
			inputselect.val(value);
			$(divselectid+" ul").hide();
			$(".mask").hide();
			$("#divselect small").css("color","#333")
		});
	};
	$.divselect("#divselect","#inputselect");
});
</script>
<script type="text/javascript">
$(function(){
	jQuery.divselectx = function(divselectxid,inputselectxid) {
		var inputselectx = $(inputselectxid);
		$(divselectxid+" small").click(function(){
			$("#divselectx ul").toggle();
			$(".mask").show();
		});
		$(divselectxid+" ul li a").click(function(){
			var txt = $(this).text();
			$(divselectxid+" small").html(txt);
			var value = $(this).attr("selectidx");
			inputselectx.val(value);
			$(divselectxid+" ul").hide();
			$(".mask").hide();
			$("#divselectx small").css("color","#333")
		});
	};
	$.divselectx("#divselectx","#inputselectx");
});
</script>
<script type="text/javascript">
$(function(){
	jQuery.divselecty = function(divselectyid,inputselectyid) {
		var inputselecty = $(inputselectyid);
		$(divselectyid+" small").click(function(){
			$("#divselecty ul").toggle();
			$(".mask").show();
		});
		$(divselectyid+" ul li a").click(function(){
			var txt = $(this).text();
			$(divselectyid+" small").html(txt);
			var value = $(this).attr("selectyid");
			inputselecty.val(value);
			$(divselectyid+" ul").hide();
			$(".mask").hide();
			$("#divselecty small").css("color","#333")
		});
	};
	$.divselecty("#divselecty","#inputselecty");
});
</script>
<script type="text/javascript">
$(function(){
   $(".mask").click(function(){
	   $(".mask").hide();
	   $(".all").hide();
   })
	$(".right input").blur(function () {
		if ($.trim($(this).val()) == '') {
			$(this).addClass("place").html();
		}
		else {
			$(this).removeClass("place");
		}
	})
});
</script>
<script>
$("#file0").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	 obUrl = objUrl;
	console.log("objUrl = "+objUrl) ;
	if (objUrl) {
		$("#img0").attr("src", objUrl).show();
	}
	else{
		$("#img0").hide();
	}
}) ;
function qd(){
   var objUrl = getObjectURL(this.files[0]) ;
   obUrl = objUrl;
   console.log("objUrl = "+objUrl) ;
   if (objUrl) {
	   $("#img0").attr("src", objUrl).show();
   }
   else{
	   $("#img0").hide();
   }
}
function getObjectURL(file) {
	var url = null ;
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}
</script>
<script type="text/javascript">
var subUrl = "";
$(function (){
	$(".file-3").bind('change',function(){
		subUrl = $(this).val()
		$(".yulan").show();
		$(".file-3").val("");
	});

	$(".file-3").each(function(){
		if($(this).val()==""){
			$(this).parents(".uploader").find(".filename").val("营业执照");
		}
	});
$(".btn-3").click(function(){
$("#img-1").attr("src", obUrl);
$(".yulan").hide();
$(".file-3").parents(".uploader").find(".filename").val(subUrl);
})
	$(".btn-2").click(function(){
		$(".yulan").hide();
	})

});
</script>
<script type="text/javascript">
function setImagePreview() {
	var preview, img_txt, localImag, file_head = document.getElementById("file_head"),
			picture = file_head.value;
	if (!picture.match(/.jpg|.gif|.png|.bmp/i)) return alert("您上传的图片格式不正确，请重新选择！"),
			!1;
	if (preview = document.getElementById("preview"), file_head.files && file_head.files[0]) preview.style.display = "block",
			preview.style.width = "63px",
			preview.style.height = "63px",
			preview.src = window.navigator.userAgent.indexOf("Chrome") >= 1 || window.navigator.userAgent.indexOf("Safari") >= 1 ? window.webkitURL.createObjectURL(file_head.files[0]) : window.URL.createObjectURL(file_head.files[0]);
	else {
		file_head.select(),
				file_head.blur(),
				img_txt = document.selection.createRange().text,
				localImag = document.getElementById("localImag"),
				localImag.style.width = "63px",
				localImag.style.height = "63px";
		try {
			localImag.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)",
					localImag.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = img_txt
		} catch(f) {
			return alert("您上传的图片格式不正确，请重新选择！"),
					!1
		}
		preview.style.display = "none",
				document.selection.empty()
	}
	return document.getElementById("DivUp").style.display = "block",
			!0
}
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
<p>来源：<a href="http://down.admin5.com/" target="_blank">A5源码</a></p>
</div>
</body>
</html>


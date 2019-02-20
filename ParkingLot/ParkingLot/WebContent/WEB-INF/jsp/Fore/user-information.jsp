<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户个人信息</title>
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
<a href="${path}/userinformation/reToforMain.do"><img src="${path}/static/headlib/images/rpw_back_n.png"></a>
<span>个人信息</span>
<div class="clear"></div>
</header>
<form action="${path}/userinformation/headUpload.do" theme="simple" method="post" enctype="multipart/form-data">

<section class="logo-license">
<div class="half">
	<a class="logo" id="logox">
 	<c:if test="${ForeUser.head_path==null}">
		<img id="bgl" src="${path}/static/headlib/images/head.jpg" align="absmiddle" style=" width: 8rem;height: 8rem; margin-left:0rem;margin-top: 0rem">
	</c:if> 
	<c:if test="${ForeUser.head_path!=null}">
		<img id="bgl" src="/picture/${ForeUser.head_path}" align="absmiddle" style=" width: 8rem;height: 8rem; margin-left:0rem;margin-top: 0rem">
	</c:if>
	</a>
	
<p>点击头像以修改头像</p>	
</div>

<div class="clear"></div>
</section>

<article class="htmleaf-container">
<div id="clipArea" ></div>
<div class="foot-use">
	
	<div class="uploader1 blue">	
		<input type="button" name="file" class="button" value="打开">
		<input id="file"  type="file" onchange="javascript:setImagePreview();" accept="image/*" multiple  />
	</div>
	<button id="clipBtn" type="button">截取</button>
</div>
<div id="view"></div>
</article>

<article class="info">
<ul>
   <li>
	   <div class="left">
		  昵称:
	   </div>
	   <div class="right">
		 <input value="${ ForeUser.cust_acc}" readonly="readonly">
	   </div>
	   <div class="clear"></div>
	   <input id="status" type="text" value="loading" style="display:none; ">
   </li>

   <li>
	   <div class="left">
		   性别:
	   </div>
	   <div class="right">
		   <input value="${ ForeUser.cust_sex}" readonly="readonly">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   手机号码:
	   </div>
	   <div class="right">
		   <input value="${ ForeUser.cust_phone}" readonly="readonly">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   账号余额:
	   </div>
	   <div class="right">
		   <input value="${ ForeUser.cust_money}" readonly="readonly">
	   </div>
	   <div class="clear"></div>
   </li>


</ul>
</article>
<article class="btn-1">
<a href="${path}/userinformation/toUpdateUserInformation.do"><button type="button">编辑</button></a>
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
		//alert("qqqqqqqq");
		document.getElementById("status").value="ready";
		 $.ajax({
	            type: "POST",
	            url: '${path}/userinformation/headUploadAjax.do',
	            dataType: 'json',
	            data: { "imgStr": dataURL},
	            success: function(msg) {
	                if(msg.state == 1){
	                    alert(msg.msg);
	                }else{
	                    alert(msg.msg);
	                }
	            }
	        });
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
		$('#logox').append('<img name="headfile" src="' + imgsource + '" align="absmiddle" style=" width: 8rem;height: 8rem; margin-left:0rem;margin-top: 0rem">');

		var status=document.getElementById("status").value;
		if(status=="ready"){
			$(".htmleaf-container").hide();
			//alert("sssss");
		}else{
			alert("请打开一张图片");
		}
		
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
	//alert("llllllllll");
	
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
			document.getElementById("status").value="error";
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


</body>
</html>


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
<a href="${path}/userinformation/toUserInformation.do" ><img src="${path}/static/headlib/images/rpw_back_n.png"></a>
<span>修改信息</span>
<div class="clear"></div>
</header>
<form action="${path}/userinformation/UpdateUserInformation.do" onsubmit="return checkform()" theme="simple" method="post" enctype="multipart/form-data">
<%-- 
<section class="logo-license">
<div class="half">
	<a class="logo" id="logox">
		<img id="bgl" src="${path}/static/headlib/images/logo_n.png">

	</a>
	
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
</article> --%>

<article class="info">
<ul>
   <li>
	   <div class="left">
		  昵称:
	   </div>
	   <div class="right">
		 <input value="${ ForeUser.cust_acc}" id="cust_acc" name="cust_acc">
		 <span id="nametip" style="font-size: 1.8rem"></span>
	  	<input type="text"  id="namekey" style="display: none;" value="该昵称可以使用">
	  	<input type="text" value="${ ForeUser.cust_acc}" style="display: none;" id="oldname">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   性别:
	   </div>
	   <div class="right">
		  
			<select id="cust_sex" name="cust_sex">
				<option value="${ FuserInf.cust_sex}">${ FuserInf.cust_sex}</option>
				<option value="男">男</option>
				<option value="女">女</option>
			</select>

	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		   手机号码:
	   </div>
	   <div class="right">
	   	  	<input type="text" value="${ ForeUser.cust_phone}" style="display: none;" id="oldphone">
	   	  		   
		   <input value="${ ForeUser.cust_phone}" id="cust_phone" name="cust_phone" onkeyup="this.value=this.value.replace(/\D/g,'')"
				onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlenaigth="11"><span id="phonetip" style="font-size: 1.8rem">
	   	  	<input type="text" style="display: none;" id="phonekey" value="该号码可以使用">
	   </div>
	   <div class="clear"></div>
   </li>



</ul>
</article>
<article class="btn-1">
<button type="submit">确认修改</button>
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
function checkform(){
	var namekey=document.getElementById("namekey").value;
	var phonekey=document.getElementById("phonekey").value;
	var cust_acc=document.getElementById("cust_acc").value;
	var cust_phone=document.getElementById("cust_phone").value;
	
	if(cust_acc!=''&&cust_acc!=null&&cust_phone!=''&&cust_phone!=null){
		
		if(namekey=="该昵称可以使用"){
			
			if(phonekey=="该号码可以使用"){
				return true;
			}else{
				alert("请填入正确手机号码");
				return false;
			}
		}else{
			alert("请填入正确昵称");
			return false;
		}
		
	}else{
		alert("请输入信息");
		return false;
	}


}

$(function() {
	
	$("#cust_acc").on("blur",function(){
	
		var cust_acc=document.getElementById("cust_acc").value;
		var oldname=document.getElementById("oldname").value;
		
		if(cust_acc!=''&&cust_acc!=null){
			if(cust_acc!=oldname){
				
				$.ajax({
					url :"FuserNamecheckAjax.do" ,
					type :"post",
					dataType:"text", 
					data :"cust_acc="+cust_acc,
					success:function(redata){
						
						document.getElementById("nametip").innerHTML =redata;
						document.getElementById("namekey").value=redata;
					}
				});
			}else{
				document.getElementById("namekey").value="该昵称可以使用";
			}
		}else{
			document.getElementById("namekey").value="请填入昵称";
		}
	});		
	
 	
});

$(function() {
 	$("#cust_phone").on("blur",function(){
		
		var cust_phone=document.getElementById("cust_phone").value;
		var oldphone=document.getElementById("oldphone").value;
		
		if(cust_phone!=''&&cust_phone!=null){
			if(cust_phone!=oldphone){
				
				$.ajax({
					url :"FuserPhonecheckAjax.do" ,
					type :"post",
					dataType:"text", 
					data :"cust_phone="+cust_phone,
					success:function(redata){
						
						document.getElementById("phonetip").innerHTML =redata;
						document.getElementById("phonekey").value=redata;
					}
				});
			}else{
				document.getElementById("phonekey").value="该号码可以使用";
			}
		}else{
			document.getElementById("phonekey").value="请填入号码";

		}
	});	
	
});


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


</body>
</html>


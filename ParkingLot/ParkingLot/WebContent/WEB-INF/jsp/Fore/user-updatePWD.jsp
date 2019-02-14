<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
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
<a href="#" onClick="javascript :history.back(-1);"><img src="${path}/static/headlib/images/rpw_back_n.png"></a>
<span>修改密码</span>
<div class="clear"></div>
</header>
<form action="${path}/login/addPicture.action" onsubmit="return check()"  theme="simple" method="post" >



<article class="info">
<ul>
   <li>
	   <div class="left">
		 旧密码:
	   </div>
	   <div class="right">
		 <input type="password" value="" id="oldpwd">
		 <span id="pwdtip" style="font-size: 1.8rem"></span>
		 <input id="pwdtip3" type="hidden" value="0">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		  新密码:
	   </div>
	   <div class="right">
		   <input value="" id="newpwd" type="password">
	   </div>
	   <div class="clear"></div>
   </li>
   <li>
	   <div class="left">
		  重复密码:
	   </div>
	   <div class="right">
		   <input value="" id="cpwd" onblur="checkpwd()" type="password">
		   <span id="pwdtip2" value="1"  style="font-size: 1.8rem">
	   </div>
	   <div class="clear"></div>
   </li>



</ul>
</article>
<article class="btn-1">
<button type="button" id="bt1">确认修改</button>
</article>
</form>



<script src="${path}/static/headlib/js/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')</script>
<script src="${path}/static/headlib/js/iscroll-zoom.js"></script>
<script src="${path}/static/headlib/js/hammer.js"></script>
<script src="${path}/static/headlib/js/jquery.photoClip.js"></script>
<script type="text/javascript" src="${path}/static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${path}/static/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${path}/static/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${path}/static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${path}/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${path}/static/lib/laypage/1.2/laypage.js"></script>
<script>

$('#bt1').on('click', function(){
	/* alert(11111); */
	var pwd1 = document.getElementById("newpwd").value;
	var pwd2 = document.getElementById("cpwd").value;
	var tip  = document.getElementById("pwdtip3").value;
	var word;
	
	if(pwd1!=""&&pwd1!=null&&pwd2!=""&&pwd2!=null){
		if(pwd1==pwd2){
			if(tip=="旧密码正确"){	
			
				$.ajax({
					url :"UpdateFUserPWD.do" ,
					type :"post",
					dataType:"text", 
					data :"cust_pwd="+pwd1,
					success:function(redata){
						
						
						layer.confirm(redata,function(index)
						{
							location.href="${path}/fore/foreLogin.do";
						});
						
					}				
				});	
			
			}else{
				alert("请输入正确旧密码");
			}
		
		}else{
			alert("两次密码不一致");
		}
	}else{
		
		document.getElementById("pwdtip2").innerHTML = "提示：密码为空";
		
	}
	

});

function check(){
	
	var pwd1 = document.getElementById("newpwd").value;
	var pwd2 = document.getElementById("cpwd").value;
	var tip  = document.getElementById("pwdtip3").value
	
	if(pwd1!=""&&pwd1!=null&&pwd2!=""&&pwd2!=null){
		if(pwd1==pwd2&&tip=="旧密码正确"){
			
		return true;
		}else{
			return false;
		}
	}else{
		
		document.getElementById("pwdtip2").innerHTML = "提示：密码为空或者两次密码不一致";
		return false;
	}
};
function checkpwd(){
	var pwd1 = document.getElementById("newpwd").value;
	var pwd2 = document.getElementById("cpwd").value;
	if(pwd1!=""&&pwd1!=null&&pwd2!=""&&pwd2!=null){
		if(pwd1==pwd2){
			
			document.getElementById("pwdtip2").innerHTML="输入密码一致,可以修改";
			}else{
			document.getElementById("pwdtip2").innerHTML="输入密码不一致 ";	
			}
	}else{
	
		document.getElementById("pwdtip2").innerHTML = "提示：账户或密码都不能为空！";
		
	}
};




$(function() {
	$("#oldpwd").on("blur",function(){
	
	
		var pwd=document.getElementById("oldpwd").value;
		
		$.ajax({
			url :"FuserPWDcheckAjax.do" ,
			type :"post",
			dataType:"text", 
			data :"checkpwd="+pwd,
			success:function(redata){
				
				document.getElementById("pwdtip").innerHTML =redata;
				document.getElementById("pwdtip3").value=redata;
			}
		});
	});		
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


</body>
</html>


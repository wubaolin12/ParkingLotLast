<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人脸注册</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
     	function CatchCode() {
          //实际运用可不写，测试代 ， 为单击拍照按钮就获取了当前图像，有其他用途
          var canvans = document.getElementById("canvas");
          var video = document.getElementById("video");
          var context = canvas.getContext("2d");
 
          canvas.width = video.videoWidth;
          canvas.height = video.videoHeight;
          context.drawImage(video,0,0);
          
          var imgData = canvans.toDataURL();
			//获取图像在前端截取22位以后的字符串作为图像数据
			var imgData1 = imgData.substring(22);
			
			var username = $("#username").val();
			$.ajax({
					type: "post",
					url: "FaceServlet?tag=reg",
					data: {"img":imgData1,"username":username},
					success: function(data){
						alert(data);
					},error:function(msg){
						alert("错误");
					}
				});
				
  				
      }
     		
     </script>
</head>
<body>
	<h2>注册</h2>
	用户名：
	<input type="text" name="username" id="username" />
	<br /> 录入头像：
	<div id="support"></div>
	<div id="contentHolder">
		<video id="video" width="120" height="90"
			style="border:1px solid red;border-radius: 800px;" autoplay></video>

		<canvas style="border:1px solid red;border-radius: 800px;width:120px;height:80px;"
			id="canvas"></canvas>
	</div>
	<br />
	<input type="button" value="确认" id="snap" />
	<br />
	<a href="login.jsp">点击登陆</a>
</body>
</html>
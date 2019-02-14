<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!doctype html>
<html lang="en">
	<head>
	<title>人脸注册</title>
	<meta charset="utf-8">
	<script type="text/javascript" src="<%=path%>static/js/jquery-1.8.3.min.js"></script>
	<body>
	<h2>注册</h2>
	用户名：
	<input type="text" name="username" id="username"/>
	<br /> 录入头像：
	<!-- <input type="button" title="开启摄像头" value="开启摄像头" onclick="getMedia()" /> -->
	<video id="video" width="500px" height="500px" autoplay="autoplay"></video>
	<canvas id="canvas" width="500px" height="500px"></canvas>
	<button id="snap" onclick="takePhoto()">拍照</button>
	<script>
		window.onload = function (){
		          let constraints = {
	                video: {width: 500,height: 500},
	                audio: true
	            };
	            //获得video摄像头区域
	            let video = document.getElementById("video");
	            //这里介绍新的方法，返回一个 Promise对象
	            // 这个Promise对象返回成功后的回调函数带一个 MediaStream 对象作为其参数
	            // then()是Promise对象里的方法
	            // then()方法是异步执行，当then()前的方法执行完后再执行then()内部的程序
	            // 避免数据没有获取到
	            let promise = navigator.mediaDevices.getUserMedia(constraints);
	            promise.then(function (MediaStream) {
	                video.srcObject = MediaStream;
	                video.play();
	            });
			}
	      function takePhoto() {
	      //获得Canvas对象
	      let video = document.getElementById("video");
	      let canvas = document.getElementById("canvas");
	      let ctx = canvas.getContext('2d');
	      ctx.drawImage(video, 0, 0);
	          var imgData = canvas.toDataURL();
				//获取图像在前端截取22位以后的字符串作为图像数据
				var imgData1 = imgData.substring(22);
				var username = $("#username").val();
				$.ajax({
						type: "post",
						url: "<%=path%>faceServlte/face.action?tag=reg",
						data: {"img":imgData1,"username":username},
						success: function(data){
							alert(data);
						},error:function(msg){
							alert("错误");
						}
					});	
	      }
</script>
</body>
</html>
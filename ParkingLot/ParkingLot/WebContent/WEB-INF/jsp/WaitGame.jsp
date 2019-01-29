<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<!DOCTYPE html>

<html>



<head>



  <meta charset="UTF-8">



  <title>jQuery Flappy Bird - CodePen</title>



    <style>

* {

  margin: 0;

  padding: 0;

  outline: none;

  border: 0;

  font-family: segoe ui, helvetica neue, helvetica, arial, sans-serif;

  font-weight: 200;

  -webkit-font-smoothing: antialiased;

  user-select: none;

}



body {

  font-size: 14px;

}



p {

  font-size: 90%;

  line-height: 25px;

}



/* Wrapper */

.wrapper {

  width: 350px;

  margin: 20px auto;

}



/* Window */

.window {

	height: 450px;

	background: url('${path}/static/css/img/background.png');

	position: relative;

	overflow: hidden;

  margin-bottom: 10px;

}



/* Score */

.score {

  position: absolute;

  width: 100%;

  display: block;

  text-align: center;

  font-size: 250%;

  padding-top: 20px;

  color: #fff;

  font-weight: 700;

  text-shadow: 2px 2px 0 #000;

  z-index: 4;

}



/* Bird */

.bird {

	height: 28px;

	width: 40px;

	background: url('${path}/static/css/img/bird_Sprite.png');

	position: absolute;

	bottom: 50%;

	left: 130px;

	z-index: 3;

  animation: birdFlap 0.2s steps(3, end) infinite alternate;

  transition: transform 0.3s;

}



@keyframes birdFlap {  

  0% {background-position: 0 84px;}

  100% {background-position: 0 0;}

}



/* Pipes */

.pipe {

	width: 60px;

	height: 100%;

	position: absolute;

	right: -60px;

	z-index: 2;

}



.pipe.hidden {

  display: none;

}



.pipe .topHalf {

	background: url('${path}/static/css/img/pipe.png') bottom;

	position: absolute;

	top: 0;

	width: 100%;

}



.pipe .bottomHalf {

	background: url('${path}/static/css/img/pipe.png') top;

	position: absolute;

	bottom: 0;

	width: 100%;

}

</style>



    <script src="${path}/static/js/prefixfree.min.js"></script>



</head>



<body>



  <div class="wrapper">

  <div class="window">

    <p class="score">0</p>

	  <div class="bird"></div>



    <div class="pipe hidden"></div>

    <div class="pipe hidden"></div>

  </div>



  <p>单击鼠标开始。刷新重新启动。</p>

</div>


<script src="${path}/static/css/jquery.min.js"></script>


  <script src="${path}/static/js/index.js"></script>



</body>



</html>
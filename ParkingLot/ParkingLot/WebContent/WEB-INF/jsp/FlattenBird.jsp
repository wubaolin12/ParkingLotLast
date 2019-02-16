<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>压扁小鸟小游戏</title>
<meta name="description" content="你恨 flappy bird 吗?你每天晚上对着那个愚蠢的鸟做噩梦吗？ 压扁它们！.">
<meta property="og:description" content="你恨 flappy bird 吗?你每天晚上对着那个愚蠢的鸟做噩梦吗？ 压扁它们！.">
<meta property="og:type" content="website">
<meta property="og:title" content="Squishy Bird">
<meta property="og:site_name" content="Squishy Birds">
<meta name="viewport" content="user-scalable=no, initial-scale=0.5, width=610, height=1024">
</head>
<body style="margin: 0px; overflow: hidden;-moz-user-select: none;-webkit-user-select: none;user-select: none;">
<div id="lgd" style="width: 300px; height: 64px; position: absolute; left: 533px; top: 301px; font-family: Verdana; font-size: 16px; font-weight: bold; text-align: center;">Loading...</div>
<script type="text/javascript" src="${path}/static/js/squishybird.js"></script>
<div style="overflow: hidden; position: relative; width: 1366px; height: 620px;">
<canvas width="1366" height="620"></canvas>
<img src="${path}/static/img/pipe1.png" width="148" height="1664" style="position: absolute; left: 609px; top: -1533px; z-index: 420;"><img src="${path}/static/img/pipe2.png" width="148" height="1664" style="position: absolute; left: 609px; top: 400.9999999999999px; z-index: 420;">
<canvas width="1366" height="88" style="position: absolute; z-index: 31337; left: 0px; top: 532px;"></canvas>
<canvas width="1366" height="256" style="position: absolute; z-index: 60; left: 0px; top: 276px;"></canvas>
<canvas width="1366" height="216" style="position: absolute; z-index: 61; left: 0px; top: 316px;"></canvas>
<img src="${path}/static/img/logo.png" style="position: absolute; opacity: 0; z-index: 42069; left: 370px; top: 174px; display: none;"><img src="${path}/static/img/gameover.png" style="position: absolute; opacity: 1; z-index: 42069; left: 370px; top: 93px; display: inline;"><img src="${path}/static/img/clicktostart.png" style="position: absolute; opacity: 0; z-index: 42070; left: 514px; top: 435px; display: none;">
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 536px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 535px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 534px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(255, 255, 255); z-index: 88888; -webkit-user-select: none; left: 533px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 533px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 532px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 531px; top: 17px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 23px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 22px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 21px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 20px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 19px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 18px;">0</div>
<div style="width: 300px; height: 50px; position: absolute; text-align: center; font-family: Verdana; font-weight: bold; font-size: 30px; color: rgb(0, 0, 0); z-index: 88887; -webkit-user-select: none; left: 530px; top: 17px;">0</div>
<canvas width="150" height="150" style="z-index: 69; position: absolute; left: 880.7973799593747px; top: 288.1699138371274px;"></canvas>
<canvas width="150" height="150" style="z-index: 69; position: absolute; left: 94.18296936130267px; top: 175.22475277371694px;"></canvas>
<canvas width="150" height="150" style="z-index: 69; position: absolute; left: 147.39346598794316px; top: 196.6628938429057px;"></canvas>
<canvas width="150" height="150" style="z-index: 69; position: absolute; left: -235.79706690685066px; top: -486.7269952782424px;"></canvas>
</div>
<audio src="${path}/static/re/flap.wav"></audio>
<audio src="${path}/static/re/flap.wav"></audio>
<audio src="${path}/static/re/flap.wav"></audio>
<audio src="${path}/static/re/flap.wav"></audio>
<audio src="${path}/static/re/flap.wav"></audio>
<audio src="${path}/static/re/slide.wav"></audio>
<audio src="${path}/static/re/slide.wav"></audio>
<audio src="${path}/static/re/slide.wav"></audio>
<audio src="${path}/static/re/clang.wav"></audio>
<audio src="${path}/static/re/clang.wav"></audio>
<audio src="${path}/static/re/clang.wav"></audio>
<audio src="${path}/static/re/coin.wav"></audio>
<audio src="${path}/static/re/coin.wav"></audio>
<audio src="${path}/static/re/coin.wav"></audio>
<audio src="${path}/static/re/coin2.wav"></audio>
<audio src="${path}/static/re/coin2.wav"></audio>
<audio src="${path}/static/re/coin2.wav"></audio>
<audio src="${path}/static/re/coin3.wav"></audio>
<audio src="${path}/static/re/coin3.wav"></audio>
<audio src="${path}/static/re/coin3.wav"></audio>
<audio src="${path}/static/re/coin4.wav"></audio>
<audio src="${path}/static/re/coin4.wav"></audio>
<audio src="${path}/static/re/coin4.wav"></audio>
<audio src="${path}/static/re/kick.wav"></audio>
<audio src="${path}/static/re/kick.wav"></audio>
<audio src="${path}/static/re/kick.wav"></audio>
<audio src="${path}/static/re/kick.wav"></audio>
<audio src="${path}/static/re/kick.wav"></audio>
<audio src="${path}/static/re/kick2.wav"></audio>
<audio src="${path}/static/re/kick2.wav"></audio>
<audio src="${path}/static/re/kick2.wav"></audio>
<audio src="${path}/static/re/kick2.wav"></audio>
<audio src="${path}/static/re/kick2.wav"></audio>
<audio src="${path}/static/re/kick3.wav"></audio>
<audio src="${path}/static/re/kick3.wav"></audio>
<audio src="${path}/static/re/kick3.wav"></audio>
<audio src="${path}/static/re/kick3.wav"></audio>
<audio src="${path}/static/re/kick3.wav"></audio>
<audio src="${path}/static/re/kick4.wav"></audio>
<audio src="${path}/static/re/kick4.wav"></audio>
<audio src="${path}/static/re/kick4.wav"></audio>
<audio src="${path}/static/re/kick4.wav"></audio>
<audio src="${path}/static/re/kick4.wav"></audio>
<audio src="${path}/static/re/kick5.wav"></audio>
<audio src="${path}/static/re/kick5.wav"></audio>
<audio src="${path}/static/re/kick5.wav"></audio>
<audio src="${path}/static/re/kick5.wav"></audio>
<audio src="${path}/static/re/kick5.wav"></audio>
<audio src="${path}/static/re/squish1.wav"></audio>
<audio src="${path}/static/re/squish1.wav"></audio>
<audio src="${path}/static/re/squish1.wav"></audio>
<audio src="${path}/static/re/squish2.wav"></audio>
<audio src="${path}/static/re/squish2.wav"></audio>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" /> 
    
<!DOCTYPE html>
<html>
<html>

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${path}/static/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加白名单车辆 </title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<div style="border:#000 solid 1px; width:500px; margin: 100px auto; font-size: 16px;">
    	<div>
         <h1 align="center">收入统计</h1>
</div>
        <div>
          <table width="350" border="1" align="center">
            <tr>
              <td width="155" align="right">总收入（元）:</td>
              <td width="50" align="left">${dataStatistics.allCome}</td>
            </tr>
            <tr>
              <td align="right">停车总场次（次）：</td>
              <td align="left">${dataStatistics.parkinbout}</td>
            </tr>
            <tr>
              <td align="right">月缴用户收入（元）:</td>
              <td align="left">${dataStatistics.monthUserInCome}</td>
            </tr>
            <tr>
              <td align="right">临时用户收入（元）：</td>
              <td align="left">${dataStatistics.temporaryUserInCome}</td>
            </tr>
            <tr>
              <td align="right">月缴套餐1收入:</td>
              <td align="left">${dataStatistics.temporaryUserInCome1}</td>
            </tr>
            <tr>
              <td align="right">月缴套餐2收入:</td>
              <td align="left">${dataStatistics.temporaryUserInCome2}</td>
            </tr>
            <tr>
              <td align="right">月缴套餐3收入:</td>
              <td align="left">${dataStatistics.temporaryUserInCome3}</td>
            </tr>
            <tr>
              <td align="right">月缴套餐4收入:</td>
              <td align="left">${dataStatistics.temporaryUserInCome4}</td>
            </tr>

          </table>
        </div>
        
        <div>
          <div align="center">
  <input type="submit" name="button" id="button" value="查询" onclick="checkNum()"/>
          </div>
        </div>
    </div>
</body>


<script type="text/javascript">
function checkNum(){
	 window.location.href="${path}/billingDetails/findDataStatistics.action";
}

</script>

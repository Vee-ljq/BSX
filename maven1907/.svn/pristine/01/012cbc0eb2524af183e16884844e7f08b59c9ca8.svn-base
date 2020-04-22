<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>文章列表--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/js/layui/css/news.css" media="all" />
	<link rel="stylesheet" href="<%=path%>/js/layui/css/login.css">
</head>
<body class="childrenBody">

	<div class="video_mask">
		<video autoplay="autoplay"  style="width:100%;" class="video-player" loop="loop" muted>
      		<source  src="<%=path %>/js/layui/page/login/1111.mp4" type="video/mp4" ></source>
 		</video>
	</div>
	<div class="login">
	    <h1>B2C电子商务平台登录</h1>
	    <form class="layui-form" action="<%=path%>/login.action" method="post">
	    	<div class="layui-form-item">
				<input class="layui-input" name="loginaccount" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" name="pwd" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>
		    <div class="layui-form-item form_code">
				<input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
				<div class="code"><img id="yzm" src="<%=path %>/verification.action" width="116" height="36" title="看不清，点击换一张" onclick="change(this)"></div>
		    </div>
			<button class="layui-btn login_btn" type="submit" lay-submit="" lay-filter="login">登录</button>
		</form>
	</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
</body>
<script type="text/javascript">
	function change(obj){
		obj.src="<%=path %>/verification.action";
	}

</script>
</html>
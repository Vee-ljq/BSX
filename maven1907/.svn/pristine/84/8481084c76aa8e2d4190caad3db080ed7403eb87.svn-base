<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
</head>

<body>
	<%
		String nickname = "";
		String pwd = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			//获取cookie的值
			if ("name".equals(cookie.getName())) {
				nickname = cookie.getValue();
			}
			if ("pwd".equals(cookie.getName())) {
				pwd = cookie.getValue();
			}

		}
	%>
	<div class="login-boxtitle"></div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="images/big.jpg" />
			</div>
			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>
				<form method="post" action="index.action">
					<div class="login-form">

						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i> </label> <input
								type="text" name="nickname" value="<%=nickname %>" id="user" placeholder="邮箱/手机/用户名">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i> </label> <input
								type="password" name="pwd"  value="<%=pwd %>" id="password" placeholder="请输入密码">
						</div>

					</div>

					<div class="login-links">
						<label id="remember-me1" for="remember-me"
							style="background-color: #f8f8f8"><input id="remember-me" name="remember"
							type="checkbox"><a id="ji">记</a><a id="ji1">住</a><a
							id="ji2">密</a><a id="ji3">码</a>
						</label> <a href="#" class="am-fr">忘记密码</a> <a href="register.action"
							class="zcnext am-fr am-btn-default">注册</a> <br />
					</div>
					<div class="am-cf">
						<input type="submit" name="" value="登 录"
							class="am-btn am-btn-primary am-btn-sm">
					</div>

				</form>
				<div class="partner">
					<h3>合作账号</h3>
					<div class="am-btn-group">
						<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span>
						</a>
						</li>
						<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span>
						</a>
						</li>
						<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span>
						</a>
						</li>
					</div>
				</div>

			</div>
		</div>
	</div>


	<div class="footer " >
					<div class="footer-hd " >
						<p style="text-align: center">
							<a href="<%=path %>/webrzw/enterRuanying.action?type=0">软赢科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="<%=path %>/webrzw/enterRuanying.action?type=1">支付宝</a>
							<b>|</b>
							<a href="<%=path %>/webrzw/enterRuanying.action?type=2">物流</a>
						</p>
					</div>
		<div class="footer-bd ">
			<p style="text-align: center">
				<a href="# ">关于软赢</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2019-2025 sofwin.com 版权所有</em>
			</p>
		</div>
	</div>
</body>

</html>

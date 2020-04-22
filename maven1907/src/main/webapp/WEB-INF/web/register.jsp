<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
		
		<script src="<%=path %>/web/js/jquery-3.2.1.min.js"></script>
		<script src="<%=path %>/web/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.jsp"><img alt="" src="images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">邮箱注册</a></li>
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form method="post" action="log.action" id="form1">
										
							   <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="emain" id="email" placeholder="请输入邮箱账号" required="required">
                 </div>										
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="pwd" id="password1" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password"  id="passwordRepeat1" placeholder="确认密码">
                 </div>	
                 
                 </form>
                 
								 <div class="login-links">
										<label for="reader-me">
											<input id="rea" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" name="" id="zc" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>

								</div>
								<input type="hidden" id="a1" value="${a1 }"/>
							<script type="text/javascript">
							
							$(function() {
									    $('#doc-my-tabs').tabs();
									  })
									  	$(document).ready(function(){
											$("#zc").click(function(){
												var a=$("#password1").val();
												var b=$("#passwordRepeat1").val();
												var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
												var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
												var c=$("#email").val();
												var ty=$("#reader-me").val();
												if(c.length==0){
													alert("请输入邮箱");
												}else
												if(!filter.test(c)){
													alert("输入的邮箱格式不正确");
												}else
												
												if(a.length<6||a.length>12){
													alert("密码长度必须是6-12位数字和英文字母组成");
												}else
												if(!reg.test(a)){
													alert("输入密码不能是纯数字或纯字母");
												}else
												if(a!=b){
												
												document.getElementById("passwordRepeat1").value="";
													alert("输入两次密码不一致");
												}else
												
												if(!$("#rea").is(':checked') ){
												alert("必须选中商城协议");
												}else
												{
												$("#form1").submit();												
												}
											});
										});
							
							</script>
								

								<div class="am-tab-panel">
									<form method="post" action="selectsj.action" id="form2">
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="text" name="mobile" id="phone" placeholder="请输入手机号">
                 </div>																			
										<div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="tel" name="brand" id="code" placeholder="请输入验证码">
											<a class="btn" href="javascript:void(0);" >
												<span id="dyMobileButton">获取</span></a>
										</div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="pwd" id="password" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
                 </div>	
									</form>
								 <div class="login-links">
										<label for="reader-me">
											<input id="reader-me1" type="checkbox"> 点击表示您同意商城《服务协议》
										</label>
							  	</div>
										<div class="am-cf">
											<input type="submit" name="" id="zc1" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
								
									<hr>
								</div>
								
								<script>
								$(document).ready(function(){
										var a1=$("#a1").val();
										if(a1=="1"){
											alert("用户已注册");
										}else if(a1=="2"){
											alert("验证码错误");
										}
										var ab = /^[1][3,4,5,7,8][0-9]{9}$/;
										$("#dyMobileButton").click(function(){
										var phone=$("#phone").val();
										alert(phone);
										var brand=$("#code").val();
											if(phone.length==0){
												alert("请输入手机号");
											}else
											if(!ab.test(phone)){
												alert("输入的手机号格式不正确");
											}else{
										$.ajax({
												url:"../web/checkYzm.action",
												type:"post",
												dataType:"text",
												data:{
												mobile:phone
												},
												success:function(result){
													if(result==="1"){
														alert("获取验证码");
													}else if(result!="1"){
														alert("获取验证失败");
													}
												}
										
										});
										
									}
											
										
										});
										
										
										$("#zc1").click(function(){
											var yan=$("#code").val();
											var a=$("#password").val();
												var b=$("#passwordRepeat").val();
												var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
											if(yan.length==0){
												alert("请输入验证码");
											}else 
											if(a.length<6||a.length>12){
													alert("密码长度必须是6-12位数字和英文字母组成");
												}else
												if(!reg.test(a)){
													alert("输入密码不能是纯数字或纯字母");
												}else
												if(a!=b){
												
												document.getElementById("passwordRepeat").value="";
													alert("输入两次密码不一致");
												}else
												
												if(!$("#reader-me1").is(':checked') ){
												alert("必须选中商城协议");
												}else
												{
												$("#form2").submit();												
												}
										
										});
										
								});
									
								</script>

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
						<a href="# ">关于软赢</a>
						<a href="# ">合作伙伴</a>
						<a href="# ">联系我们</a>
						<a href="# ">网站地图</a>
						<em>© 2019-2025 sofwin.com 版权所有</em>
					</p>
				</div>
			</div>
	</body>

</html>
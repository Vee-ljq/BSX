<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
 String  path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>绑定手机</title>

		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/stepstyle.css" rel="stylesheet" type="text/css">

		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
							<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<c:if test="${empty sessionScope.customer.nickname }">
					<div class="topMessage">
						<div class="menu-hd">
							<a href="<%=path %>/web/login.action" target="_top" class="h">亲，请登录</a>
							<a href="register.jsp" target="_top">免费注册</a>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.customer.nickname }">
					<div class="topMessage">
						<div class="menu-hd">
							
							<a target="_top">欢迎    ：  ${sessionScope.customer.nickname }</a>
						</div>
					</div>
				</c:if>
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="<%=path %>/webHome/index.action" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="<%=path %>/web/information.action" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="<%=path %>/webshopcart/enter.action?type=1" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="<%=path %>/webCollection/toCollection.action" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="<%=path %>/web/images/e511568655212f2b216528fdc196437.jpg" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">绑定手机</strong> / <small>Bind&nbsp;Phone</small></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">绑定手机</p>
                            </span>
							<span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
							<span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
					</div>
					<form class="am-form am-form-horizontal" action="<%=path%>/web/savechangephone.action" method="post" target="_parent" onsubmit="return checknewcode();">
						<div class="am-form-group bind">
							<label for="user-phone" class="am-form-label">验证手机</label>
							<div class="am-form-content">
								<span id="user-phone" ><input name="oldphonenumber" id="oldphonenumber" value="${customer.mobile }"/> </span>
							</div>
						</div>
						<div class="am-form-group code">
							<label for="user-code" class="am-form-label">验证码</label>
							<div class="am-form-content">
								<input type="tel" id="user-code" onblur="checkoldcode();" name="oldcode" placeholder="短信验证码">
							</div>
							<a class="btn" href="javascript:void(0);" id="sendMobileCode">
								<div class="am-btn am-btn-danger" style="margin-left:20px;"><input id="sendcode" value="验证码" type="button" onclick="sendmessage();" style="background:#dd514c; border:none; " />
								</div>
							</a>
							<span id="oldcoderemind"></span>
						</div>
						<div class="am-form-group">
							<label for="user-new-phone" class="am-form-label">验证手机</label>
							<div class="am-form-content">
								<input type="tel" name="newphone" onblur="checknewphone();" id="newphonenumber" placeholder="绑定新手机号">
							<span id="newphonenumber" style="padding-left:50px; "></span>
							</div>
						</div>
						<div class="am-form-group code">
							<label for="user-new-code" class="am-form-label">验证码</label>
							<div class="am-form-content">
								<input type="tel" name="newcode" id="user-new-code" placeholder="短信验证码">
							</div>
							<a class="btn" href="javascript:void(0);"  id="sendMobileCode">
								<div class="am-btn am-btn-danger"><input id="sendnewcode" value="验证码" type="button" onclick="sendmessage1();" style="background:#dd514c; border:none; " /></div>
							</a>
							<span id="newcoderemind"></span>
						</div>
						<div class="info-btn">
							<div class="am-btn am-btn-danger"><button class="am-btn am-btn-danger" style="border: none"  type="submit">保存修改</button></div>
						</div>

					</form>

				</div>
				<!--底部-->
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
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有</em>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="<%=path %>/web/information.action">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li class="active"> <a href="<%=path %>/web/information.action">个人信息</a></li>
							<li> <a href="<%=path %>/web/setsafety.action">安全设置</a></li>
							<li> <a href="<%=path %>/webaddress/enter.action">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li><a href="<%=path %>/web/allOrderData.action">订单管理</a></li>
							<li> <a href="change.jsp">退款售后</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="<%=path %>/webbill/billAll.action">我的资产</a>
						<ul>
							<li> <a href="coupon.jsp">优惠券 </a></li>
							<li> <a href="bonus.jsp">红包</a></li>
							<li class="active"> <a href="<%=path %>/webbill/billlist.action?date=7">账单明细</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="#">我的小窝</a>
						<ul>
							<li> <a href="<%=path %>/webCollection/toCollection.action">收藏</a></li>
							<li> <a href="<%=path%>/webfoot/foot.action?cuid=${sessionScope.customer.id }">足迹</a></li>
							<li> <a href="<%=path %>/web/comment.action">评价</a></li>
							<li> <a href="<%=path %>/web/newsData.action">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>

	</body>
<script type="text/javascript">
		 var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
		 var count = 60; //间隔函数，1秒执行
         var count1 = 60;
         var curCount;
         var curCount1;
         curCount = count;
         curCount1 =count1;
         
function checkoldcode(){
   //  var oldcode1 = document.getElementById("user-code").value;
	$.ajax({
	url:"../web/sendmessage.action",
	type:"POST",
	dataType: "text",
	data:{typeid:"2",oldcode1:oldcode1},
	success:function(result){

	if(result==="1"){
	 document.getElementById("oldcoderemind").innerHTML="验证码正确";
 		$("#oldcoderemind").css("color","green");
	}else{
	 document.getElementById("oldcoderemind").innerHTML="验证码不正确，请重新输入";
 		$("#oldcoderemind").css("color","red");
	}
	
	}
	})
}
function checknewcode(){
 var newcode = document.getElementById("user-new-code").value;
	$.ajax({
	url:"../web/sendmessage.action",
	type:"POST",
	dataType: "text",
	data:{typeid:"2",oldcode1:newcode},
    success:function(result){
	if(result==="1"){
	 document.getElementById("newcoderemind").innerHTML="验证码正确";
 		$("#newcoderemind").css("color","green");
 		return true;
	}else{
	 document.getElementById("newcoderemind").innerHTML="验证码不正确，请重新输入";
 		$("#newcoderemind").css("color","red");
 		return false;
	}
}
})
} 
function sendmessage(){
 var oldphone = document.getElementById("oldphonenumber").value;
	$("#sendcode").attr("disabled", "true");
    $("#sendcode").val("请在" + curCount + "秒内输入验证码");
    InterValObj = setInterval(SetRemainTime, 1000);
$.ajax({
 url:"../web/sendmessage.action",
 type:"POST",
 dataType: "text",
 data:{typeid:"1",oldphone:oldphone},
 success: function(result){
 alert(result);
 }
})
}
function sendmessage1(){
 var newphone = document.getElementById("newphonenumber").value;
 alert(newphone);
	$("#sendnewcode").attr("disabled", "true");
    $("#sendnewcode").val("请在" + curCount1 + "秒内输入验证码");
    InterValObj1 = setInterval(SetRemainTime1, 1000);
$.ajax({
 url:"../web/sendmessage.action",
 type:"POST",
 dataType: "text",
 data:{typeid:"1",oldphone:newphone},
 success: function(result){
 alert(result);
 }
})
}

function SetRemainTime() {
    if (curCount == 0) {
    clearInterval(InterValObj);//停止计时器
    $("#sendcode").removeAttr("disabled");//启用按钮
    $("#sendcode").val("重新发送验证码");
    curCount=60;
    }
    else {
    curCount--;
    $("#sendcode").val("请在" + curCount + "秒内输入验证码");
    }
    }
    function SetRemainTime1() {
    if (curCount1 == 0) {
    clearInterval(InterValObj1);//停止计时器
    $("#sendnewcode").removeAttr("disabled");//启用按钮
    $("#sendnewcode").val("重新发送验证码");
    curCount1=60;
    }
    else {
    curCount1--;
    $("#sendnewcode").val("请在" + curCount1 + "秒内输入验证码");
    }
    }
    
    function checknewphone(){
    var newphone = $("#user-new-phone").val();
    if(myreg.test(newphone)&&!newphone.length==0){
    	
    document.getElementById("newphonenumber").innerHTML="输入正确";
 		$("#newphonenumber").css("color","green");
 		return true;
    }else{
    	document.getElementById("newphonenumber").innerHTML="手机号码格式不正确，请重新输入！";
 		$("#newphonenumber").css("color","red");
 		return false;
    }
    }
    
</script>
</html>
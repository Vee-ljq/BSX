<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>商品页面</title>

	<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/web/basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link type="text/css" href="<%=path %>/web/css/optstyle.css" rel="stylesheet" />
	<link type="text/css" href="<%=path %>/web/css/style.css" rel="stylesheet" />
	<link type="text/css" href="<%=path %>/web/css/hmstyle.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=path %>/js/ace/css/ace.css" media="all" />
 	<link rel="stylesheet" href="<%=path%>/js/ace/css/bootstrap.css"/>
	<script type="text/javascript" src="<%=path %>/web/basic/js/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="<%=path %>/web/basic/js/quick_links.js"></script>

	<script type="text/javascript" src="<%=path %>/web/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
	<script type="text/javascript" src="<%=path %>/web/js/jquery.imagezoom.min.js"></script>
	<script type="text/javascript" src="<%=path %>/web/js/jquery.flexslider.js"></script>
	<style>
		ul.pagination {
			display: inline-block;
			padding: 0;
			margin: 0;
		}

		ul.pagination li {display: inline;}

		ul.pagination li a {
			color: black;
			float: left;
			padding: 8px 16px;
			text-decoration: none;
			transition: background-color .3s;
			border: 1px solid #ddd;
		}

		ul.pagination li a.active {
			background-color: #4CAF50;
			color: white;
			border: 1px solid #4CAF50;
		}

		ul.pagination li a:hover:not(.active) {background-color: #ddd;}
		/* select */
		.select{margin:0 auto;}
		.select li{float: left;list-style:none;padding: 5px 0;
			border-top: 1px dotted #ddd;}
		.select .select-list{float: left;display: inline-block;width: 1200px;}
		.select dl{float: left;width: 1200px;zoom:1;line-height: 30px;}
		.select dl:after{content:" ";display:block;clear:both;height:0;overflow:hidden}
		.select dt{float: left;width: 100px;height: 30px;line-height: 30px;line-height: 34px\9;overflow: hidden;color: #669900;font-weight: bold;
			text-align: right;}
		.select dd{float:left;display:inline;line-height: 30px;float: left;width: 855px;overflow: hidden;}

		.select dd.fList span {float: left;line-height: 30px;width: 855px;}

		.select a{float: left; display:inline-block;margin: 0 10px;white-space:nowrap;line-height: 30px;padding:0 10px;text-decoration:none;border-radius:2px;}
		.select-list a:hover{color: #8cb91e;background-color:#D5F095;}
		.select-list a.selected{color:#fff;background: #8cb91e;}
		.select-result dt{font-weight:bold}
		.select-no{color:#999}
		.select .select-result .selected{padding-right:20px;color: #fff;background: #8cb91e url("../images/close.gif") right 9px no-repeat;margin: 0 0 5px 5px;}
		.select .select-result .selected:hover{background-position:right -15px}
		.select-no:hover {color: #999;}
	</style>
</head>

<body>

<form action="<%=path%>/webHome/toList.action">
				<input type="hidden" id="pageNumber" name="pageNumber" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="hidden" id="typeid" name="pid" value="${tid }"/>
<!--顶部导航条 -->
<div class="hmtop" >
		<a href="#" name="top"></a>
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
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
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="<%=path %>/webHome/index.action" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="<%=path %>/web/information.action" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="<%=path %>/webshopcart/enter.action?type=1" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">${num }</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="<%=path %>/webCollection/toCollection.action" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div> 
<!--悬浮搜索框-->

<div class="nav white">
	<div class="logo"><img src="images/logo.png" /></div>
	<div class="logoBig">
		<li><img src="<%=path %>/web/images/e511568655212f2b216528fdc196437.jpg" /></li>
	</div>
	<div class="search-bar pr">
		<a name="index_none_header_sysc" href="#"></a>
		<form action="<%=path%>/webHome/toList.action">
			<input type="hidden" name="sflag" value="3">
			<input id="searchInput" name="tiaojian" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
			<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit" >
		</form>
	</div>
</div>

<div class="clear"></div>
<b class="line"></b>
<div class="listMain">

	<!--分类-->
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
	<ol class="am-breadcrumb am-breadcrumb-slash">
		<li><a href="#">首页</a></li>
		<li><a href="#">分类</a></li>
		<li class="am-active">内容</li>
	</ol>
	<script type="text/javascript">
        $(function() {});
        $(window).load(function() {
            $('.flexslider').flexslider({
                animation: "slide",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });
        });
	</script>


</div>

<!--查询条件开始-->
<div class="shopMainbg" style="margin:10px 0px;">
	<div class="shopMain" id="shopmain">
		<div id="f1">
			<div class="am-g am-g-fixed floodFour" style="border: 1px solid #D9D9D9;">
			<ul class="select">
				<li class="select-list" style="border-top:0;">
					<dl id="select1">
						<dt>品牌：</dt>
						<dd class="fList ">
					  <span class="L01">
						<a <c:if test="${flag==0 }">class="select-all selected"</c:if> href="<%=path%>/webHome/toList.action?pid=${tid}&flag=0">全部</a>
					  <c:forEach items="${top }" var="aa">
						<a  title="全部" <c:if test="${aa.id==typeid }">class="select-all selected"</c:if> href="<%=path%>/webHome/toList.action?typeid=${aa.id}&flag=1&pid=${aa.pid }">${aa.typename }</a>
					<!-- 	<a title="全部" href="#">柠檬</a>
						<a title="全部" href="#">桃</a>
						<a title="全部" href="#">山竹</a>
						<a title="全部" href="#">提子</a>
						<a title="全部" href="#">芒果</a>
						<a title="全部" href="#">樱桃</a>
						<a title="全部" href="#">苹果</a> -->
						</c:forEach>
						<a title="全部" href="<%=path%>/webHome/toList.action?pid=${tid}&flag=0">其它</a>
					  </span>
						</dd>
					</dl>
				</li>
				<li class="select-list">
					<dl id="select2">
						<dt>规格：</dt>
						<dd class="fList ">
					  <span class="L01">
						<a <c:if test="${flag==0 }">class="select-all selected"</c:if>  href="<%=path%>/webHome/toList.action?pid=${tid}&flag=0">全部</a>
						<c:forEach items="${top }" var="s">
							<c:forEach items="${s.lbgoods }" var="b">						
						<a title="全部" <c:if test="${b.id==goodsid }">class="select-all selected"</c:if> href="<%=path%>/webHome/toList.action?typeid=${typeid }&pid=${s.pid}&kg=${b.weight }&dw=${b.unit }&goodsid=${b.id }&flag=1">${b.weight }${b.unit }</a>
						<!-- <a title="全部" href="#">1kg</a>
						<a title="全部" href="#">5kg</a>
						<a title="全部" href="#">2kg</a> -->
						</c:forEach>
						</c:forEach>
					  </span>
						</dd>
					</dl>
				</li>
				<li class="select-result">
					<dl>
						<dt>已选条件：</dt>
						<dd>
							<a class="select-no">暂时没有选择过滤条件</a>
						</dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
</div>
<script type="text/javascript">
$(function(){
	if($(".selected").text()!="全部全部"){
	$(".select-no").text($(".selected").text());
	
	}
	

})

</script>


<!--查询条件结束-->


<div class="shopMainbg">
	<div class="shopMain" id="shopmain">
		<div id="f1">
			<!--甜点-->


			<div class="am-g am-g-fixed floodFour">
		<c:forEach items="${page.page.list }" var="s">
			<c:forEach items="${s.lbgoods }" var="go">			
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							${go.goodsname }
						</div>
						<div class="sub-title ">
							¥${go.price }
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate" goods_id="${go.id }"></i>
					</div>
					<a href="<%=path%>/webHome/info/${go.id}.action"><img src="<%=path %>/upload/${go.indeximg }" /></a>
				</div>
	</c:forEach>
	</c:forEach>
	<!-- 			<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>

				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				<div class="am-u-sm-7 am-u-md-4 text-two">
					<div class="outer-con ">
						<div class="title ">
							雪之恋和风大福
						</div>
						<div class="sub-title ">
							¥13.8
						</div>
						<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
					</div>
					<a href="# "><img src="images/2.jpg" /></a>
				</div>
				 -->
			</div>
			<div id="page">${page.pageStr }</div>
			<div class="clear "></div>
		</div>
<div style="clear:both"></div>

<script type="text/javascript">
	$(".seprate").click(function(){
					var id = $(this).attr("goods_id");
					var cid ='${customer.id}'	
					//获取滚动条位置
					if(cid==null||cid==''){
						alert("请先登录");
						location.href ="../web/login.action";
					
						}
						$.ajax({
						 url:"bcatrt.action",
						 type: "GET",
			             data:"goodsid="+id,
			             success: function(data){
							$(".cart_num").text(data)
							alert("添加成功")
							}
						})
					})

</script>
<div class="foo " >
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
<!--菜单 -->
<div class=tip>
			<div id="sidebar">
				<div id="wrap">
					<div id="prof" class="item ">
						<a href="<%=path %>/web/information.action">
							<span class="setting "></span>
						</a>
						<div class="ibar_login_box status_login ">
							<div class="avatar_box ">
								<p class="avatar_imgbox "><img src="<%=path %>/web/images/no-img_mid_.jpg " /></p>
								<ul class="user_info ">
									<li> ${sessionScope.customer.nickname }</li>
									<li>级&nbsp;别：金牌会员</li>
								</ul>
							</div>
							<div class="login_btnbox ">
								<a href="# " class="login_order ">我的订单</a>
								<a href="<%=path %>/webCollection/toCollection.action" class="login_favorite ">我的收藏</a>
							</div>
							<i class="icon_arrow_white "></i>
						</div>

					</div>
					<div id="shopCart " class="item ">
						<a href="<%=path %>/webshopcart/enter.action?type=1 ">
							<span class="message "></span>
						</a>
						<p>
							购物车
						</p>
						<p class="cart_num ">${num }</p>
					</div>
					<div id="asset " class="item ">
						<a href="../webbill/billAll.action">
							<span class="view "></span>
						</a>
						<div class="mp_tooltip ">
							我的资产
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="foot " class="item ">
						<a href="<%=path%>/webfoot/foot.action?cuid=${sessionScope.customer.id }">
							<span class="zuji "></span>
						</a>
						<div class="mp_tooltip ">
							我的足迹
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="brand " class="item ">
						<a href="<%=path %>/webCollection/toCollection.action">
							<span class="wdsc "><img src="<%=path %>/web/images/wdsc.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我的收藏
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div id="broadcast " class="item ">
						<a href="# ">
							<span class="chongzhi "><img src="<%=path %>/web/images/chongzhi.png " /></span>
						</a>
						<div class="mp_tooltip ">
							我要充值
							<i class="icon_arrow_right_black "></i>
						</div>
					</div>

					<div class="quick_toggle ">
						<li class="qtitem ">
							<a href="http://wpa.qq.com/msgrd?uin=14300126"><span class="kfzx "></span></a>
							<div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
						</li>
						<!--二维码 -->
						<li class="qtitem ">
							<a href="#none "><span class="mpbtn_qrcode "></span></a>
							<div class="mp_qrcode " style="display:none; "><img src="<%=path %>/web/images/0.jpg" /><i class="icon_arrow_white "></i></div>
						</li>
						<li class="qtitem ">
							<a href="#top" class="return_top "><span class="top "></span></a>
						</li>
					</div>

					<!--回到顶部 -->
					<div id="quick_links_pop " class="quick_links_pop hide "></div>

				</div>

			</div>
			<div id="prof-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					我
				</div>
			</div>
			<div id="shopCart-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					购物车
				</div>
			</div>
			<div id="asset-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					资产
				</div>

				<div class="ia-head-list ">
					<a href="# " target="_blank " class="pl ">
						<div class="num ">0</div>
						<div class="text ">优惠券</div>
					</a>
					<a href="# " target="_blank " class="pl ">
						<div class="num ">0</div>
						<div class="text ">红包</div>
					</a>
					<a href="# " target="_blank " class="pl money ">
						<div class="num ">￥0</div>
						<div class="text ">余额</div>
					</a>
				</div>

			</div>
			<div id="foot-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					足迹
				</div>
			</div>
			<div id="brand-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					收藏
				</div>
			</div>
			<div id="broadcast-content " class="nav-content ">
				<div class="nav-con-close ">
					<i class="am-icon-angle-right am-icon-fw "></i>
				</div>
				<div>
					充值
				</div>
			</div>
		</div>
</form>
</body>

</html>
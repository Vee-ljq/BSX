<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>新闻页面</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  
   <link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
   <link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
   <link href="<%=path %>/web/css/personal.css" rel="stylesheet" type="text/css">
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
<!--文章 -->
<div class="am-g am-g-fixed blog-g-fixed bloglist">
  <div class="am-u-md-9">
    <article class="blog-main">
    ${activityInfo.context.context }
    </article>


    <hr class="am-article-divider blog-hr">
    <ul class="am-pagination blog-pagination">
      <li class="am-pagination-prev"><a href="">&laquo; 上一页</a></li>
      <li class="am-pagination-next"><a href="">下一页 &raquo;</a></li>
    </ul>
  </div>

  <div class="am-u-md-3 blog-sidebar">
    <div class="am-panel-group">

      <section class="am-panel am-panel-default">
        <div class="am-panel-hd">热门话题</div>
        <ul class="am-list blog-list">
        	<li><a href="#"><p>[特惠]闺蜜喊你来囤国货啦</p></a></li>  
          <li><a href="#"><p>[公告]华北、华中部分地区配送延迟</p></a></li>
          <li><a href="#"><p>[特惠]家电狂欢千亿礼券 买1送1！</p></a></li>
          <li><a href="#"><p>[公告]商城与广州市签署战略合作协议</p></a></li>
          <li><a href="#"><p>[特惠]洋河年末大促，低至两件五折</p></a></li>      
        </ul>
      </section>

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

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="{{assets}}js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</body>
</html>

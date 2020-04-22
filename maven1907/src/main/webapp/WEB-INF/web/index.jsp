<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="<%=path %>/web/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="<%=path %>/web/css/hmstyle.css" rel="stylesheet" type="text/css"/>
		<link href="<%=path %>/web/css/skin.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/web/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="<%=path %>/web/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	<style type="text/css">
	  .str_wrap{
	  padding-left: 1em;
	  padding-right: 1em;
	  background: #fefefe;
	 
	  line-height: 3em;
	  font-size: 1.2em;
	  height: 200px
	}
	
	.wrap{
	 height: 3em;
	}
	</style>

	<script type="text/javascript" src="<%=path %>/js/jiaoben5013/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jiaoben5013/js/jquery.liMarquee.js"></script>
	<link rel="stylesheet" href="<%=path %>/js/jiaoben5013/css/default.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=path %>/js/jiaoben5013/css/liMarquee.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=path %>/js/jiaoben5013/css/normalize.css" type="text/css"></link>
	</head>

	<body>
		<div class="hmtop" >
		<a href="#" name="top"></a>
			<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<c:if test="${empty sessionScope.customer.nickname }">
					<div class="topMessage">
						<div class="menu-hd">
						
							<a href="<%=path %>/web/login.action" target="_top" class="h">亲，请登录</a>
							<a href="<%=path %>/web/register.action" target="_top">免费注册</a>
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

					<div class="logoBig">
						<li class=""><img src="<%=path %>/web/images/suntubiao.png" width="159" height="78"></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="<%=path%>/webHome/toList.action">
							<input type="hidden" name="sflag" value="3">
							<input id="searchInput" name="tiaojian" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			<div class="banner">
                      <!--轮播 -->
						<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
							<ul class="am-slides">
							<c:forEach items="${slidegoods }" var="s" varStatus="status">
							<c:if test="${status.count<=3 }">
							<li class="banner${status.count }"><a href="<%=path%>/webHome/info/${s.goodsid}.action" ><img src="<%=path%>/upload/${s.bgoods.lbpic}" /></a></li>
							</c:if>
							</c:forEach>
								<%-- <li class="banner1"><a href="introduction.jsp"><img src="images/ad1.jpg" /></a></li>
								<li class="banner2"><a><img src="<%=path%>/web/${s.lbpic}" /></a></li>
								<li class="banner3"><a><img src="images/ad3.jpg" /></a></li>
								<li class="banner4"><a><img src="images/ad4.jpg" /></a></li> --%>

							</ul>
						</div>
						<div class="clear"></div>	
			</div>
			<div class="shopNav">
				<div class="slideall">
					
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">活动专场</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>					
		        				
						<!--侧边导航 -->
						<div id="nav" class="navfull">
							<div class="area clearfix">
								<div class="category-content" id="guide_2">
									
									<div class="category">
										<ul class="category-list" id="js_climit_li">
										<c:forEach items="${classOne }" var="one">
											<li class="appliance js_toggle relative first" style="height: 43px">
												<div class="category-info" one_id="${one.id }" >
													<h3 class="category-name b-category-name" ><i><img src="<%=path%>/web/images/${one.param1}"></i><a class="ml-22" title="${one.typename }" href='<%=path%>/webHome/toList.action?pid=${one.id}&flag=0'">${one.typename }</a></h3>
													<em>&gt;</em></div>
												<div class="menu-item menu-in top">
													<div class="area-in">
														<div class="area-bg">
															<div class="menu-srot">
																<div class="sort-side">
																	<dl class="dl-sort">
																		
																	</dl>
																</div>
															</div>
														</div>
													</div>
												</div>
											<b class="arrow"></b>	
											</li>
											</c:forEach>
										</ul>
									</div>
								</div>

							</div>
						</div>
						<!--异步获取二三级菜单  -->
						<script type="text/javascript">
						$(function(){
						 $(".category-info").mouseover(function(){
						 var id = $(this).attr("one_id");
						// alert(id)
							$.ajax({	
							 type: "post",
				             url: "../webHome/goodsCategory.action",
				             data:"id="+id,
				             success: function(data){
				             		$(".sort-side").empty();
				             		var str ="";
				             		for(var i = 0 ; i<data.length;i++){
									str= "<dl class="+"dl-sort"+"><dt><span title="+data[i].typename+">"+data[i].typename+"</span></dt>";
				             			for(var j=0;j<data[i].lbgoods.length;j++){
				             			str+= "<dd><a title="+data[i].lbgoods[j].goodsname+" href='<%=path%>/webHome/toList.action?goodsid="+data[i].lbgoods[j].id+"&goodsname="+data[i].lbgoods[j].goodsname+"'><span>"+data[i].lbgoods[j].goodsname+"</span></a></dd>";
				             			}
				             		str+="</dl>";
				             		$(".sort-side").append(str);
				             		}
				             	}
				             	});
				   
						})
						
						
						})
						
						</script>
						
						<!--轮播-->
						
						<script type="text/javascript">
							(function() {
								$('.am-slider').flexslider();
							});
							$(document).ready(function() {
								$("li").hover(function() {
									$(".category-content .category-list li.first .menu-in").css("display", "none");
									$(".category-content .category-list li.first").removeClass("hover");
									$(this).addClass("hover");
									$(this).children("div.menu-in").css("display", "block")
								}, function() {
									$(this).removeClass("hover")
									$(this).children("div.menu-in").css("display", "none")
								});
							})
						</script>




					<!--走马灯 -->

					<div class="marqueen">
						<span class="marqueen-title">商城头条</span>
		<div class="jq22-container">
							<ul class="str1 str_wrap" >
						<c:forEach items="${bmdto}" var="bm" varStatus="status">
								<li class="title-first wrap"><a target="_blank" href="<%=path%>/webHome/info/${bm.id}.action">
									<!-- <img src="images/TJ2.jpg"></img> -->
									<span>[${bm.titile }]</span>${bm.content }	
								</a></li>
								<!-- <li class="title-first"><a target="_blank" href="#">
									<span>[公告]</span>商城与广州市签署战略合作协议
								     <img src="images/TJ.jpg"></img>
							    </a></li>
							    
								<li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a></li>
								<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
								<li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券 买1送1！</a></li> -->
								</c:forEach>
							</ul>
                        <div class="advTip"><img src="<%=path %>/web/images/advTip.jpg"/></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<script type="text/javascript">
				$(window).load(function(){
					$('.str1').liMarquee({
						direction: 'up'	
					});
				});

					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
			</div>
			<div class="shopMainbg">
				<div class="shopMain" id="shopmain">

					<!--今日推荐 -->

					<div class="am-g am-g-fixed recommendation">
						<div class="clock am-u-sm-3">
							<img src="<%=path %>/web/images/2016.png "></img>
							<p>今日<br>推荐</p>
						</div>
					<c:forEach items="${BFloorgoods}" var="bf" varStatus="status">
					<c:if test="${status.index<=2 }">
						<div class="am-u-sm-4 am-u-lg-3 ">
							<div class="info ">
								<h3>真的有鱼</h3>
								<h4>开年福利篇</h4>
							</div>
							<div class="recommendationMain one">
								<a href="<%=path%>/webHome/info/${bf.goodsid}.action"><img src="<%=path %>/upload/${bf.bGoods.indeximg }"></img></a>
							</div>
						</div>	
						</c:if>
						</c:forEach>						
						<!-- <div class="am-u-sm-4 am-u-lg-3 ">
							<div class="info ">
								<h3>囤货过冬</h3>
								<h4>让爱早回家</h4>
							</div>
							<div class="recommendationMain two">
								<img src="images/tj1.png "></img>
							</div>
						</div>
						<div class="am-u-sm-4 am-u-lg-3 ">
							<div class="info ">
								<h3>浪漫情人节</h3>
								<h4>甜甜蜜蜜</h4>
							</div>
							<div class="recommendationMain three">
								<img src="images/tj2.png "></img>
							</div>
						</div> -->

					</div>
					<div class="clear "></div>
					<!--热门活动 -->

					<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>活动</h4>
							<h3>每期活动 优惠享不停 </h3>
							<span class="more ">
                              <a href="list.jsp ">全部活动<i class="am-icon-angle-right" style="padding-left:10px ;" ></i></a>
                        </span>
						</div>
					  <div class="am-g am-g-fixed ">
						<div class="am-u-sm-3 ">
							<div class="icon-sale one "></div>	
								<h4>秒杀</h4>							
	
							<div class="activityMain ">

                                
								<a href="<%=path%>/webHot/toHot/${sgGoods.goodsid}.action"><img src="<%=path %>/upload/015505c1-1274-4333-bfb0-c527b004a592.jpg"></img></a>


							</div>
							<div class="info ">
								<h3>${sgGoods.context.context }</h3>
							</div>														
						</div>
						<c:forEach items="${hdGoods }" var="hd" varStatus="status">
							<c:if test="${status.index<=1 }">
							<c:choose>
								<c:when test="${status.index==0 }">
								<div class="am-u-sm-3 ">
								  <div class="icon-sale two "></div>	
									<h4>特惠</h4>
									<div class="activityMain ">
										<a href="<%=path%>/webHome/info/${hd.goodsid}.action"><img src="<%=path %>/upload/${hd.goods.indeximg }"></img></a>
									</div>
									<div class="info ">
										<h3>${hd.context.context }</h3>								
									</div>							
								</div>	
								</c:when>
								<c:otherwise>
										<div class="am-u-sm-3 last ">
											<div class="icon-sale "></div>
											<h4>超值</h4>
											<div class="activityMain ">
											<a href="<%=path%>/webHome/info/${hd.goodsid}.action"><img src="<%=path %>/upload/${hd.goods.indeximg }"></img></a>
											</div>
											<div class="info ">
												<h3>${hd.context.context }</h3>
											</div>													
										</div>					
								</c:otherwise>
							</c:choose>
							</c:if>
						</c:forEach>
						<div class="am-u-sm-3 ">
							<div class="icon-sale three "></div>
							<h4>团购</h4>
							<div class="activityMain ">
								<a href="<%=path%>/webHome/info/${tgGoods.goodsid}.action"><img src="<%=path %>/upload/${tgGoods.goods.indeximg }"></img></a>
							</div>
							<div class="info ">
								<h3>${tgGoods.context.context }</h3>
							</div>							
						</div>						
					  </div>
                   </div>
					<div class="clear "></div>

				<c:forEach items="${allgoods }" var="sp" varStatus="status">
				<c:if test="${status.index<=4 }">
				
                    <div id="f<c:choose><c:when test="${status.count<=10}">${status.count}</c:when><c:otherwise>1</c:otherwise></c:choose>">
					<!--甜点-->
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>${sp.typename }</h4>
							<h3>每一道甜品都有一个故事</h3>
							<div class="today-brands ">
							<c:forEach items="${sp.lbgoods }" var="xp">
								<a href="<%=path%>/webHome/info/${xp.id}.action">${xp.goodsname }</a>
								</c:forEach>
							</div>
							<span class="more ">
                    <a href="# ">更多美味<i class="am-icon-angle-right" style="padding-left:10px ;" ></i></a>
                        </span>
						</div>
					</div>
					
					<div class="am-g am-g-fixed floodFour">
						<div class="am-u-sm-5 am-u-md-4 text-one list ">
							<div class="word">
							<c:forEach items="${sp.lbgoods }" var="xp" varStatus="status">
								<c:if test="${status.index<=5 }">
								<a class="outer" href="<%=path%>/webHome/info/${xp.id}.action"><span class="inner"><b class="text">${xp.goodsname }</b></span></a>
								</c:if>
								</c:forEach>								
							</div>
							<a href="# ">
								<div class="outer-con ">
									<div class="title ">
									开抢啦！
									</div>
									<div class="sub-title ">
										零食大礼包
									</div>									
								</div>
                                  <img src="<%=path %>/web/images/act1.png " />								
							</a>
							<div class="triangle-topright"></div>						
						</div>
							<c:forEach items="${sp.lbgoods }" var="spx" varStatus="status">
								<c:if test="${status.index<=5 }">
							<div class="am-u-sm-7 am-u-md-4 <c:choose>
								<c:when test="${status.index==0}">
								 text-two sug
								</c:when>
								<c:when test="${status.index==4}">
								 text-three sug
								</c:when>
								<c:when test="${status.index==1 or status.index==3 }">
								 text-two 
								</c:when>
								<c:when test="${status.index==2}">
								text-three big
								</c:when>
								<c:when test="${status.index==5}">
								text-three last big
								</c:when>
							</c:choose>">
								<div class="outer-con ">
									<div class="title ">
										${spx.goodsname }
									</div>									
									<div class="sub-title ">
										¥${spx.price }
									</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate" goods_id="${spx.id}"></i>
								</div>
								<a href="../webgoodsxq/data.action?id=2"><img src="images/2.jpg" /></a>
								<a href="../goodsxq/data.action"><img src="images/2.jpg" /></a>
								<a href="<%=path%>/webHome/info/${spx.id}.action"><img src="<%=path %>/upload/${spx.indeximg}" /></a>
							</div>
							</c:if>
							</c:forEach>
                 <div class="clear "></div>  
                 </div>
                 </c:if>
                 </c:forEach>
					<div class="clear "></div>
					</div>
					<script type="text/javascript">
					$(function(){
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
					})
					</script>

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
   


		</div>
		</div>
		<!--引导 -->
		<div class="navCir">
			<li class="active"><a href="home.jsp"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.jsp"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.jsp"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="person/index.jsp"><i class="am-icon-user"></i>我的</a></li>					
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
								<p class="avatar_imgbox "><img src="<%=path %>/upload/${sessionScope.customer.url } " /></p>
								<ul class="user_info ">
									<li> ${sessionScope.customer.nickname }</li>
									<li>级&nbsp;别：金牌会员</li>
								</ul>
							</div>
							<div class="login_btnbox ">
								<a href="<%=path %>/web/allOrderData.action " class="login_order ">我的订单</a>
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
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="<%=path %>/web/basic/js/quick_links.js "></script>
	</body>

</html>
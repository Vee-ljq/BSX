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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>

		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="<%=path %>/web/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="<%=path %>/web/css/style.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=path %>/web/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>

		<script type="text/javascript" src="<%=path %>/web/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="<%=path %>/web/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		
		<script type="text/javascript" src="<%=path %>/web/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="<%=path %>/web/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="<%=path %>/web/js/list.js"></script>
			<link rel="stylesheet" href="<%=path %>/js/ace/css/ace.css" media="all" />
 	<link rel="stylesheet" href="<%=path%>/js/ace/css/bootstrap.css"/>
	</head>

	<body>


		<!--顶部导航条 -->
	<div class="hmtop">
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
            <b class="line"></b>
			<div class="listMain">

				<!--分类-->
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a style="width:100px;height:50px" href="#">首页</a></li>
                                <li class="qc"><a  style="width:100px;height:50px" href="#">闪购</a></li>
                                <li class="qc"><a style="width:110px;height:50px" href="#">限时抢</a></li>
                                <li class="qc"><a style="width:100px;height:50px" href="#">团购</a></li>
                                <li class="qc last"><a style="width:100px;height:50px" href="#">大包装</a></li>
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
				<div class="scoll">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<img src="<%=path %>/web/images/01.jpg" title="pic" />
								</li>
								<li>
									<img src="<%=path %>/web/images/02.jpg" />
								</li>
								<li>
									<img src="<%=path %>/web/images/03.jpg" />
								</li>
							</ul>
						</div>
					</section>
				</div>

				<!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<a href="<%=path %>/web/images/01.jpg"><img src="<%=path %>/web/images/01_mid.jpg" alt="细节展示放大镜特效" rel="<%=path %>/web/images/01.jpg" class="jqzoom" /></a>
							</div>
							<ul class="tb-thumb" id="thumblist">
								<!-- <li class="tb-selected"> -->
									<c:forEach items="${goodspic }" end="2" var="g">
											<li <c:if test="${g.isfirst==0 }">class="tb-selected"</c:if>>
												<div class="tb-pic tb-s40">
													<a href="#"><img src="<%=path %>/upload/${g.url }"  mid="<%=path %>/upload/${g.url }" big="<%=path %>/upload/${g.url }"></a>
												</div>
										</li>
									</c:forEach>
									<%-- <div class="tb-pic tb-s40">
										<a href="#"><img src="${ }" mid="images/01_mid.jpg" big="images/01.jpg"></a>
									</div> --%>
								<!-- </li> -->
								
								<%-- <li>
									<div class="tb-pic tb-s40">
										<a href="#"><img src="<%=path %>/web/images/03_small.jpg" mid="images/03_mid.jpg" big="images/03.jpg"></a>
									</div>
								</li> --%>
							</ul>
						</div>

						<div class="clear"></div>
					</div>

					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>	
				 ${goods.goodsname }
	          </h1>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price">
								<li class="price iteminfo_price">
									<dt>促销价</dt>
									<dd><em>¥</em><b class="sys_item_price">${goods.price }</b>  </dd>                                 
								</li>
								<li class="price iteminfo_mktprice">
									<dt>原价</dt>
									<dd><em>¥</em><b class="sys_item_mktprice">${goods.ckprice }</b></dd>									
								</li>
								<div class="clear"></div>
							</div>

							<!--地址-->
							<dl class="iteminfo_parameter freight">
								<dt>配送至</dt>
								<div class="iteminfo_freprice">
									<div class="am-form-content address">
										<select data-am-selected id="provinceid" onchange="province()">
											<c:forEach items="${provinces }" var="pp">
												<option value="${pp.codeid }">${pp.cityname }</option>
											</c:forEach>
										</select>
										<select data-am-selected id="cityid" onchange="city()">
											<option value="" style="display:none">请选择市</option>
										</select>
										<select data-am-selected id="xianid">
											<option value="" style="display:none">请选择县</option>
										</select>
									</div>
									<div class="pay-logis">
										快递<b class="sys_item_freprice">10</b>元
									</div>
								</div>
							</dl>
							<div class="clear"></div>

							<!--销量-->
							<ul class="tm-ind-panel">
								<li class="tm-ind-item tm-ind-sellCount canClick">
									<div class="tm-indcon"><span class="tm-label">月销量</span><span class="tm-count">${monthCount }</span></div>
								</li>
								<li class="tm-ind-item tm-ind-sumCount canClick">
									<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">${goodsCount }</span></div>
								</li>
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">${GoodsComments }</span></div>
								</li>
							</ul>
							<div class="clear"></div>

							<!--各种规格-->
							<dl class="iteminfo_parameter sys_item_specpara">
								<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
								<dd>
									<!--操作页面-->

									<div class="theme-popover-mask"></div>

									<div class="theme-popover">
										<div class="theme-span"></div>
										<div class="theme-poptit">
											<a href="javascript:;" title="关闭" class="close">×</a>
										</div>
										<div class="theme-popbod dform">
											<form class="theme-signin" name="loginform" action="" method="post">

												<div class="theme-signin-left">

													<div class="theme-options">
														<div class="cart-title">口味</div>
														<ul>
															<c:forEach items="${taste }" var="tt">
															<li value="${tt.id }"  class="taste sku-line <c:if test="${tt.id==1 }">selected</c:if>" 
															>${tt.typename }<i></i></li>
															</c:forEach>
														</ul>
													</div>
													<div class="theme-options">
														<div class="cart-title">包装</div>
														
														<ul>
															<c:forEach items="${package1 }" var="pp">
																<li value="${pp.id }"  class="package sku-line <c:if test="${pp.id==1 }">selected</c:if>">${pp.typename }<i></i></li>
															</c:forEach>
														</ul>
													</div>
													<div class="theme-options">
														<div class="cart-title number">数量</div>
														<dd>
															<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />
															<input id="text_box" name="" type="text" value="1" style="width:30px;" />
															<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />
															<span id="Stock" class="tb-hidden">库存<span class="stock">${goods.storenum }</span>件</span>
														</dd>

													</div>
													<div class="clear"></div>

													<div class="btn-op">
														<div class="btn am-btn am-btn-warning">确认</div>
														<div class="btn close am-btn am-btn-warning">取消</div>
													</div>
												</div>
												<div class="theme-signin-right">
													<div class="img-info">
														<img src="<%=path %>/web/images/songzi.jpg" />
													</div>
													<div class="text-info">
														<span class="J_Price price-now">¥39.00</span>
														<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
													</div>
												</div>

											</form>
										</div>
									</div>

								</dd>
							</dl>
							<div class="clear"></div>
							<!--活动	-->
							<div class="shopPromotion gold">
								<div class="hot">
									<dt class="tb-metatit">店铺优惠</dt>
									<div class="gold-list">
										<p>购物满2件打8折，满3件7折<span></span></p>
									</div>
								</div>
								<div class="clear"></div>

							</div>
						</div>

						<div class="pay">
							<div class="pay-opt">
							<a href="home.jsp"><span class="am-icon-home am-icon-fw">首页</span></a>
							<a><span class="am-icon-heart am-icon-fw">收藏</span></a>
							
							</div>
							<li>
								<div class="clearfix tb-btn tb-btn-buy theme-login">
									<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="<%=path%>/webAlipay/nowBuy.action?goodsid=${goods.id}&custid=${sessionScope.customer.id}">立即购买</a>
								</div>
							</li>
							<li>
								<div class="clearfix tb-btn tb-btn-basket theme-login">
									<a id="LikBasket" title="加入购物车"><i></i>加入购物车</a>
								</div>
							</li>
						</div>

					</div>

					<div class="clear"></div>

				</div>

				<div class="clear"></div>
				
							
				<!-- introduce-->

				<div class="introduce">
					<div class="browse">
					    <div class="mc"> 
						     <ul>					    
						     	<div class="mt">            
						            <h2>看了又看</h2>        
					            </div>
						     	<c:forEach items="${goodspic }" var="g">
						     		<li class="first">
							      	<div class="p-img">                    
							      		<a  href="#"> <img class="" src="<%=path %>/upload/${g.url}"> </a>               
							      	</div>
							      	<div class="p-name"><a href="#">
							      		【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味
							      	</a>
							      	</div>
							      	<div class="p-price"><strong>￥35.90</strong></div>
							      </li>
						     	</c:forEach>
							     	      
					      
						     </ul>					
					    </div>
					</div>
					<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<a href="#">

										<span class="index-needs-dt-txt">宝贝详情</span></a>

								</li>

								<li>
									<a href="#">

										<span class="index-needs-dt-txt">全部评价</span></a>

								</li>

								<li>
									<a href="#">

										<span class="index-needs-dt-txt">猜你喜欢</span></a>
								</li>
							</ul>

							<div class="am-tabs-bd">

								<div class="am-tab-panel am-fade am-in am-active">
									<div class="J_Brand">

										<div class="attr-list-hd tm-clear">
											<h4>产品参数：</h4></div>
										<div class="clear"></div>
										<ul id="J_AttrUL">
											<li title="">${goods.goodsinfo }</li>
											
										</ul>
										<div class="clear"></div>
									</div>

									<div class="details">
										<div class="attr-list-hd after-market-hd">
											<h4>商品细节</h4>
										</div>
										<div class="twlistNews">	
											<c:forEach items="${goodspic }" var="g">
													<img src="<%=path %>/upload/${g.url}" />
											</c:forEach>
											
										</div>
									</div>
									<div class="clear"></div>

								</div>
								<!-- 商品评论 -->
								<div class="am-tab-panel am-fade">
									
                                    <div class="actor-new">
                                    	<div class="rate">                
                                    		<strong>100<span>%</span></strong><br> <span>好评度</span>            
                                    	</div>
                                        <dl>                    
                                            <dt>买家印象</dt>                    
                                            <dd class="p-bfc">
                                            			<q class="comm-tags"><span>味道不错</span><em>(2177)</em></q>
                                            			<q class="comm-tags"><span>颗粒饱满</span><em>(1860)</em></q>
                                            			<q class="comm-tags"><span>口感好</span><em>(1823)</em></q>
                                            			<q class="comm-tags"><span>商品不错</span><em>(1689)</em></q>
                                            			<q class="comm-tags"><span>香脆可口</span><em>(1488)</em></q>
                                            			<q class="comm-tags"><span>个个开口</span><em>(1392)</em></q>
                                            			<q class="comm-tags"><span>价格便宜</span><em>(1119)</em></q>
                                            			<q class="comm-tags"><span>特价买的</span><em>(865)</em></q>
                                            			<q class="comm-tags"><span>皮很薄</span><em>(831)</em></q> 
                                            </dd>                                           
                                         </dl> 
                                    </div>	
                                    <div class="clear"></div>
									<div class="tb-r-filter-bar">
										<ul class=" tb-taglist am-avg-sm-4">
											<li class="tb-taglist-li tb-taglist-li-current">
												<div class="comment-info">
													<span>全部评价</span>
													<span class="tb-tbcr-num">(${commentCount })</span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li-1">
												<div class="comment-info">
													<span>好评</span>
													<span class="tb-tbcr-num">(${bestComment })</span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li-0">
												<div class="comment-info">
													<span>中评</span>
													<span class="tb-tbcr-num">(${midComment })</span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li--1">
												<div class="comment-info">
													<span>差评</span>
													<span class="tb-tbcr-num">(${badComment })</span>
												</div>
											</li>
										</ul>
									</div>
									<div class="clear"></div>

									<ul class="am-comments-list am-comments-list-flip">
										<c:forEach items="${page.page.list }" var="c">
											<li class="am-comment">
											<!-- 评论容器 -->
											<a href="">
												<img class="am-comment-avatar" src="<%=path %>/upload/${c.customer.url }" />
												<!-- 评论者头像 -->
											</a>

											<div class="am-comment-main">
												<!-- 评论内容容器 -->
												<header class="am-comment-hd">
													<!--<h3 class="am-comment-title">评论标题</h3>-->
													<div class="am-comment-meta">
														<!-- 评论元数据 -->
														<a href="#link-to-user" class="am-comment-author">${c.customer.nickname }</a>
														<!-- 评论者 -->
														评论于
														<time datetime="">${c.createdate }</time>
													</div>
												</header>

												<div class="am-comment-bd">
													<div class="tb-rev-item " data-id="255776406962">
														<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
															${c.comment }
														</div>
														<div class="tb-r-act-bar">
															颜色分类：柠檬黄&nbsp;&nbsp;尺码：S
														</div>
													</div>

												</div>
												<!-- 评论内容 -->
											</div>
										</li>
										</c:forEach>

									</ul>
									<div id="page">${page.pageStr }</div>
									<div class="clear"></div>

									

									<div class="tb-reviewsft">
										<div class="tb-rate-alert type-attention">购买前请查看该商品的 <a href="#" target="_blank">购物保障</a>，明确您的售后保障权益。</div>
									</div>

								</div>

								<div class="am-tab-panel am-fade">
									<div class="like">
										<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
											<c:forEach items="${bGoodsViewDtos }" var="b">
												<li>
												<div class="i-pic limit">
													<img src="<%=path %>/upload/${b.bGoodsWithBLOBs.indeximg }" />
													<p>${b.bGoodsWithBLOBs.goodsinfo }</p>
													<p class="price fl">
														<b>¥</b>
														<strong>${b.bGoodsWithBLOBs.price } </strong>
													</p>
												</div>
											</li>
											</c:forEach>
											
										</ul>
									</div>
									<div class="clear"></div>
									
								</div>

							</div>

						</div>

						<div class="clear"></div>


					</div>

				</div>
			</div>
		<div style="clear:both"></div>
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

	</body>
	<script type="text/javascript">
		function province(){
			var provinceid = $("#provinceid").val();
			alert(provinceid)	
			$("#cityid").empty();
			$("#xianid").empty();
			$.ajax({
				type: "GET",
	             url: "proTocityToxian.action",
	             data:"id="+provinceid,
	             success: function(data){
	             	alert("已经获取到数据")
	             	$.each(data,function(i,result){
	             		
	             		//$("#city").append("<option></option>");
	             		 $("#cityid").append("<option value='"+result.codeid+"'>"+result.cityname+"</option>");	 
	             	});
              }
	});
		}
	function city(){
			var cityid = $("#cityid").val();
			alert(cityid)	
			$("#xianid").empty();
			$.ajax({
				type: "GET",
	             url: "proTocityToxian.action",
	             data:"id="+cityid,
	             success: function(data){
	             	alert("已经获取到数据")
	             	$.each(data,function(i,result){
	             		
	             		//$("#city").append("<option></option>");
	             		 $("#xianid").append("<option value='"+result.codeid+"'>"+result.cityname+"</option>");	 
	             	});
              }
	});
		}
		var tasteid = 0;
		$(".taste").click(function(){
				tasteid = $(this).attr("value");
				alert("口味id"+tasteid)
			});
			var packageid = 0;
		$(".package").click(function(){
				packageid = $(this).attr("value");
				alert("包装id"+packageid)
			});
		$("#LikBasket").click(function(){
			var num  = $("#text_box").val();
			alert("商品的数量"+num)
			$("#LikBasket").attr("href","../webshopcart/enter.action?tasteid="+tasteid+"&packageid="+packageid+"&goodsid=${goods.id}&num="+num+"&type=2");
		});
		
		
	</script>
</html>
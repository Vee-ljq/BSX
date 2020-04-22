<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单管理</title>

		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>
	<script type="text/javascript">
		$(function(){
			$("#reminber").click(function(){
				alert("已提醒商家发货");
			});
			$("#reminber2").click(function(){
				alert("已提醒商家发货");
			});
		});
		
	</script>
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

					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">所有订单</a></li>
								<li><a href="#tab2">待付款</a></li>
								<li><a href="#tab3">待发货</a></li>
								<li><a href="#tab4">待收货</a></li>
								<li><a href="#tab5">待评价</a></li>
							</ul>

							<div class="am-tabs-bd">
							<!-- ********* 所有订单  ********** -->
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-
">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<div class="order-status5">
												<c:forEach items="${allOrders }" var="allOrders">
													<div class="order-title">
													
														<div class="dd-num">订单编号：<a href="javascript:;">${allOrders.orderno }</a></div>
														<span>成交时间：${allOrders.createdate }</span>
														<!--    <em>店铺：小桔灯</em>-->
													</div>
												
												<div class="order-content">
												
													<div class="order-left">
														<c:forEach items="${allOrders.orderdetail }" var="orderdetail">
															<ul class="item-list">
															
																<li class="td td-item">
																	<div class="item-pic">
																		<a href="#" class="J_MakePoint">
																			<img src="images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
																		</a>
																	</div>
																	<div class="item-info">
																		<div class="item-basic-info">
																			<a href="#">
																				<p>${orderdetail.goods.goodsname }</p>
																				<p class="info-little">口味：${orderdetail.goods.tastetypes[0].typename }
																					<br/>包装：${orderdetail.goods.packagetypes[0].typename }</p>
																			</a>
																		</div>
																	</div>
																</li>
																<li class="td td-price">
																	<div class="item-price">
																		${orderdetail.price }
																	</div>
																</li>
																<li class="td td-number">
																	<div class="item-number">
																		<span>×</span>${orderdetail.num }
																	</div>
																</li>
																<li class="td td-operation">
																	<div class="item-operation">
																		
																	</div>
																</li>
																
															</ul>
														</c:forEach>		
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${allOrders.totalcount }
																<p>含运费：<span>10.00</span></p>
															</div>
														</li>
														
														<c:if test="${allOrders.status==-1 }">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus"></p>
																		<p class="order-info">交易关闭</p>
																	</div>
																</li>
																<li class="td td-change">
																<a href="<%=path %>/web/updateOrderStatus.action?orderid=${allOrders.id}&status=-2">
																	<div class="am-btn am-btn-danger anniu">
																		删除订单
																	</div>
																</a>
																</li>
															</div>
														</c:if>
														<c:if test="${allOrders.status==0 }">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">等待买家付款</p>
																		<p class="order-info"><a href="#">取消订单</a></p>			
																	</div>
																</li>
																<li class="td td-change">
																	<a href="pay.jsp">
																		<div class="am-btn am-btn-danger anniu">
																			一键支付
																		</div>
																	</a>
																</li>
															</div>
														</c:if>
														<c:if test="${allOrders.status==1 }">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">买家已付款</p>
																		<p class="order-info"><a href="<%=path %>/web/
.action?orderid=${allOrders.id}&status=1">订单详情</a></p>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu" id="reminber">
																		提醒发货
																	</div>
																</li>
															</div>
														</c:if>
														<c:if test="${allOrders.status==2 }">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">卖家已发货</p>
																		<p class="order-info"><a href="<%=path %>/web/orderInfo.action?orderid=${allOrders.id}&status=2">订单详情</a></p>
																		<p class="order-info"><a href="<%=path %>/goodskd/towuliu.action?wlno=${allOrders.wlno}&wlid=${allOrders.wlid}">查看物流</a></p>
																		<p class="order-info"><a href="#">延长收货</a></p>
																	</div>
																</li>
																<li class="td td-change">
																<a href="<%=path %>/web/updateOrderStatus.action?orderid=${allOrders.id}&status=3">
																	<div class="am-btn am-btn-danger anniu">
																		确认收货
																	</div>
																</a>
																</li>
															</div>
														</c:if>
														<c:if test="${allOrders.status==3 }">
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">交易成功</p>
																		<p class="order-info"><a href="<%=path %>/web/orderInfo.action?orderid=${allOrders.id}&status=3">订单详情</a></p>
																		<p class="order-info"><a href="<%=path %>/goodskd/towuliu.action?wlno=${allOrders.wlno}&wlid=${allOrders.wlid}">查看物流</a></p>
																	</div>
																</li>
																<li class="td td-change">
																	<a href="<%=path %>/web/tocommentlist.action?orderid=${allOrders.id }&status=3">
																		<div class="am-btn am-btn-danger anniu">
																			评价商品</div>
																	</a>
																</li>
															</div>
														</c:if>
													</div>													
												</div>
												</c:forEach>
												
											</div>
										</div>
									</div>
								</div>
								
								<!-- ********* 待付款  ********** -->
								<div class="am-tab-panel am-fade" id="tab2">

									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<div class="order-status1">
											<c:choose>
											<c:when test="fn:length(${noPay})==0 }">暂无数据</c:when>											
											<c:otherwise>											
											<c:forEach items="${noPay }" var="noPay">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${noPay.orderno }</a></div>
													<span>成交时间：${noPay.createdate }</span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<c:forEach items="${noPay.orderdetail }" var="detail">
															<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p>${detail.goods.goodsname }</p>
																			<p class="info-little">口味：${detail.goods.tastetypes[0].typename}
																				<br/>包装：${detail.goods.packagetypes[0].typename} </p>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	${detail.price }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${detail.num }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>
														</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${noPay.totalcount }
																<p>含运费：<span>10.00</span></p>
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="#">取消订单</a></p>

																</div>
															</li>
															<li class="td td-change">
																<a href="pay.jsp">
																<div class="am-btn am-btn-danger anniu">
																	一键支付</div></a>
															</li>
														</div>
													</div>

												</div>
												</c:forEach>
												</c:otherwise>
											</c:choose>
											</div>
										</div>
									</div>
								</div>
								
								<!-- ********* 待发货 ********** -->
								<div class="am-tab-panel am-fade" id="tab3">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<div class="order-status2">
											<c:forEach items="${noDelivery }" var="noDelivery">
											
											
												<div class="order-title">
												
													<div class="dd-num">订单编号：<a href="javascript:;">${noDelivery.orderno }</a></div>
													<span>成交时间：${noDelivery.createdate }</span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
													<c:forEach items="${noDelivery.orderdetail }" var="orderdetail">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p>${orderdetail.goods.goodsname }</p>
																			<p class="info-little">口味：${orderdetail.goods.tastetypes[0].typename }
																				<br/>包装：${orderdetail.goods.packagetypes[0].typename }</p>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	${orderdetail.price }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderdetail.num }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	<a href="refund.jsp">退款</a>
																</div>
															</li>
														</ul>
														</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${noDelivery.totalcount }
																<p>含运费：<span>10.00</span></p>
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">买家已付款</p>
																	<p class="order-info"><a href="<%=path %>/web/orderInfo.action?orderid=${noDelivery.id }&status=1">订单详情</a></p>
																</div>
															</li>
															<li class="td td-change">
																<div class="am-btn am-btn-danger anniu" id="reminber2">
																	提醒发货</div>
															</li>
														</div>
													</div>
												</div>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
								
								<!-- ********* 待收货  ********** -->
								<div class="am-tab-panel am-fade" id="tab4">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
											<div class="order-status3">
											<c:forEach items="${noSignfor }" var="noSignfor">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${noSignfor.orderno }</a></div>
													<span>成交时间：${noSignfor.createdate }</span>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<c:forEach items="${noSignfor.orderdetail }" var="orderdetail">
															<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="images/62988.jpg_80x80.jpg" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p>${orderdetail.goods.goodsname }</p>
																			<p class="info-little">口味：${orderdetail.goods.tastetypes[0].typename }
																				<br/>包装：${orderdetail.goods.packagetypes[0].typename }</p>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	${orderdetail.price }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderdetail.num }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	<a href="refund.jsp">退款/退货</a>
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${noSignfor.totalcount }
																<p>含运费：<span>10.00</span></p>
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">卖家已发货</p>
																	<p class="order-info"><a href="<%=path %>/web/orderInfo.action?orderid=${noSignfor.id }&status=2">订单详情</a></p>
																	<p class="order-info"><a href="<%=path %>/goodskd/towuliu.action?wlno=${noSignfor.wlno}&wlid=${noSignfor.wlid}">查看物流</a></p>
																	<p class="order-info"><a href="#">延长收货</a></p>
																</div>
															</li>
															<li class="td td-change">
																<a href="<%=path %>/web/updateOrderStatus.action?orderid=${noSignfor.id}&status=3">
																	<div class="am-btn am-btn-danger anniu">
																		确认收货
																	</div>
																</a>
															</li>
														</div>
													</div>
												</div>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>

								<!-- ********* 待评价  ********** -->
								<div class="am-tab-panel am-fade" id="tab5">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
									
										<div class="order-status4">
											<c:forEach items="${noEvaluate }" var="noEvaluate">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${noEvaluate.orderno }</a></div>
													<span>成交时间：${noEvaluate.createdate }</span>

												</div>
												<div class="order-content">
													<div class="order-left">
													<c:forEach items="${noEvaluate.orderdetail }" var="orderdetail">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p>${orderdetail.goods.goodsname }</p>
																			<p class="info-little">口味：${orderdetail.goods.tastetypes[0].typename }
																				<br/>包装：${orderdetail.goods.packagetypes[0].typename }</p>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	${orderdetail.price }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderdetail.num }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	<a href="refund.jsp">退款/退货</a>
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${noEvaluate.totalcount }
																<p>含运费：<span>10.00</span></p>
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">交易成功</p>
																	<p class="order-info"><a href="<%=path %>/web/orderInfo.action?orderid=${noEvaluate.id }&status=3">订单详情</a></p>
																	<p class="order-info"><a href="<%=path %>/goodskd/towuliu.action?wlno=${noEvaluate.wlno}&wlid=${noEvaluate.wlid}">查看物流</a></p>
																</div>
															</li>
															<li class="td td-change">
																<a href="<%=path %>/web/tocommentlist.action?orderid=${noEvaluate.id }&status=3">
																	<div class="am-btn am-btn-danger anniu">
																		评价商品</div>
																</a>
															</li>
														</div>
													</div>
												</div>
												</c:forEach>
											</div>
										</div>

									</div>

								</div>
							</div>

						</div>
					</div>
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
						<a href="index.jsp">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li> <a href="<%=path %>/web/information.action">个人信息</a></li>
							<li> <a href="<%=path %>/web/setsafety.action">安全设置</a></li>
							<li> <a href="<%=path %>/webaddress/enter.action">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li class="active"><a href="<%=path %>/web/allOrderData.action">订单管理</a></li>
							<li> <a href="change.jsp">退款售后</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的资产</a>
						<ul>
							<li> <a href="coupon.jsp">优惠券 </a></li>
							<li> <a href="bonus.jsp">红包</a></li>
							<li> <a href="<%=path %>/webbill/billlist.action?date=7">账单明细</a></li>
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

</html>
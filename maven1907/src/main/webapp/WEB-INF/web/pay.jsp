<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="<%=path %>/web/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="<%=path %>/web/css/jsstyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path %>/web/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>

		<script type="text/javascript" src="js/address.js"></script>
       <link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
        	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/lay/modules/layer.js"></script>
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
								<div class="menu-hd"><a id="mc-menu-hd" href="<%=path %>/webshopcart/enter.action?type=1" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">${num }</strong></a></div>
							</div>
							<div class="topMessage favorite">
								<div class="menu-hd"><a href="<%=path %>/webCollection/toCollection.action" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
						</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
							<div class="logoBig">
								<li><img src="<%=path %>/web/images/suntubiao.png" /></li>
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
			
			<form action="<%=path %>/webAlipay/toSave.action" id="form1" method="post">
			<input type="hidden" name="cusid" value="${sessionScope.customer.id }">
		    <input type="hidden" name="goodsid" value="${goodsid }">
		    <input type="hidden" name="tas" value="${tas }">
		    <input type="hidden" name="pac" value="${pac }">
		    
		    
			<div class="concent"> 
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						
						
						
		
										
						<ul>
						<c:forEach items="${addrdto}" var="addr">
							<div class="per-border"></div>
							
							<li class="user-addresslist <c:if test="${addr.isdefault==1 }">defaultAddr</c:if>" onclick="confirmAddr(this)" info="${addr.proname }${addr.cityname }${addr.xianname }${addr.address }_${addr.realname }_${cus.mobile }_${addr.id }">
       	                
       	                 <c:choose>
       	                 <c:when test="${addr.isdefault==1 }">
       	                  <input type="hidden" name="addressid" value="${addr.id }" id="addid">
       	                 </c:when>
       	                 </c:choose>
       	                 	<div class="address-left">
									<div class="user DefaultAddr">

										<span class="buy-address-detail">   
                                       <span class="buy-user">${addr.realname } </span>
									<span class="buy-phone">${cus.mobile }</span>
										</span>
									</div>
									
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								        <span class="province">${addr.proname }</span>省
										<span class="city">${addr.cityname }</span>市
										<span class="dist">${addr.xianname }</span>区
										<span class="street">${addr.address }</span>
										</span>
										</span>
									</div>
									<c:if test="${addr.isdefault==1 }">
									
									<ins class="deftip">默认地址</ins>
									</c:if>
								</div>
								
								<div class="address-right">
									<a href="person/address.jsp">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
								<c:if test=""></c:if>
								
									<a href="javascript:void(0);" <c:if test="${addr.isdefault==1 }">class="hidden"</c:if> onclick="selAddrId(this)" defaultid="${addr.id }" >设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									<a href="#">编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(this);">删除</a>
								</div>
					

							</li>
							<div class="per-border"></div>
						
						
						</c:forEach>
						</ul>

						<div class="clear"></div>
					</div>
					<!--物流 -->
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
							<li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
							<li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="<%=path %>/web/images/wangyin.jpg" />银联<span></span></li>
							<li class="pay qq"><img src="<%=path %>/web/images/weizhifu.jpg" />微信<span></span></li>
							<li class="pay taobao"><img src="<%=path %>/web/images/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

									<div class="th th-item">
										<div class="td-inner">商品信息</div>
									</div>
									<div class="th th-price">
										<div class="td-inner">单价</div>
									</div>
									<div class="th th-amount">
										<div class="td-inner">数量</div>
									</div>
									<div class="th th-sum">
										<div class="td-inner">金额</div>
									</div>
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							</div>
							<div class="clear"></div>

							<tr class="item-list">
								<div class="bundle  bundle-last">

									<div class="bundle-main">
									
								
<!--  循环购物车-->
        <c:choose>
	<c:when test="${requestScope.type==2 }">
     <c:forEach items="${cartList }" var="carts">
     <input type="hidden" name="cartIds" value="${carts.id }">
     <input type="hidden" name="type" value="2">
							<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="<%=path %>/web/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${carts.bloBs.goodsname }</a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">口味：${carts.taste.typename }</span>
														<span class="sku-line" >包装：${carts.spackage.typename }</span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now">${carts.bloBs.price }</em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl">
															<div class="text_box"   style="width:30px;margin-left:85px" >${carts.num }</div>
														</div>
													</div>
												</div>
											</li>
											
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number" id="totalmoney">${carts.num*carts.bloBs.price }</em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														快递<b class="sys_item_freprice">0</b>元
													</div>
												</div>
											</li>
                             
										</ul>
										
                          </c:forEach>									
								
     </c:when>
										
    <c:otherwise>
	<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="<%=path %>/web/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${goodsdto.goodsname }</a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">口味：${tasname }</span>
														<span class="sku-line" >包装：${pacname }</span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now">${goodsdto.price }</em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="sl">
															<div class="text_box"   style="width:30px;margin-left:85px" >${requestScope.num }</div>
															
														</div>
													</div>
												</div>
											</li>
											
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number" id="totalmoney"><fmt:formatNumber type="currency" value="${requestScope.num*goodsdto.price }" pattern="$.00"></fmt:formatNumber></em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														快递<b class="sys_item_freprice">0</b>元
													</div>
												</div>
											</li>

										</ul>
	
	
	
	
	
	
	
	
										
</c:otherwise>
</c:choose>
										<div class="clear"></div>

									</div>
							</tr>
							<div class="clear"></div>
							</div>
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>

							</div>
							<!--优惠券 -->
							<div class="buy-agio">
								<li class="td td-coupon">

									<span class="coupon-title">优惠券</span>
									<select data-am-selected>
										<option value="a">
											<div class="c-price">
												<strong>￥8</strong>
											</div>
											<div class="c-limit">
												【消费满95元可用】
											</div>
										</option>
										<option value="b" selected>
											<div class="c-price">
												<strong>￥3</strong>
											</div>
											<div class="c-limit">
												【无使用门槛】
											</div>
										</option>
									</select>
								</li>

								<li class="td td-bonus">

									<span class="bonus-title">红包</span>
									<select data-am-selected>
										<option value="a">
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>10.40<span>元</span>
											</div>
										</option>
										<option value="b" selected>
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>50.00<span>元</span>
											</div>
										</option>
									</select>

								</li>

							</div>
							<div class="clear"></div>
							</div>
							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计（含运费） <span></span><em class="pay-sum" ><fmt:formatNumber type="currency" value="${totalPrice }" pattern="￥.00"></fmt:formatNumber></em>
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box" id="addBox">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span></span> <em class="style-large-bold-red " id="J_ActualFee"><fmt:formatNumber type="currency" value="${totalPrice }" pattern="$.00"></fmt:formatNumber></em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
								                 <span class="province" id="province"></span>
										
												</span>
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail">   
                                                <span class="buy-user" id="buy-user"> </span>
												<span class="phone" id="phone"></span>
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<a id="J_Go" type="java" href="javascript:void(0);" onclick="toSave()" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
										</div>
									</div>
									
									<script type="text/javascript">
									$("input[name='num']").val('${requestScope.num}');
									
									function toSave(){
								   
									$("#form1").submit();
									}
									
									</script>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
					</form>
				</div>
				
				
				
				
				<div class="footer " >
					<div class="footer-hd " >
						<p style="text-align: center">
							<a href="<%=path %>/webrzw/enterRuanying.action?type=0">软赢科技</a>
							<b>|</b>
							<a href="<%=path %>/webHome/index.action">商城首页</a>
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
			<div class="theme-popover-mask"></div>
			<div class="theme-popover">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
					<form class="am-form am-form-horizontal">

						<div class="am-form-group">
							<label for="user-name" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="user-name" placeholder="收货人">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="user-phone" placeholder="手机号必填" type="email">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select data-am-selected>
									<option value="a">浙江省</option>
									<option value="b">湖北省</option>
								</select>
								<select data-am-selected>
									<option value="a">温州市</option>
									<option value="b">武汉市</option>
								</select>
								<select data-am-selected>
									<option value="a">瑞安区</option>
									<option value="b">洪山区</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<div class="am-btn am-btn-danger">保存</div>
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				</div>

			</div>

			<div class="clear"></div>
	</body>
			<script type="text/javascript">
								function confirmAddr(obj){
								var info=$(obj).attr("info");
								var arr=info.split("_");
								$("#province").html(arr[0]);
								
								$("#buy-user").html(arr[1]);								
								$("#phone").html(arr[2]);
								$("#addid").val(arr[3]);
								
								}
								
								
								var info=$(".defaultAddr").attr("info");
								var arr=info.split("_");
								$("#province").html(arr[0]);
								
								$("#buy-user").html(arr[1]);								
								$("#phone").html(arr[2]);
								$("#addid").val(arr[3]);
								
								function selAddrId(obj){
								var defaultid=$(obj).attr("defaultid");
								
								$.ajax({
								 url:"../webAlipay/updateDefaultAdd.action",
								 data:{defaultid:defaultid},
								 type:"post",
								 success:function(res){
								 if(res){
								
								  alert("默认地址修改成功");
								  window.location.reload();
							
								 }else{
								 
								alert("默认地址修改失败");
								 }
								    
								 }
								
								});
								}
								</script>
</html>
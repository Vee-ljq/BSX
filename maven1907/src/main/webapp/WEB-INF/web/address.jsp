<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>地址管理</title>

		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="<%=path %>/web/css/personal.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/web/css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="<%=path %>/web/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="<%=path %>/web/AmazeUI-2.4.2/assets/js/amazeui.js"></script>

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
								<div class="menu-hd"><a id="mc-menu-hd" href="<%=path %>/webshopcart/enter.action" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
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

					<div class="user-address">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
						</div>
						<hr/>
						<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
							<c:forEach items="${addresss }" var="aa">
								
								<c:if test="${aa.isdefault==1 }">
								<li class="user-addresslist defaultAddr">
								<a  class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</a>
								</c:if>
								<c:if test="${aa.isdefault==0 }">
								<li class="user-addresslist">
								<a href="<%=path %>/webaddress/updateByMoren.action?type=1&id=${aa.id}" class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</a>
								</c:if>
								<p class="new-tit new-p-re">
									<span class="new-txt">${aa.realname }</span>
									<span class="new-txt-rd2">${aa.customer.mobile }</span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw " id="addressAll_${aa.id }" data-id="${aa.aData1.codeid }_${aa.aData2.codeid }_${aa.aData3.codeid }_${aa.id}">
										<span class="title">地址：</span>
										<span class="province" value="${aa.aData1.codeid }">${aa.aData1.cityname }</span>省
										<span class="city" value="${aa.aData2.codeid }">${aa.aData2.cityname }</span>市
										<span class="dist" value="${aa.aData3.codeid }">${aa.aData3.cityname }</span>区
										<span class="street">${aa.address }</span></p>
								</div>
								<div class="new-addr-btn">
									<a href="javascript:void(0);" class="bianji" value="bianji_${aa.id }" onclick="bianjiclick(this)"><i class="am-icon-edit"></i>编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="<%=path %>/webaddress/deleteAddress.action?id=${aa.id }" onClick="delClick(this);" value="${aa.id }"><i class="am-icon-trash"></i>删除</a>
								</div>
							</li>
							</c:forEach>
						</ul>
						<div class="clear"></div>
						<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
						<!--例子-->
						<div class="am-modal am-modal-no-btn" id="doc-modal-1">

							<div class="add-dress">

								<!--标题 -->
								<div class="am-cf am-padding">
									<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
								</div>
								<hr/>

								<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
									<form class="am-form am-form-horizontal" action="<%=path%>/webaddress/saveOrInsert.action">
										<input type="hidden" value="" id="hiddenaddressid" name="id"/>
										<div class="am-form-group">
											<label for="user-name" class="am-form-label" >收货人</label>
											<div class="am-form-content">
												<input name="realname"  type="text" id="user-name" placeholder="收货人">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input name="phone" id="user-phone" placeholder="手机号必填" type="text">
											</div>
										</div>
										<div class="am-form-group">
											<label for="user-address" class="am-form-label">所在地</label>
											<div class="am-form-content address">
												<select name="proviceid" data-am-selected onchange="provinceTocityxian()" id="provinceid">
													<c:forEach items="${selectAllProvince }" var="ss">
														<option id="provinceid-option" value="${ss.codeid }" >${ss.cityname }</option>
													</c:forEach>
												</select>
												<select name="cityid" data-am-selected id="city" onchange="cityToxian()">
												</select>
												<select name="areaid" data-am-selected id="xian">
												</select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea  name="address" class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<button  class="am-btn am-btn-danger">保存</button>
												<a href="javascript: void(0)" class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
											</div>
										</div>
									</form>
								</div>

							</div>

						</div>

					</div>

					<script type="text/javascript">
								
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
							});
							
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}
							var procinceid = null;
							var cityid = null;
							var xianid = null;
							function bianjiclick(obj){
								var bianjiid = $(obj).attr("value").split("_");
								var aaaaa = bianjiid[1];
								alert("当前地址的id"+aaaaa)
								var aaddress = $("#addressAll_"+aaaaa).attr("data-id").split("_");
								procinceid = aaddress[0];
								cityid = aaddress[1];
								xianid = aaddress[2];
								$("#hiddenaddressid").val(aaaaa);
									//将用户的省选中
									/* if($("#provinceid").val()==provinceid){
										$("#provinceid-option").attr("selected",selected);
									} */
									$("#provinceid option[value='"+procinceid+"']").attr("selected","selected");
									
									//获得地址的id
									//获得用户的基本信息
									$.ajax({
									type: "GET",
						             url: "bianji.action",
						             data:"addressid="+aaaaa,
						             success: function(data){
						             	$("#user-name").val(data.realname);
						             	$("#user-phone").val(data.customer.mobile);
						             	$("#user-intro").html(data.address)
					              	}
								});
							}
							
							
						function provinceTocityxian(){
								var provinceid = $("#provinceid").val();
								alert(cityid)
								$("#city").empty();
								$("#xian").empty();
								//获得用户的市县
								$.ajax({
									type: "GET",
						             url: "../webgoodsxq/proTocityToxian.action",
						             data:"id="+provinceid,
						             success: function(data){
						             	$.each(data,function(i,result){
						             		//$("#city").append("<option></option>");
						             		if(result.codeid==cityid){
						             					$("#city").append("<option value='"+result.codeid+"'selected>"+result.cityname+"</option>");	 
						             			}else{
						             					$("#city").append("<option value='"+result.codeid+"'>"+result.cityname+"</option>");	 
						             			}
						             		 
						             	});
					              	}
								});
								//$("#city option[value='"+cityid+"']").attr("selected","selected");
							
							}
							
							function cityToxian(){
								$("#xian").empty();
								var cityid = $("#city").val();
								alert("xian"+xianid)
								//获得用户的市县
								$.ajax({
									type: "GET",
						             url: "../webgoodsxq/proTocityToxian.action",
						             data:"id="+cityid,
						             success: function(data){
						             	$.each(data,function(i,result){
						             		if(result.codeid==xianid){
						             					$("#xian").append("<option value='"+result.codeid+"' selected>"+result.cityname+"</option>");	 
						             			}else{
						             					$("#xian").append("<option value='"+result.codeid+"' >"+result.cityname+"</option>");	
						             			}
						             	});
					              	}
								});
								//$("#xian option[value='"+xianid+"']").attr("selected","selected");
							
							}
					</script>

					<div class="clear"></div>

				</div>
				<!--底部-->
				<div class="footer " >
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
							<li> <a href="comment.jsp">评价</a></li>
							<li> <a href="<%=path %>/web/newsData.action">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>

	</body>

</html>

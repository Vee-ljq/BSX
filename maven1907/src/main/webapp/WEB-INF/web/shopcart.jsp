<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="<%=path %>/web/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/web/css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="<%=path %>/web/js/jquery.js"></script>

	</head>

	<body>

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

			<!--购物车 -->
			<form action="<%=path %>/webAlipay/nowBuy.action" method="post" id="cartform">
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
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
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<c:forEach items="${bcartGoods }" var="bb">
					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									<div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥19.50</span>&nbsp;&nbsp;</div>
									<div class="act-promo">
										<a href="../webgoodsxq/data.action?id=${bb.bloBs.id }" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a>
									</div>
									<span class="list-change theme-login">编辑</span>
								</div>
							</div>
							<div class="clear"></div>
							<div class="bundle-main">
								
								
									<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_${bb.bloBs.id }_${bb.id }" name="carts"  value="${bb.id }" type="checkbox" onclick="sumZj();">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<input type="hidden"  value="${bb.bloBs.id}"/>
											<a href="#" target="_blank" data-title="${bb.bloBs.goodsname }" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="<%=path %>/upload/${bb.bloBs.indeximg }" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="${bb.bloBs.goodsname }" class="item-title J_MakePoint" data-point="tbcart.8.11">${bb.bloBs.goodsname }</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span id="tastevalue" class="sku-line" value="${bb.taste.id }">口味：${bb.taste.typename }</span>
											<span id="spackagevalue" class="sku-line" value="${bb.spackage.id }">包装：${bb.spackage.typename }</span>
											<span tabindex="0" class="btn-edit-sku theme-login"  data="${bb.taste.id} _${bb.spackage.id}_${bb.num}_${bb.bloBs.indeximg }_${bb.bloBs.price }_${bb.id}_${bb.bloBs.id}">修改</span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">${bb.bloBs.ckprice }</em>
												</div>
												<div class="price-line">
													<em class="realprice" class="J_Price price-now" tabindex="0">${bb.bloBs.price }</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input onclick="addprice(0,'${bb.bloBs.price }','heji_${bb.id }','changenum_${bb.id }')" class="min am-btn" name="" type="button" value="-" />
													<input id="changenum_${bb.id }" class="text_box" name="changedNum" type="text" value="${bb.num }" style="width:30px;"  />
													<input  onclick="addprice(1,'${bb.bloBs.price }','heji_${bb.id}','changenum_${bb.id }')"  class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em id="heji_${bb.id }" tabindex="0" class="J_ItemSum number">
											<fmt:formatNumber value="${bb.bloBs.price*bb.num }" pattern="0.00"></fmt:formatNumber>
											</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="shoucangOne.action?cusid=${sessionScope.customer.id }&goodsid=${bb.bloBs.id}">
                  移入收藏夹</a>
											<a href="delete.action?id=${bb.id }" data-point-url="#" class="delete">
                  删除</a>
										</div>
									</li>
						<%--     <input type="hidden" name="carts" value="${bb.id }"> --%>
						    
						    <input type="hidden" name="type" value="2">
						
								</ul>
							
								
							</div>
						</div>
						
					</tr>
					
					</c:forEach>
					<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox"  onchange="quanxuan(this)">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="" hidefocus="true" class="deleteAll">删除</a>
						<a href="" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total"></em></strong>
						</div>
						<div class="btn-area">

						<a href="javascript:void(0);" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算" onclick="tjCarts()">
								
							<span>结&nbsp;算</span></a>
								
						
						<input type="hidden" name="cusid" value="${session.customer.id }">
								
								<script type="text/javascript">
								function tjCarts(){
								
								$("#cartform").submit();
								
								}
								
								</script>

						</div>
					</div>

				</div>
      </form>
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
	<!--操作页面-->

			<div class="theme-popover-mask"></div>

			<div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">

							<li class="theme-options">
								<div class="cart-title">口味：</div>
								<ul id="v_taste">
									<c:forEach items="${taste }" var="tt">
										<li  class="sku-line " value="${tt.id }">${tt.typename }<i></i></li>
									</c:forEach>
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title">包装：</div>
								<ul id="v_package">
									<c:forEach items="${spackage }" var="ss">
										<li  class="sku-line " value="${ss.id }">${ss.typename }<i></i></li>
									</c:forEach>
								</ul>
							</li>
							<div class="theme-options">
								<div class="cart-title number">数量</div>
								<dd>
									<input class="min am-btn am-btn-default" name="" type="button" value="-" />
									<input id="goodsnumupdate" class="text_box" name="" type="text" value="" style="width:30px;" />
									<input class="add am-btn am-btn-default" name="" type="button" value="+" />
								</dd>

							</div>
							<div class="btn-op">
								<div class="btn am-btn am-btn-warning"><a id="updatecart" href="">确认</a></div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>
						<div class="theme-signin-right">
							<div class="img-info">
								<img id="goodsimg" src="" />
							</div>
							<div class="text-info">
								<span class="J_Price price-now"></span>
							</div>
						</div>

					</form>
				</div>
			</div>
			
		<!--引导 -->
		<div class="navCir">
			<li><a href="home.jsp"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.jsp"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.jsp"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="person/index.jsp"><i class="am-icon-user"></i>我的</a></li>					
		</div>
	</body>
<script type="text/javascript">
	$(".J_BatchFav").click(function(){
		alert("11111")
		var list = $("input[type='checkbox']:checked");	
		var url = "shoucangAll.action?goodsid=";
		for(var i = 0;i<list.length;i++){
			var s = list[i].id.split("_");
			goodsid = s[1];
			if(i==list.length-1){
				url = url+goodsid;
			}else{
				url = url+goodsid+"&goodsid=";
			}
		}
		$(".J_BatchFav").attr("href",url);
	});
	$(".deleteAll").click(function(){
		var list = $("input[type='checkbox']:checked");
		var url = "deleteAll.action?ids=";
		for(var i = 0;i<list.length;i++){
			var s = list[i].id.split("_");
			ids = s[2];
			if(i==list.length-1){
				url = url+ids;
			}else{
				url = url+ids+"&ids=";
			}
			
		}
		$(".deleteAll").attr("href",url);
	
	});
function quanxuan(obj){
		if(obj.checked){
			$("input[type='checkbox']").attr("checked",true);
			var list = $("input[type='checkbox']:checked");
			$("#J_SelectedItemsCount").html(list.length-1);
			var xj=0
			for(var i = 0;i<list.length-1;i++){
				var s = list[i].id.split("_");
				var id = s[2];
				 xj+=parseFloat($("#heji_"+id).html());
			}
				$("#J_Total").html(xj.toFixed(2));
		}else{
			$("input[type='checkbox']").removeAttr("checked",false);
				$("#J_Total").html("0.00");
				$("#J_SelectedItemsCount").html("0");
		}
	}
	function sumZj(){
			var list = $("input[type='checkbox']:checked");
			$("#J_SelectedItemsCount").html(list.length-1);
			var xj=0
			for(var i = 0;i<list.length-1;i++){
				var s = list[i].id.split("_");
				var id = s[2];
				 xj+=parseFloat($("#heji_"+id).html());
			}
				$("#J_Total").html(xj.toFixed(2));
	}
	function xuanzhong(xiaoji){
		$("#J_SelectedItemsCount").html($("input[type='checkbox']:checked").length);
		
		$("#J_Total").html(parseFloat($("#J_Total").html())+parseFloat(xiaoji));
	}
	
	
   function addprice(flag,price,xiaoji,shuliang){
    var arr=shuliang.split("_");
		  if(flag==1){
		 
		   
		  var num=parseInt($("#"+shuliang+"").attr("value"))+1;
		  $.ajax({
		    url:"<%=path%>/webAlipay/updateNum.action",
		    data:{num:num,cartid:arr[1]},
		    type:'post',
		    success:function(res){
		    if(res){
		    
		    }
		    }
		  });
		 
		    $("#"+xiaoji+"").html(parseFloat(price*(parseInt($("#"+shuliang+"").attr("value"))+1)).toFixed(2));
		  }else{
		  var num=parseInt($("#"+shuliang+"").attr("value"))-1;
		  
		   if(num==-1){
		   num=0;
		   $("#"+shuliang).val("0");
		   $("#"+shuliang+"").attr("value","0");
		   }
		  $.ajax({
		    url:"<%=path%>/webAlipay/updateNum.action",
		    data:{num:num,cartid:arr[1]},
		    type:'post',
		    success:function(res){
		    if(res){
		    
		    }
		    }
		  });
		 var xj = parseFloat(price*(parseInt(num)));
		  	$("#"+xiaoji+"").html(xj.toFixed(2));
		  }
	  sumZj();
	  }
		$(".btn-edit-sku").click(function(){
			$("#v_taste li").removeClass("selected");
			$("#v_package li").removeClass("selected");
			var data = $(this).attr("data");
			var s = data.split("_");
			var taskid = s[0];
			taskid=taskid.trim();
			var packageid = s[1];
			var num = s[2];
			var url = s[3];
			var price = s[4];
			var cartid = s[5];
			var goodsid = s[6];
			alert(taskid+","+packageid+","+num+","+url+","+price+","+cartid)
			$("#v_taste li[value='"+taskid+"']").addClass("selected");
			$("#v_package li[value='"+packageid+"']").addClass("selected");
			$("#goodsnumupdate").val(num);
			$("#goodsimg").attr("src","<%=path%>/upload/"+url);
			$(".price-now").html("￥"+price);	
			var newtasteid = null;// 声明全局变量 
			$("#v_taste li").click(function() {
			 	newtasteid = $(this).attr("value"); 
			 	alert("新的口味id"+newtasteid)
			 })
			 var newpackageid = null;// 声明全局变量 
			$("#v_package li").click(function() {
			 	newpackageid = $(this).attr("value"); 
			 	alert("新的包装id"+newpackageid)
			 })
			  var newnum = null;
			 $(".am-btn").click(function(){
				newnum = $("#goodsnumupdate").val();
			 	alert("新的数量"+newnum)
			 });
			 $("#updatecart").click(function(){
			 $("#updatecart").attr("href","enter.action?id="+cartid+"&tasteid="+newtasteid+"&packageid="+newpackageid+"&num="+newnum+"&goodsid="+goodsid);						
			 
			 });
		});
		var addorsubnum = null;
			$("#add").click(function(){
				//传到控制层
				addorsubnum = parseInt($("#goodsnum").val())+1;
				alert(addorsubnum)
			});
			$("#min").click(function(){
				addorsubnum = $("#goodsnum").val()-1;
				alert(addorsubnum)
			});
			
	 
</script> 
</html>
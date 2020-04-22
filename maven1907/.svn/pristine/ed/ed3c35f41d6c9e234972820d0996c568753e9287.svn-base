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
	<meta charset="utf-8">
	<title>待签收后台管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/js/layui/css/news.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/js/ace/css/ace.css" media="all" />
 	<link rel="stylesheet" href="<%=path%>/js/ace/css/bootstrap.css"/>
</head>
<body class="childrenBody">

	<blockquote class="layui-elem-quote news_search">
	<form action="<%=path%>/order/signfor.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNumber" value="${signforpage.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${signforpage.page.pageSize }"/>
		    	<input type="text" value="${orders.orderno }"  name="orderno"  placeholder="请输入订单编号"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
	</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>				
				<col width="9%">
				<col>
				<col width="12%">
				<col width="9%">
				<col width="12%">
				<col width="12%">
				<col width="9%">
				<col width="12%">
				<col width="9%">
		    </colgroup>
		    <thead>
				<tr>				
					<th>订单编号</th>
					<th>客户名称</th>
					<th>商品名称</th>
					<th>总价</th>
					<th>发货日期</th>
					<th>支付宝支付订单号</th>
					<th>物流单号</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(signforpage.page.list)==0 }">
		    			<tr>
		    				<td colspan="10">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${signforpage.page.list }"  var="orders" >
		    				<tr>		    					
								<td>${orders.orderno }</td>
								<td>${orders.orderdetail[0].customer.realname }</td>
								<td>${orders.orderdetail[0].goods.goodsname }</td>	    					
		    					<td>${orders.totalcount }</td>
		    					<td>${orders.fhdate }</td>
		    					<td>${orders.zfborderno }</td>
		    					<td>${orders.wlno }</td>
		    					<td>
			    					<c:if test="${orders.status==0 }">待付款</c:if>
			    					<c:if test="${orders.status==1 }">待发货</c:if>
			    					<c:if test="${orders.status==2 }">待签收</c:if>
			    					<c:if test="${orders.status==3 }">待评价</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_edit" data_id="${orders.id }"><i class="iconfont icon-edit"></i> 确认收货</a>
		    					</td>
		    				
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${signforpage.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orders/signfordata.js"></script>

</body>
</html>
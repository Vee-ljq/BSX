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
	<title>待发货后台管理</title>
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
	<form action="<%=path%>/order/toShipments.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="status" name="status" value="1"/>
		    	<input type="hidden" id="pageNumber" name="pageNumber" value="${toShipments.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${toShipments.page.pageSize }"/>
		    	<input type="text" value="${orders.orderno }"   name="orderno"  placeholder="请输入商品名称"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
	</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="20">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="12%">
				<col width="12%">
				<col width="12%">
				<col width="22%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>订单编号</th>
					<th>客户名称</th>
					<th>单价</th>
					<th>数量</th>
					<th>总价</th>
					<th>状态</th>
					<th>下单时间</th>
					<th>付款时间</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(toShipments.page.list)==0 }">
		    			<tr>
		    				<td colspan="10">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${toShipments.page.list }" var="orders">
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
		    					<td>${orders.orderno }</td>
		    					<td>${orders.BCustomer.realname }</td>
		    					<td>${orders.orderdetail1.price }</td>
		    					<td>${orders.orderdetail1.num }</td>
		    					<td>${orders.orderdetail1.totalprice }</td>
		    					<td><c:if test="${orders.status==1 }">待发货</c:if></td>
		    					<td>${orders.createdate }</td>
		    					<td>${orders.fkdate }</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini shipments-edit" data_id="${orders.id }"><i class="iconfont icon-edit"></i> 发货</a>
		    					<a class="layui-btn layui-btn-mini new-edit" data_id="${orders.orderdetail1.id  }"><i class="iconfont icon-edit"></i> 编辑</a>
		    					<a class="layui-btn layui-btn-mini orders_detail" data_id="${orders.orderdetail1.id }"><i class="iconfont icon-edit"></i> 查看详情</a>
		    					</td>
		    				
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${toShipments.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orders/data.js"></script>

</body>
</html>
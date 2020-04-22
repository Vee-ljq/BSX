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
	<title>文章列表--layui后台管理模板</title>
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
	<form action="<%=path%>/order/nopay.action" >
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value="${customer.nickname}"   name="nickname" class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input  type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		
		
			</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="5%">
				<col width="5%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="20%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>订单编号</th>
					<th>用户名</th>
					<th>手机号</th>
					<th>总金额</th>
					<th>订单创建时间</th>
					<th>支付宝支付订单</th>
					<th>省</th>
					<th>市</th>
					<th>县</th>
					<th>详细地址</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="6">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="order">
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
					
		    					<td>${order.orderno }</td>
		    					<td>
		    						${order.bcustomer.nickname }
		    					</td>
		    					<td>${order.bcustomer.mobile }</td>
		    					<td>${order.totalcount }</td>
		    					<td>${order.createdate }</td>
		    					<td>${order.zfborderno }</td>
		    					<td>${order.areadata1.cityname }</td>
		    					<td>${order.areadata2.cityname }</td>
		    					<td>${order.areadata3.cityname }</td>
		    					<td>${order.baddress.address }</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_editNopay" data_id="${order.id }"><i class="iconfont icon-edit"></i> 编辑</a>
		    					</td>
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${page.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/orders/data.js"></script>

</body>
</html>
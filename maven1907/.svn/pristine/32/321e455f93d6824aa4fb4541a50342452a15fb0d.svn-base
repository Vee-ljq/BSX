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
	<title>团购发布后台管理</title>
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
	<form action="<%=path%>/goodstype/toGroupPurchase.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNumber" value="${typePage.page.pageNum }"/>
		    	<input type="hidden" id="status" name="status" value="3"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${typePage.page.pageSize }"/>
		    	<input type="text" value="${name.goodsname }"   name="goodsname"  placeholder="请输入商品名称"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		    <input type="button" class="layui-btn search_btn look_group" value="查看团购商品"/>
		</div>
	</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="8%">
				<col width="12%">
				<col width="12%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="20%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>商品编号</th>
					<th>商品类型</th>
					<th>商品名称</th>
					<th>实际价格</th>
					<th>参考价格</th>
					<th>商品活动</th>
					<th>发布人</th>
					<th>商品状态</th>
					<th>库存</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(typePage.page.list)==0 }">
		    			<tr>
		    				<td colspan="11">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${typePage.page.list }" var="orders">
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
					
		    					<td>${orders.goodsno }</td>
		    					<td>${orders.SGoodstype.typename }</td>
		    					<td>${orders.goodsname }</td>
		    					<td>${orders.price }</td>
		    					<td>${orders.ckprice }</td>
		    					<td><c:if test="${orders.bjgoods.type==-1 }">无活动</c:if>
		    					<c:if test="${orders.bjgoods.type==1 }">团购</c:if></td>
		    					<td>${orders.BCustomer.realname }</td>
		    					<td><c:if test="${orders.status==1 }">下架</c:if>
		    					<c:if test="${orders.status==0 }">上架</c:if></td>
		    					<td>${orders.storenum }</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini publishingGroup" data_id="${orders.id }" data_status="${orders.status }"><i class="iconfont icon-edit"></i> 发布团购</a>
		    					</td>
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${typePage.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/group/data.js"></script>

</body>
</html>
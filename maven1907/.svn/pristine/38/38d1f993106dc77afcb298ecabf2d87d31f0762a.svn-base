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
	<form action="<%=path%>/quickbuy/data.action" >
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	
		    </div>
		    <div class="layui-input-inline">
		    <input name="goodsid" type="text"  value="${tjDto.goodsid }" class="layui-input search_input" placeholder="商品编号">
		    </div>
		    <div class="layui-input-inline">
		    <input name="goodsname" type="text"  value="${tjDto.goodsname }" class="layui-input search_input" placeholder="商品名称">
		    </div>
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加闪购商品</a>
		</div>
		
			</form>		
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="8%">
				<col width="16%">
				<col width="8%">
				<col width="8%">
				<col width="15%">
				<col width="7%">
				<col width="15%">
				<col width="9%">
				<col width="10%">
		    </colgroup>
		    <thead>
				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					
					<th>商品价格</th>
					<th>参考价格</th>
					<th>发布时间</th>
					
					<th>库存量</th>
					<th>商品结束时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="9">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="quickgood">
		    				<tr>
					
		    					<td>${quickgood.goodsid}</td>
		    				    <td>${quickgood.goodsname }</td>
		    				   
		    				     <td>${quickgood.goods.price }</td>
		    				    <td>${quickgood.goods.ckprice }</td>
		    				    <td>${quickgood.goods.createdate}</td>
		    				    
		    				    <td>${quickgood.goods.storenum}</td>
		    				     <td>${quickgood.enddate}</td>
		    					<td>
		    						<%-- <c:if test="${quickgood.status==0 }">启用</c:if>
		    						<c:if test="${quickgood.status==1 }">停用</c:if> --%>
		    						
		    						
		    					<input type="checkbox" id="flag" name="flag" data-id="${quickgood.id }" lay-skin="switch" lay-text="启用|禁用" lay-filter="status"<c:if test="${quickgood.status==1 }">checked</c:if>>	
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_editTj" data_id="${quickgood.id }" data_goodid="${quickgood.goodsid}"><i class="iconfont icon-edit"></i> 编辑</a>
		    				
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
	<script type="text/javascript" src="<%=path %>/js/quickbuy/data.js"></script>

</body>
</html>
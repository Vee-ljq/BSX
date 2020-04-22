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
	<form action="<%=path%>/quickbuy/edit.action" >
	
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	
		    </div>
		    <div class="layui-input-inline">
		    <input name="goodsno" type="text"  value="${goods.goodsno }" class="layui-input search_input" placeholder="商品编号">
		    </div>
		    <div class="layui-input-inline">
		    <input name="goodsname" type="text"  value="${goods.goodsname }" class="layui-input search_input" placeholder="商品名称">
		    </div>
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		
			</form>		
	</blockquote>
	
	
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="5">
				<col width="15%">
				<col width="15%">
				<col width="15%">
			    <col width="15%">
				<col width="10%">
				<col width="10%">
		    </colgroup>
		    <thead>
				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>发布时间</th>
					<th>库存量</th>
					<th>状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="7">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="good">
		    				<tr>
					
		    					<td>${good.goodsno}</td>
		    				    <td>${good.goodsname }</td>
		    				   
		    				     <td>${good.price }</td>
		    				 
		    				    <td>${good.createdate}</td>
		    				    
		    				    <td>${good.storenum}</td>
		    				     
		    					<td>
		    						<c:if test="${good.status==0 }">启用</c:if>
		    						<c:if test="${good.status==1 }">停用</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_addTime" data_id="${good.id }" data_p="${good.price }"><i class="iconfont icon-edit"></i> 添加</a>
		    					
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
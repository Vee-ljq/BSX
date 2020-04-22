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
	<form action="<%=path%>/web/data.action" method="post" id="form1">
	<blockquote class="layui-elem-quote news_search">

		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value="${comment.comment }"   name="comment" class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
			
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col>
				<col width="10%">
				<col width="10%">
				<col width="9%">
				<col width="9%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" /></th>
					
					<th>商品名称</th>
					<th>客户名称</th>
					<th>评论内容</th>
					<th>评论时间</th>
					<th>描述相符评价</th>
					<th>服务评价评价</th>
					<th>卖家服务评价</th>
					<th>物流评价</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="10">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="comment">
		    				<tr>
		    					<th><input type="checkbox" name="ids" value="${comment.id }" lay-skin="primary" /></th>
					
		    					<td>${comment.goods.goodsname }</td>
		    					<td>${comment.customer.realname}</td>
		    					<td>${comment.comment }</td>
		    					<td>${comment.createdate }</td>
		    					<td>
		    					<c:if test="${comment.level==0 }">好评</c:if>
		    					<c:if test="${comment.level==1 }">中评</c:if>
		    					<c:if test="${comment.level==2 }">差评</c:if>
		    					</td>
		    					<td>
		    					    ${comment.commentwl }
		    					</td>
		    					<td>
		    					<c:if test="${comment.levelSell==0 }">好评</c:if>
		    					<c:if test="${comment.levelSell==1 }">中评</c:if>
		    					<c:if test="${comment.levelSell==2 }">差评</c:if>
		    					</td>
		    					<td>
		    					<c:if test="${comment.levelWl==0 }">好评</c:if>
		    					<c:if test="${comment.levelWl==1 }">中评</c:if>
		    					<c:if test="${comment.levelWl==2 }">差评</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="${comment.id }" ><i class="layui-icon">&#xe640;</i> 删除</a>
		    					</td>
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${page.pageStr }</div>
	</form>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/comment/data.js"></script>

</body>
</html>
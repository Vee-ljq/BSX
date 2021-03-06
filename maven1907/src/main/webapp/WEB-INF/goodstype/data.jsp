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
	<title>快递</title>
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
	<form action="<%=path%>/goodstype/data.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<!-- 分页 -->
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value=""   name="sp" class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加一级商品</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn1">添加二级商品</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn2">添加三级商品</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
			</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="30">
				<col>
				<col width="20%">
				<!-- <col width="10%">
				<col width="20%">
				<col width="20%"> -->
				<col width="20%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					<th>一级商品类型</th>
					<th>二级商品类型</th>
					<th>商品</th>
					<th>发布人</th>
					<th>价格</th>
					<th>库存</th>
					<th>是否上架</th>
					<th>操作</th>
					
				</tr> 
		    </thead>
		  <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="5">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="org">
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
								<td>${org.sgtype.typename}</td>
		    					<td>${org.typename}</td>
		    					<td>${org.bgoods.goodsname}</td>
		    					<td>${org.user.realname }</td>
		    					<td>${org.bgoods.price }</td>
		    					<td>${org.bgoods.storenum}</td>
		    					<td>
		    					<c:if test="${org.bgoods.status==0 }">下架</c:if>
		 						<c:if test="${org.bgoods.status==1 }">上架</c:if>
		    					</td>
		    					<td>
		    					
		    					<a class="layui-btn layui-btn-mini news_edit"   data_id="${org.bgoods.id}"><i class="iconfont icon-edit"></i> 编辑</a>
		    					<a class="layui-btn layui-btn-danger layui-btn-mini news_del"  data-id="${org.bgoods.id}" ><i class="layui-icon">&#xe640;</i> 删除</a>
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
	<script type="text/javascript" src="<%=path %>/js/goodsList/data2.js"></script>

</body>
</html>
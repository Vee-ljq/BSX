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
<form action="<%=path%>/goodstype/Onetwo.action"  id="form1">
	<blockquote class="layui-elem-quote news_search">
	
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value="${typename}"   name="typename" class="layui-input search_input">
		  		<input type="hidden" value="${id}"   name="id" class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input  type="submit" class="layui-btn search_btn" value="查询"/>
			<div class="layui-inline">
			<a class="layui-btn layui-btn-normal goodstypeAdd_btn">添加商品类型</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger goodstypebatchDel">批量删除</a>
		</div>
		</div>
		
		
			
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="30%">
				<col width="30%">
				<col width="30%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>商品类型</th>
					<th>类别等级</th>
					<th>状态</th>
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
		    			<c:forEach items="${page.page.list }" var="goodstype">
		    				<tr>
		    					<th><input name="ids" value="${goodstype.id }" type="checkbox"  lay-skin="primary" ></th>
					
		    					<td><a href="<%=path %>/goodstype/Onetwo.action?id=${goodstype.id }">${goodstype.typename }</a></td>
		    					<td>
		    						<c:if test="${goodstype.pid==0 }">一级类型</c:if>
		    						<c:if test="${goodstype.pid!=0 }">二级类型</c:if>
		    					</td>
		    					<td>
		    					<c:if test="${goodstype.status==1 }">启用</c:if>
		    					<c:if test="${goodstype.status==0 }">停用</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini goodstype_edit" data_id="${goodstype.id }" yijiid="${id }"><i class="iconfont icon-edit"></i> 编辑</a>
		    					<a class="layui-btn layui-btn-danger layui-btn-mini goodstype_del" data-id="${goodstype.id }" yijiid="${id }"><i class="layui-icon">&#xe640;</i> 删除</a>
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
	<script type="text/javascript" src="<%=path %>/js/goodsOnetwo/data.js"></script>
<form action="<%=path%>/goodstype/Onetwo.action"  id="form1">
</body>
</html>
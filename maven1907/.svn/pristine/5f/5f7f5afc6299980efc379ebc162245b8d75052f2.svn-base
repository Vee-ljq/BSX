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
	<title>活动发布后台管理</title>
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
	<form action="<%=path%>/goods/activitiesData.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNumber" value="${activitiesPage.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${activitiesPage.page.pageSize }"/>
		    	<input type="text" value="${type }" name="contexttopic"  placeholder="请输入活动编号或活动主题"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加活动</a>
		</div>
	</form>
	</blockquote>
	
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="12%">
				<col width="20%">
				<col width="40%">
				<col width="15%">
				<col width="15%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					<th>活动编号</th>
					<th>活动主题</th>
					<th>活动内容</th>
					<th>活动状态</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(activitiesPage.page.list)==0 }">
		    			<tr>
		    				<td colspan="8">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${activitiesPage.page.list }"  var="activities" >
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
		    					<td>${activities.type }</td>
								<td>${activities.contexttopic }</td>
		    					<td>${activities.context.context }</td>
		    					<td>
			    					<c:if test="${activities.status==0 }">下线</c:if>
			    					<c:if test="${activities.status==1 }">上线</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_edit" data_id="${activities.id }"><i class="iconfont icon-edit"></i> 编辑</a>	    					
		    					</td>
		    				
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${activitiesPage.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/goods/activitiesdata.js"></script>

</body>
</html>
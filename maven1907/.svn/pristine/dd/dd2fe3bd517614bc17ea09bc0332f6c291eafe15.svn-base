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
	<form action="<%=path%>/user/data.action">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value="${user.realname }"   name="realname"  placeholder="请输入姓名或账户"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加用户</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
			</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col>
				<col width="9%">
				<col width="5%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>账号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>所属机构</th>
					<th>角色</th>
					<th>最后登录时间</th>
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
		    			<c:forEach items="${page.page.list }" var="user">
		    				<tr>
		    					<th><input type="checkbox" name="checked" lay-skin="primary" ></th>
					
		    					<td>${user.loginaccount }</td>
		    					<td>${user.realname }</td>
		    					<td>
		    					<c:if test="${user.sex==0 }">女</c:if>
		    					<c:if test="${user.sex==1 }">男</c:if>
		    					</td>
		    					<td>${user.phone }</td>
		    					<td>${user.org.orgname }</td>
		    					<td>${user.role.rolename }</td>
		    					<td>${user.lastlogin }</td>
		    					<td>
		    					<c:if test="${user.status==0 }">启用</c:if>
		    					<c:if test="${user.status==1 }">停用</c:if>
		    					</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini news_edit" data_id="${user.id }"><i class="iconfont icon-edit"></i> 编辑</a>
		    					<a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="${user.id }" ><i class="layui-icon">&#xe640;</i> 删除</a>
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
	<script type="text/javascript" src="<%=path %>/js/user/data.js"></script>

</body>
</html>
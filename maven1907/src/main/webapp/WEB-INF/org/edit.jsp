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
	<title>文章添加--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/org/save.action" method="post" target="_parent">
		<div class="layui-form-item">
			<label class="layui-form-label">组织机构名称</label>
			<div class="layui-input-block">
				<input type="hidden" name="id" id="id" value="${org.id }"/>
				<input type="text" name="orgname" value="${org.orgname }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">上级机构</label>
			<div class="layui-input-block">
				<select name="pid" value="${parents }">
					<option value="0">无上级组织</option>
					<c:forEach items="${parents }" var="pp">
						<option value="${pp.id }" <c:if test="${pp.id==org.pid }">selected</c:if> >${pp.orgname }</option>
					</c:forEach>
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">负责人</label>
			<div class="layui-input-block">
				<select name="principalid" value="${user }">
					
					<c:forEach items="${user }" var="pp">
						<option value="${pp.id }" <c:if test="${pp.sOId==org.pid }">selected</c:if> >${pp.realname }</option>
					</c:forEach>
					
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="status" value="${org.status }">
					<option value="0">启用</option>
					<option value="1">停用</option>
				</select>
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" type="submit" lay-filter="addNews">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/layui/page/news/newsAdd.js"></script>
</body>

<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	
})


</script>
</html>
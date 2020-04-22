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
	<form class="layui-form" action="<%=path%>/goodstype/updategoodstype.action" method="post" target="_parent">
		 <div class="layui-input-inline">
		 		<input type="hidden" value="${yijiid}"   name="yijiid" class="layui-input search_input">
		  		<input type="hidden" value="${goodstype.id}"   name="id" class="layui-input search_input">
		    </div>
		<div class="layui-form-item">
			<label class="layui-form-label">类型级别</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<input type="test" value="<c:if test="${goodstype.pid==0 }">一级类别</c:if><c:if test="${goodstype.pid!=0 }">二级类别</c:if>" readonly="readonly" class="layui-input newsName" lay-verify="required"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">类型名称:</label>
			<div class="layui-input-block">
				<input type="text" name="typename" value="${goodstype.typename }" class="layui-input newsName" lay-verify="required" placeholder="请输入类型名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="status">
					<option value="1" <c:if test="${goodstpye.status==1 }">selected</c:if>>启用</option>
					<option value="0">停用</option>
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
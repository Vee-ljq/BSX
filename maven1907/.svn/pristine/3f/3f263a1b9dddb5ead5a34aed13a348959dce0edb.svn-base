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
	<title>修改信息页面</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
</head>
<body class="childrenBody">
<form action="">
		<div class="layui-form-item">
			<label class="layui-form-label">订单编号</label>
			<div class="layui-input-block">
				<input type="text" name="orderno" value="${detail.orderno }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-block">
				<input type="text" name="goodsname" value="${detail.goods.goodsname }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-block">
				<input type="text" name="realname" value="${detail.BCustomer.realname }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户联系方式</label>
			<div class="layui-input-block">
				<input type="text" name="mobile" value="${detail.BCustomer.mobile }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户地址</label>
			<div class="layui-input-block">
			<br/>
				省: <input type="text" name="detailname" value="${detail.vie.provencename }" class="layui-input newsName" lay-verify="required">
				市: <input type="text" name="detailname" value="${detail.vie.cityname }" class="layui-input newsName" lay-verify="required">
				县:<input type="text" name="detailname" value="${detail.vie.xname }" class="layui-input newsName" lay-verify="required">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">支付宝交易号</label>
			<div class="layui-input-block">
				<input type="text" name="zfborderno" value="${detail.zfborderno }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">创建时间</label>
			<div class="layui-input-block">
				<input type="text" name="createdate" value="${detail.createdate }" class="layui-input newsName" lay-verify="required">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">付款时间</label>
			<div class="layui-input-block">
				<input type="text" name="fkdate" value="${detail.fkdate }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发货时间</label>
			<div class="layui-input-block">
				<input type="text" name="fhdate" value="${detail.fhdate }" class="layui-input newsName" lay-verify="required" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<c:choose>
					<c:when test="${detail.status==0 }">
						<input type="text" name="fhdate" value="待付款" class="layui-input newsName" lay-verify="required" >
					</c:when>
					<c:when test="${detail.status==1 }">
						<input type="text" name="fhdate" value="待发货" class="layui-input newsName" lay-verify="required" >
					</c:when>
					<c:when test="${detail.status==2 }">
						<input type="text" name="fhdate" value="待签收" class="layui-input newsName" lay-verify="required" >
					</c:when>
					<c:otherwise>
						<input type="text" name="fhdate" value="待评价" class="layui-input newsName" lay-verify="required" >
					</c:otherwise>
				</c:choose>
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
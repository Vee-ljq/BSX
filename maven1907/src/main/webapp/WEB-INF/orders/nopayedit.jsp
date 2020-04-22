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
	<form class="layui-form" action="<%=path%>/order/saveNoPay.action" method="post" target="_parent">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名:</label>
			<div class="layui-input-block">
				<input type="hidden" name="bcustomer.id" id="id" value="${nopaydto.bcustomer.id }"/>
				<input type="text" name="bcustomer.nickname" value="${nopaydto.bcustomer.nickname }" class="layui-input newsName" lay-verify="required" placeholder="请输入用户名">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号:</label>
			<div class="layui-input-block">
				<input type="hidden" name="id" id="id" value=""/>
				<input type="text" name="bcustomer.mobile" value="${nopaydto.bcustomer.mobile }" class="layui-input newsName" lay-verify="required" placeholder="请输入角色名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">省</label>
			<div class="layui-input-block">
				<select name="areadata1.codeid"  id="province" lay-filter="province">
					<c:forEach items="${province }" var="p">
						<option value="${p.codeid }" <c:if test="${p.codeid==nopaydto.areadata1.codeid }">selected</c:if> onclick="clic()">${p.cityname }</option>
					</c:forEach>
				</select>
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">市</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="areadata2.codeid" id="city" lay-filter="city">
					<c:forEach items="${city }" var="p">
						<option value="${p.codeid }" <c:if test="${p.codeid==nopaydto.areadata2.codeid }">selected</c:if> onclick="clic()">${p.cityname }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">县</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="areadata3.codeid" id="xian">
					<c:forEach items="${xian }" var="p">
						<option value="${p.codeid }" <c:if test="${p.codeid==nopaydto.areadata3.codeid }">selected</c:if> onclick="clic()">${p.cityname }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">详细地址:</label>
			<div class="layui-input-block">
				<input type="hidden" name="addressid" value="${nopaydto.addressid }"/>
				<input type="text" name="baddress.address" value="${nopaydto.baddress.address }" class="layui-input newsName" lay-verify="required" placeholder="请输入详细住址">
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
		alert(form)
		/*  */
		form.on('select(province)',function(data){
			$("#xian").empty();
			$("#xian").append("<option value='' style='display:none'>请选择县</option>");
			form.render('select');
			var provinceid = $("#province").val();
			$("#city").empty();
			
			$.ajax({
				type: "GET",
	             url: "procityxian.action",
	             data:"id="+provinceid,
	             success: function(data){
	             	alert("已经获取到数据")
	             	$.each(data,function(i,result){
	             		
	             		//$("#city").append("<option></option>");
	             		 $("#city").append("<option value='"+result.codeid+"' id='cityoption'>"+result.cityname+"</option>");	
	             		
	             		  
	             	});
	             	form.render('select');
              }
	});
		});
	form.on('select(city)',function(data){
			$("#xian").empty();
			var cityid = $("#city").val();
			alert(cityid)
			$.ajax({
				type: "GET",
	             url: "procityxian.action",
	             data:"id="+cityid,
	             success: function(data){
	             	alert("已经获取到数据")
	             	$.each(data,function(i,result){
	             		
	             		//$("#city").append("<option></option>");
	             		 $("#xian").append("<option value='"+result.codeid+"'>"+result.cityname+"</option>");	 
	             	});
	             	form.render('select');
              }
	});
		});
		
	
})

</script>
<!-- <script type="text/javascript">
	alert("1111")
	var provinceid = $("#province").val();
	alert(provinceid)
	function nopay(){
		alert("已经进入到onchange方法")
		$.ajax({
			type: "GET",
             url: "order/procityxian.action",
             data:"id="+provinceid,
             success: function(data){
             	alert("已经获取到数据")
             	$.each(data,function(i,result){
             		$("#city").html("<option value='"+result.codeid+"'>"+result.cityname+"</option>");	
             	
             	});
              }
	});
	
	}

</script> -->
</html>
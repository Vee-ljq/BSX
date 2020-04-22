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
	<title>添加商品列表</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/goodstype/selecttj.action" method="post" target="_parent">
	<input type="hidden" name="idd" value="${id }"/>

		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 85px">一级商品类型</label>
			<select style="width: 100px" name="id" id="yiji" lay-filter="yiji" >
				<option value="${xg.id}" >${xg.typename}</option>
				<c:forEach items="${selectids}" var="aa" >
					<option value="${aa.id}">${aa.typename}</option>
				</c:forEach>
			</select>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 85px" >二级商品类型</label>
			<select style="width: 100px" id="city" name="erjiid">
			<option value="${xg.sgtype.id }">${xg.sgtype.typename}</option>
			</select>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 85px">三级商品类型</label>
			<div class="layui-input-block">
				<input type="text" style="width: 200px" name="goodsname" value="${xg.bgoods.goodsname }" class="layui-input newsName" lay-verify="required" placeholder="">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 85px" >发布人</label>
			<select style="width: 100px"  name="userid">
				<option value="${xg.user.id }">${xg.user.realname }</option>
				<c:forEach items="${user}" var="aa" >
					<option value="${aa.id}">${aa.realname}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="layui-form-item" >
			<label class="layui-form-label" style="width: 85px">价格</label>
			<div class="layui-input-block">
				<input type="text" style="width: 200px" name="price" value="${xg.bgoods.price}" class="layui-input newsName" lay-verify="required" placeholder="">
			</div>
		</div>
		
		<div class="layui-form-item" >
			<label class="layui-form-label" style="width: 85px">库存</label>
			<div class="layui-input-block">
				<input type="text" style="width: 200px" name="storenum" value="${xg.bgoods.storenum}" class="layui-input newsName" lay-verify="required" placeholder="">
			</div>
		</div>
		
		<select name="status" >
		<option value="0" <c:if test="${xg.bgoods.status==0 }">selected</c:if>>下架	</option>
		<option value="1" <c:if test="${xg.bgoods.status==1 }">selected</c:if>>上架</option>
		</select>
		
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
		form.on('select(yiji)',function(data){
			
			var yiji = $("#yiji").val();
			
			$.ajax({
				type: "post",
	             url: "blerji1.action",
	             data:"id="+yiji,
	             success: function(data){
	             	 $("#city").empty();
	             	$.each(data,function(i,result){
	             	
	             		
	             		 $("#city").append("<option value='"+result.id+"' id='cityoption'>"+result.typename+"</option>");	
	             		
	             		  
	             	});
	             	form.render('select');
              }
	});
		});
	
})
/* var id=document.getElementById("#id").html;

$ajax({
	type:"post",
	url:"goodstype/blerji.action",
	data:"id="+id,
	success:function(data){
		alter("获取二级列表")
		$.each(data,function(result){
			
		})
	}


}) */


</script>
</html>
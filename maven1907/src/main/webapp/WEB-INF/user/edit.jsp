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
	<title>用户编辑</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
</head>
<body class="childrenBody">
<!-- onsubmit可以在表单提交以前进行验证，定义function，返回true，表单自动提交，返回false时，不进行表单提交  onsubmit="return methodName()" -->
	<form class="layui-form" action="<%=path%>/role/save.action" method="post" target="_parent" onsubmit="return checkPwd()">
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<input type="hidden" name="id" id="userId" value="${requestScope.user.id }"/>
				<input type="text" name="loginaccount" value="${requestScope.user.loginaccount }" class="layui-input newsName" lay-verify="required" placeholder="请输入账户">
			</div>
		</div>
		<c:if test="${requestScope.user.id==null }">
			<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" name="pwd"  id="pwd" value="${requestScope.user.pwd }" class="layui-input newsName" lay-verify="required" placeholder="请输入密码"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="text"  id="pwd2" value="${requestScope.user.pwd }" class="layui-input newsName" lay-verify="required" placeholder="请再次输入密码"/>
			</div>
		</div>
		
		</c:if>
		
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" name="realname"  value="${requestScope.user.realname }" placeholder="请输入姓名" class="layui-input newsName" lay-verify="required"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="sex" value="${requestScope.user.sex}">
					<option value="0" <c:if test="${requestScope.user.sex==0}">selected</c:if>>女</option>
					<option value="1">男</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机</label>
			<div class="layui-input-block">
				<input type="text" name="phone"  value="${requestScope.user.phone }" placeholder="请输入手机号" class="layui-input newsName" lay-verify="required"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">组织机构</label>
			<div class="layui-input-block">
				<select name="sOId" >
					<option value="0">无上级组织</option>
					<c:forEach items="${orgs }" var="pp">
						<option value="${pp.id }" <c:if test="${requestScope.user.sOId==pp.id }">selected</c:if> >${pp.orgname }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select name="roleid" >
					<c:forEach items="${roles }" var="pp">
						<option value="${ pp.id}" <c:if test="${requestScope.user.roleid==pp.id }">selected</c:if> >${pp.rolename }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<%-- <input type="select" name="status" value="${org.status }" class="layui-input newsName" lay-verify="required" placeholder="请输入组织机构名称"> --%>
				<select name="status" value="${org.status }">
					<option value="0"  <c:if test="${requestScope.user.status==0}">selected</c:if>>启用</option>
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
	
});
function checkPwd(){
var userId = document.getElementById("userId").value;
if(userId.length==0){

var pwd1 = document.getElementById("pwd").value;
var pwd2 = document.getElementById("pwd2").value;
if(pwd1!=pwd2){
	alert("两次输入密码不一致")
	var pwd1 = document.getElementById("pwd").value="";
	var pwd2 = document.getElementById("pwd2").value="";
	return false;
}
}
else{
return true;
}
}


</script>
</html>
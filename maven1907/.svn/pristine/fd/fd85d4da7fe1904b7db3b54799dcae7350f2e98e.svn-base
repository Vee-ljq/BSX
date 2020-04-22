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
	<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/js/layui/css/news.css" media="all" />
	<link rel="stylesheet" href="<%=path %>/js/ace/css/ace.css" media="all" />
 	<link rel="stylesheet" href="<%=path%>/js/ace/css/bootstrap.css"/>
</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/goods/AddOrupdateActivities.action" method="post" target="_parent" onsubmit="return checkPwd()" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${goodsInfo.id }"/>
		<div class="layui-form-item">
			<label class="layui-form-label">活动编号</label>
			<div class="layui-input-block">
				<input type="text" name="type" value="${goodsInfo.type }"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">活动主题</label>
			<div class="layui-input-block">
				<input type="text" name="contexttopic" value="${goodsInfo.contexttopic }"/>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">活动描述</label>
			<div class="layui-input-block">
				<textarea id="editor" name="context" type="text/plain" style="width:590px;height:500px;">${goodsInfo.context.context}</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block"  style="width:185px">			
			<select name="status">
				<option value="0" <c:if test="${goodsInfo.status==0}">selected</c:if>>下线</option>
				<option value="1" <c:if test="${goodsInfo.status==1}">selected</c:if>>上线</option>
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
	<script type="text/javascript" src="<%=path %>/js/orders/signfordata.js"></script>
	
	<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
		UE.getEditor('editor');
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
</body>
</html>
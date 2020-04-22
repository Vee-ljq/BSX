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
	<title>团购商品发布</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.all.js"></script>
<link href="<%=path %>/js/utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<!--引入CSS-->
<link rel="stylesheet" type="text/css" href="<%=path %>/js/webupload/webuploader.css">
<!--引入JS-->
<script type="text/javascript" src="<%=path %>/js/webupload/webuploader.js"></script>
<style>
   .layui-input-block1{
   padding:8px 0px 14px 0px;
   }
</style>

</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/goodstype/saveGroup.action" method="post" >
	<input type="hidden" name="type" value="1">
	<input type="hidden" name="bjid" value="${dto.bjgoods.id }">
	<input type="hidden" name="id" value="${dto.id }">
	<input type="hidden" name="goodsid" value="${dto.id }">
	<input type="hidden" name="status" value="${dto.status }">
		<div class="layui-form-item">
			<label class="layui-form-label">商品编号:</label>
			<div class="layui-input-block1">
				<span>${dto.goodsno }</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品类型:</label>
			<div class="layui-input-block1">
			<span>${dto.SGoodstype.typename }</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品名称:</label>
			<div class="layui-input-block1">
			<span>${dto.goodsname }</span>
			</div>
		</div>
			<div class="layui-form-item">
			<label class="layui-form-label">参考价格:</label>
			<div class="layui-input-block1" >
			<span > ${dto.ckprice } 元</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">实际价格:</label>
			<div class="layui-input-block">
				<input type="text" name="price" value="${dto.price }" style="width: 400px" class="layui-input newsName" lay-verify="required">
			</div>
		</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">起订量:</label>
			<div class="layui-input-block">
				<input type="text" name="ninnum" style="width: 400px" value="${dto.bjgoods.ninnum }" class="layui-input newsName" lay-verify="required" required="required">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">截止日期:</label>
			<div class="layui-input-block">
				<input type="date" name="enddate" class="layui-input newsName" style="width: 200px" required="required">
			</div>
		</div>
		<div class="layui-form-item" style="z-index:-1">
			<label class="layui-form-label">商品描述:</label>
			<div class="layui-input-block">
			<script id="editor" name="context" type="text/plain" style="width:450px;height:200px;">${goodsInfo.context.context}</script>
			</div>
		</div>
		
	
		
		<div class="layui-form-item">
			<label class="layui-form-label">商品重量:</label>
			<div class="layui-input-block1" style="padding: 10px 0px 14px 0px">
			<span>${dto.weight}</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品单位:</label>
			<div class="layui-input-block1">
			<span>${dto.unit }</span>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">库存:</label>
			<div class="layui-input-block1">
			<span>${dto.storenum }</span>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" type="submit" lay-filter="addNews">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
</body>

<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    
    </script>
</html>
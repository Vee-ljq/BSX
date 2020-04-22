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
 		<link rel="stylesheet" media="all" type="text/css" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css" />
		<link rel="stylesheet" media="all" type="text/css" href="<%=path %>/js/jQuery-Timepicker/src/jquery-ui-timepicker-addon.css" />
 	
</head>

<body class="childrenBody">

	<blockquote class="layui-elem-quote news_search">
	<form action="<%=path%>/quickbuy/save.action" target="_parent">
	<input type="hidden" name="goodsid" value="${id }">
	<input type="hidden" name="id" value="${goodsdto.id }">
	
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    抢购价格：
		 <input type="text" name="price"  placeholder="请输入抢购价格" value="${goodsdto.goods.price }"  class="layui-input">
		    </div> 
		     </div>
		      <br/>
		    <div class="layui-inline">
		    <div class="layui-input-inline">
		   
		  活动截止时间： 
 		 <input type="text" value="${goodsdto.enddate }" name="enddate" id="date"  placeholder="请输入截止日期"  class="layui-input">
 		    
  <!--  <input type="date" class="layui-input search_input" id="date" placeholder="yyyy-MM-dd">
  -->
 
 </div>
		  
		    
		</div>
		  <br/>
		 <div class="layui-inline">
		 <input type="submit" class="layui-btn search_btn" value="保存"/>
		 
		 </div>
	</form>		
	</blockquote>
	
	
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/quickbuy/data.js"></script>
	<script type="text/javascript" src="<%=path %>/js/zTree_v3/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/lay/modules/laydate.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/jQuery-Timepicker/src/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<%=path %>/js/dist/i18n/jquery-ui-timepicker-addon-i18n.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/jQuery-Timepicker/src/jquery-ui-sliderAccess.js"></script>
	

<script type="text/javascript">
layui.use('laydate', function(){
var laydate = layui.laydate;
$('#date').datetimepicker() ;
}); 
</script>
</body>
</html>
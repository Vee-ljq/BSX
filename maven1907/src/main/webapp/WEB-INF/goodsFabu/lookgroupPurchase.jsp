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
	<title>团购发布后台管理</title>
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

	<form action="<%=path%>/goodstype/toGroupPurchase.action" id="form1">
	<blockquote class="layui-elem-quote news_search">
	<input type="hidden" name="type" value="1">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNumber" value="${typePage.page.pageNum }"/>
		    	<input type="hidden" id="status" name="status" value="3"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${typePage.page.pageSize }"/>
		    	<input type="text" value="${name.goodsname }"   name="goodsname"  placeholder="请输入商品名称"  class="layui-input search_input">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		    <div class="layui-inline">
			<a class="layui-btn layui-btn-danger down_edit">批量下架</a>
		</div>
		</div>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="10%">
				<col width="12%">
				<col width="12%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose" ></th>
					
					<th>商品编号</th>
					<th>商品类型</th>
					<th>商品名称</th>
					<th>实际价格</th>
					<th>参考价格</th>
					<th>商品活动</th>
					<th>商品状态</th>
					<th>库存</th>
					<th>起订量</th>
					<th>操作</th>
					
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(typePage.page.list)==0 }">
		    			<tr>
		    				<td colspan="11">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${typePage.page.list }" var="orders">
		    			<c:if test="${orders.bjgoods.type==1}">
		    				<tr>
		    					<th><input type="checkbox" name="ids" lay-skin="primary" value="${orders.bjgoods.id }" lay-filter="choose"/></th>
		    					<td>${orders.goodsno }</td>
		    					<td>${orders.SGoodstype.typename }</td>
		    					<td>${orders.goodsname }</td>
		    					<td>${orders.price }</td>
		    					<td>${orders.ckprice }</td>
		    					<td><c:if test="${orders.bjgoods.type==null }">无活动</c:if>
		    					<c:if test="${orders.bjgoods.type==1 }">团购</c:if></td>
		    					<td><input type="checkbox" name="status" data_id=${orders.bjgoods.id } <c:if test="${orders.bjgoods.status==1 }">checked</c:if> lay-skin="switch" lay-text="上线|下线" id="status" lay-filter="switch"></td>
		    					<td>${orders.storenum }</td>
		    					<td>${orders.bjgoods.ninnum }</td>
		    					<td>
		    					<a class="layui-btn layui-btn-mini delete_Group" data_id="${orders.bjgoods.id}"><i class="iconfont icon-edit"></i> 删除</a>
		    					</td>
		    				</tr>
		    				</c:if>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	</form>
	<div id="page">${typePage.pageStr }</div>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/group/data.js"></script>
	<script type="text/javascript">
layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
layui.use('form', function(){
  var form = layui.form(),
  $ = layui.jquery;
  //监听提交
  form.on('switch(switch)', function(data){
 	var id = $(this).attr("data_id");
  	var i = data.elem.checked?"1":"0";
  	var a = this.checked;
    $.ajax({
    			 type: "GET",
	             url: "StandUpAndDown.action",
	             data:"id="+id+"&status="+i,
	             success: function(data){
	             	if(data){
   				 layer.msg("正在修改...",{
   				  time: 1000
   				  });
				return true;
    
    			}else{
    			 layer.msg("修改失败...",{
   				  time: 500
   				  });
    		$("input[name='status']").prop("checked",!a);
            form.render("checkbox");
    			return true;
    			}
    			}
  });
    return false;
});

});
})
	</script>
</body>
</html>
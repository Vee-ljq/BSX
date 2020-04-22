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
</head>
<body class="childrenBody">
	<form action="<%=path%>/floor/data.action" method="post" id="form1">
	<blockquote class="layui-elem-quote news_search">

		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="hidden" id="pageNumber" name="pageNum" value="${page.page.pageNum }"/>
		    	<input type="hidden" id="pageSize" name="pageSize" value="${page.page.pageSize }"/>
		    	<input type="text" value="${bfgoods.goodsno }"   name="goodsno" class="layui-input search_input"  placeholder="请输入商品编号或商品名称或商品类别查询">
		    </div>
		    <!-- <a class="layui-btn search_btn">查询</a> -->
		    <input type="submit" class="layui-btn search_btn" value="查询"/>
		</div>
			</form>
	</blockquote>
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="100">
				<col>
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				
		    </colgroup>
		    <thead>
				<tr>
					
					
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品类型</th>
					<th>商品信息</th>
					<th>状态</th>
					<!-- <th>操作</th> -->
				</tr> 
		    </thead>
		    <tbody class="news_content">
		    	<c:choose>
		    		<c:when test="${fn:length(page.page.list)==0 }">
		    			<tr>
		    				<td colspan="5">暂无数据</td>
		    			</tr>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${page.page.list }" var="bfgoods">
		    				<tr>
		    					<%-- <th><input type="checkbox" name="ids" value="${bfgoods.goodsid  }" lay-skin="primary" /></th> --%>
					
		    					<td>${bfgoods.bGoods.goodsno}</td>
		    					<td>${bfgoods.bGoods.goodsname}</td>
		    					<td>${bfgoods.sgoodstype.typename }</td>
		    					<td>${bfgoods.bwb.goodsinfo }</td>
		    					<%-- <td><c:if test="${bfgoods.flag==0 }">上架</c:if>
		    						<c:if test="${bfgoods.flag==1 }">下架</c:if>
		    					</td> --%>
		    					<td>
		    					<input type="checkbox" class="layui-form" data-id= "${bfgoods.id }" name="flag1" id ="flag1"  lay-skin="switch" lay-text="上架|下架"  lay-filter="listen"<c:if test="${bfgoods.flag==0 }">checked</c:if>>
		    					</td>
		    				</tr>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
		    </tbody>
		</table>
	</div>
	<div id="page">${page.pageStr }</div>
	
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/floor/data.js"></script>
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
		
		form.on('switch(listen)',function(data){
		var orgid = $(this).attr("data-id");
		var flag = data.elem.checked;
		var flags;
		if(flag){
			flags=0;
		}else{
			flags=1;
		}
		
		$.ajax({
			url:"savefloor.action",
			type:"post",
			data:{flag:flags,goodsid:orgid},
			success:function(result){
			
				if(result!=""){
					layer.msg("修改成功");
				}else{
					layer.msg("修改失败");
					flag = data.elem.checked;
					location.reload();
				}
				
			}
			
			
		})
		
	});
	
	
})

</script>
</body>
</html>
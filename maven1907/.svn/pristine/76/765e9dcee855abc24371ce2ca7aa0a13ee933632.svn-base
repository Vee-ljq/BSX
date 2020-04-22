<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  </head>
  <link rel="stylesheet" type="text/css" href="<%=path%>/js/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
  <script type="text/javascript" src="<%=path%>/js/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/zTree_v3/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="<%=path %>/js/zTree_v3/js/jquery.ztree.excheck.js"></script>
  <SCRIPT LANGUAGE="JavaScript">
   var zTreeObj;
   // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
   var setting = {
   		check:{
   			enable:true
   		},
   		data: {
				simpleData: {
					enable: true
				}
			},
		callback: {
				onCheck: onCheck
			}
   };
   //e:event对象，treeID:在创建树时指定的id treeNode：节点的json对象
   function onCheck(e, treeId, treeNode) {
   		alert(treeNode.checked)
   		$.getJSON("<%=path%>/resource/save.action?resourceId="+treeNode.id+"&roleId=${roleId}",function(ret){
   			alert(ret)
   		});
	}
   // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
  //异步请求来获取json数组
  //将json格式的字符串转为json对象或数组
   var zNodes = JSON.parse('${result}');
   
   $(document).ready(function(){
    <%-- $.getJSON("<%=path%>/resource/resourceAll.action",function(ret){
   			alert("11111")
   			zNodes = ret; --%>
   			 zTreeObj = $.fn.zTree.init($(".ztree"), setting, zNodes);
 /*   	}); */
   			
   });
  </SCRIPT>
  <body>
    <div class="ztree"></div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'kuaidiniao.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/web/js/jquery-1.7.2.min.js"></script>

  </head>
  
  <body>
   
<div class="about4" id="wlline">
	<div class="about4_ch">物流</div>
	<div class="about4_main">
		<div class="line"></div>
		<ul>
		</ul>
	
			<%
				String wlno =(String)request.getParameter("wlno");
				String logisticsum=(String)request.getParameter("logisticsum");
				pageContext.setAttribute("wlno", wlno);
				pageContext.setAttribute("logisticsum", logisticsum);
			 %>
			 <input type="hidden" value="${wlno}" id="wlno">
			 <input type="hidden" value="${logisticsum}" id="logisticsum">
		<div class="line"></div>
		
	</div>
</div>
  </body>
  <script type="text/javascript">
$(function(){

  var wlno=$("#wlno").val();
  var logisticsum=$("#logisticsum").val();
 

   $.ajax({
            url:"<%=path%>/goodskd/selectwuliu.action",
            data: {
            wlno:"YT4268597456448",
            logisticsum:"YTO"
            },
            type: "post",
            dataType: "json",
            success: function(result){

              for(var i=0;i<result.Traces.length;i++){
              $("#wlline ul").append("<li>"+ result.Traces[i].AcceptTime+"<br/>"+result.Traces[i].AcceptStation
    +"</li>");
              }

            }
        });
    });
    </script>
</html>

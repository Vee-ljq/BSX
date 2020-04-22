<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 80%; margin: 0">
   		请选择您查询的时间:
   	   <select style="margin:20px 70px 0px 0px;height:30px;width:100px;">
   	   		<option value="2019-01">2019-01</option>
   	   		<option value="2019-02">2019-02</option>
   	   		<option value="2019-03">2019-03</option>
   	   		<option value="2019-04">2019-04</option>
   	   		<option value="2019-05">2019-05</option>
   	   		<option value="2019-06">2019-06</option>
   	   		<option value="2019-07">2019-07</option>
   	   		<option value="2019-08">2019-08</option>
   	   		<option value="2019-09">2019-09</option>
   	   		<option value="2019-10">2019-10</option>
   	   		<option value="2019-11">2019-11</option>
   	   		<option value="2019-12">2019-12</option>
   	   </select>
       <div id="container" style="height: 100%;margin-top:40px"></div>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-gl/dist/echarts-gl.min.js"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts-stat/dist/ecStat.min.js"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=xfhhaTThl11qYVrqLZii6w8qE5ggnhrY&__ec_v__=20190126"></script>
       <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts/dist/extension/bmap.min.js"></script>
       <script type="text/javascript">
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			option = {
			    title: {
			        text: '商品流量统计分析',
			        left: 'center'
			    },
			    tooltip: {
			        trigger: 'item',
			        formatter: '{a} <br/>{b} : {c} ({d}%)'
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'left',
			        data: ${typename}
			    },
			    series: [
			        {
			            name: '访问来源',
			            type: 'pie',
			            radius: '55%',
			            center: ['50%', '60%'],
			            data: ${value},
			            emphasis: {
			                itemStyle: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};
			;
			if (option && typeof option === "object") {
			    myChart.setOption(option, true);
			}
       </script>
   </body>
</html>
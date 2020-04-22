layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//添加组织架构
	//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
	//$(window).one("resize",function(){
		$(".look_group").click(function(){
			var index = layui.layer.open({
				title : "团购商品",
				type : 2,
				area:['1000px','500px'],
				content : "toGroupPurchase.action?type=1",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				},
				end:function(){
					location.reload();
				}
			})			
			/*layui.layer.full(index);*/
		})
		
		$(".publishingGroup").click(function(){
			var id = $(this).attr("data_id");
			var status = $(this).attr("data_status");
			alert(status)
			if(status==1){
				alert("下架商品无法发布。")
				return false;
			}
			var index = layui.layer.open({
				title : "发布团购商品",
				type : 2,
				area:['700px','500px'],
				content : "publishingGroup.action?id="+id,
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				},
			end:function(){
				location.reload();
			}
			})			
			/*layui.layer.full(index);*/
		})
		
		
		$(".news_edit").click(function(){
			
			var cusName = $(this).attr("客户姓名");
			var index = layui.layer.open({
				title : "修改组织架构",
				type : 2,
				area:['500px','300px'],
				content : "edit.action?id="+orgid,
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
		});
		
$(".orders_detail").click(function(){
			var id = $(this).attr("data_id");
			var index = layui.layer.open({
				title : "商品详情",
				type : 2,
				area:['800px','600px'],
				content : "detailEdit.action?id="+id+"&flag=1",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
		});

$(".shipments-edit").click(function(){
	var id = $(this).attr("data_id");
	var index = layui.layer.open({
		title : "发货",
		type : 2,
		area:['800px','600px'],
		content : "ordermainMapperEdit.action?id="+id,
		success : function(layero, index){
			setTimeout(function(){
				layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			},500)
		},
		end:function(){
			location.reload();
		}	
	})		
});

$(".new-edit").click(function(){
	var id = $(this).attr("data_id");
	var index = layui.layer.open({
		title : "修改信息",
		type : 2,
		area:['700px','1200px'],
		content : "detailEdit.action?id="+id+"&flag=2",
		success : function(layero, index){
			setTimeout(function(){
				layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			},500)
		},
		end:function(){
			location.reload();
		}
	})			
});

		$(".news_editNopay").click(function(){
			var orderId = $(this).attr("data_id");
			var index = layui.layer.open({
				title : "修改客户信息",
				type : 2,
				area:['500px','400px'],
				content : "edit.action?id="+orderId,
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				},
			end:function(){
				location.reload();
			}
			})			
		});
		
	$("body").on("click",".delete_Group",function(){  //删除
		var orgid = $(this).attr("data_id");
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			document.location.href="deleteGroup.action?id="+orgid;
			layer.close(index);
		});
	})
	
	//批量下架
	$(".down_edit").click(function(){
		
		var $checkbox = $('.news_list tbody input[type="checkbox"][name="ids"]');
		var $checked = $('.news_list tbody input[type="checkbox"][name="ids"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定下架选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('下架中，请稍候',{icon: 16,time:false,shade:0.8});
				/*function(){
					//删除数据
					var ids="";
	            	for(var j=0;j<$checked.length;j++){
	            		ids=$checked.eq(j).parents("tr").find(".news_del").attr("data-id");
	            	}
	            	alert(ids);
	            	document.location.href="org/deleteOrgs.action?id="+ids;
	            	$('.news_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
				});*/
	            setTimeout(function(){
	            	$("#form1").attr("action","StandsUpAndDown.action");
	            	$("#form1").submit();
	            	//下架数据
	            	$('.news_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("下架成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要下架的商品");
		}
	})
	
	
	$("body").on("click",".news_qx",function(){  //权限
		
		var _this = $(this);
		var orgid = _this.attr("data-id");
		
		var index = layui.layer.open({
			title : "编辑权限信息",
			type : 2,
			area:['500px','300px'],
			content : "../resource/toResource.action?roleId="+orgid,
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500)
			}
		})		
	})
	
	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.news_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.news_list tbody input[type="checkbox"][name="checked"]:checked');
		
		
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            		var url="deletes.action?ids=";
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		if(j==$checked.length-1){
	            			url+=$checked.eq(j).parents("tr").find(".news_del").attr("data-id");
	            		}else{
	            			url+=$checked.eq(j).parents("tr").find(".news_del").attr("data-id")+"&ids=";
	            		}
	            	}
	            		document.location.href=url;
	            	$('.news_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("下架成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要下载的商品");
		}
	})
	
	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

//});
});
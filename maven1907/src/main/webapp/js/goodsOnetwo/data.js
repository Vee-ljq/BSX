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
		$(".newsAdd_btn").click(function(){
			var index = layui.layer.open({
				title : "新增订单",
				type : 2,
				area:['500px','300px'],
				content : "edit.action",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			/*layui.layer.full(index);*/
		})
		$(".goodstypeAdd_btn").click(function(){
			alert("11111")
			var index = layui.layer.open({
				title : "新增订单",
				type : 2,
				area:['500px','300px'],
				content : "tianjia.action",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
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
$(".goodstype_edit").click(function(){
			
			var id = $(this).attr("data_id");
			var yijiid = $(this).attr("yijiid");
			alert(id)
			alert(yijiid)
			var index = layui.layer.open({
				title : "修改商品名称",
				type : 2,
				area:['500px','300px'],
				content : "editgoodstype.action?id="+id+"&yijiid="+yijiid,
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
		}
	})			
});

$(".new-edit").click(function(){
	var id = $(this).attr("data_id");
	var index = layui.layer.open({
		title : "修改信息",
		type : 2,
		area:['700px','600px'],
		content : "detailEdit.action?id="+id+"&flag=2",
		success : function(layero, index){
			setTimeout(function(){
				layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			},500)
		}
	})			
});

		$(".news_editNopay").click(function(){
			
			var orderId = $(this).attr("data_id");
			alert(orderId)
			var index = layui.layer.open({
				title : "修改客户信息",
				type : 2,
				area:['500px','300px'],
				content : "edit.action?id="+orderId,
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
		});
	$("body").on("click",".news_del",function(){  //删除
		
		var _this = $(this);
		var orgid = _this.attr("data-id");
		
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			document.location.href="role/delete.action?id="+orgid;
			
			layer.close(index);
		});
	})
	$("body").on("click",".goodstype_del",function(){  //删除
		var status = 0;
		var _this = $(this);
		var goodstypeid = _this.attr("data-id");
		var yiji = "";
		if( _this.attr("yijiid")!=null&& _this.attr("yijiid")!=""){
			yiji = _this.attr("yijiid");
		}
		alert(goodstypeid)
		alert(yiji+"222")
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			document.location.href="goodstype/delete.action?id="+goodstypeid+"&yiji="+yiji+"&status="+status;			
			layer.close(index);
		});
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
		alert("1111");
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
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
	})
	//批量删除
	$(".goodstypebatchDel").click(function(){
		alert("1111");
		var $checkbox = $('.news_list tbody input[type="checkbox"][name="ids"]');
		var $checked = $('.news_list tbody input[type="checkbox"][name="ids"]:checked');
		alert($checked.length)
		
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	$("#form1").attr("action","deletes.action");
	            	$("#form1").submit();
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的商品类型");
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
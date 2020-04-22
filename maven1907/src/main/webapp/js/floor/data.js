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
				title : "发布今日推荐",
				type : 2,
				area:['500px','300px'],
				content : "edit.action",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回今日推荐列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			/*layui.layer.full(index);*/
		})
		
		
		$(".news_edit").click(function(){
			
			var orgid = $(this).attr("data_id");
			var index = layui.layer.open({
				title : "修改今日推荐商品",
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
		
	$("body").on("click",".news_del",function(){  //删除
		
		var _this = $(this);
		var orgid = _this.attr("data-id");
		alert(orgid);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			document.location.href="comment/delete.action?id="+orgid;
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
		});		
	});
	
	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.news_list tbody input[type="checkbox"][name="ids"]');
		var $checked = $('.news_list tbody input[type="checkbox"][name="ids"]:checked');
		alert($checked);
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	$("#form1").attr("action","deletes.action");
	            	$("#form1").submit();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        });
		}else{
			layer.msg("请选择需要删除的");
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
	//改变状态
	form.on('checkbox(switch)',function(data){
		var orgid = _this.attr("data-id");
		var flag = data.elem.checked;
		var flags;
		if(flag){
			flags=0;
		}else{
			flags=1;
		}
		
		$.ajax({
			url:"edit.action",
			type:"post",
			data:{flag:flags,id:orgid},
			success:function(result){
				if(result){
					layer.msg("修改成功");
				}else{
					layer.msg("修改失败");
					
				}
				
			}
			
			
		})
		
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
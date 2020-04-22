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
	var index;
		$(".newsAdd_btn").click(function(){
			 index = layui.layer.open({
				title : "添加闪购商品",
				type : 2,
				area:['800px','500px'],
				content : "edit.action",
				success : function(layero, index){
				
					setTimeout(function(){
						layui.layer.tips('点击此处返回商品列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			/*layui.layer.full(index);*/
		})
		function a(){
			layui.layer.close(index);	
		}
		
		$(".news_edit").click(function(){
			
			var orgid = $(this).attr("data_id");
			var index = layui.layer.open({
				title : "编辑闪购商品信息",
				type : 2,
				area:['800px','500px'],
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
		
     $(".news_editTj").click(function(){
			
			var dtoid = $(this).attr("data_id");
			var goodid=$(this).attr("data_goodid");

			var index = layui.layer.open({
				title : "编辑闪购商品信息",
				type : 2,
				area:['800px','500px'],
				content : "editEnddate.action?id="+dtoid+"&goodid="+goodid,
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
		});		
		
		
	//点击添加闪购商品的添加按钮
		
$(".news_addTime").click(function(){
			var orgid = $(this).attr("data_id");
			var data_p = $(this).attr("data_p");
			
		
			document.location.href="addEnddate.action?id="+orgid;
		});
		
	$("body").on("click",".news_del",function(){  //删除
		
		var _this = $(this);
		var orgid = _this.attr("data-id");
		
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			document.location.href="user/delete.action?id="+orgid;
			
			layer.close(index);
		});
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
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
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
	
	
	//修改闪购商品的状态
	form.on("switch(status)",function(data){
		var id=$(this).attr("data-id");
		
		var status=data.elem.checked;
		var sta;
		if(status){
			sta=1;
		}else{
			sta=0;
		}
		$.ajax({
			url:"editStatus.action",
			data:{status:sta,id:id},
			type:'post',
			success:function(flag){
				if(flag){
					layer.msg("修改成功");
				}else{
					layer.msg("修改失败");
				}
			}
			
		})
		
		
	});
	
	
//});
});
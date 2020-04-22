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
		
		//单个确认收货
		$(".news_edit").click(function(){
			
			var ordersid = $(this).attr("data_id");
			layer.confirm('确定确认收货吗？',{icon:3, title:'提示信息'},function(index){
				document.location.href="order/updateSignforOrder.action?ordersId="+ordersid;
				
				layer.close(index);
			});	
		});	

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
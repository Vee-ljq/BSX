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
	<title>文章添加--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/ueditor.all.js"></script>
<link href="<%=path %>/js/utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="<%=path %>/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<!--引入CSS-->
<!--引入JS-->
<link rel="stylesheet" type="text/css" href="<%=path%>/js/webuploader-0.1.5/webuploader.css">
<script type="text/javascript" src="<%=path%>/web/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/webuploader-0.1.5/webuploader.js"></script> 

</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/duopic/saveDuoPic.action" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">商品编号:</label>
			<div class="layui-input-block">
				<select id="goodstype" lay-filter="yiji" name="goodsid">
					<c:forEach items="${goods }" var="g">
						<option value="${g.id }" >${g.id}${g.goodsname }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">上传图片:</label>
			  <div id="uploader" class="wu-example">
			    <!--用来存放文件信息-->
			    <div id="thelist" class="uploader-list"></div>
			    <div class="btns" >
			    	<input type="hidden" name="url" value="" id="url"/>
			        <div id="picker">选择文件</div>
			        <button style="margin-left:120px"  id="ctlBtn" type="button" class="btn btn-default" onclick="upload()">开始上传</button>
			    </div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">是否作为首图:</label>
			<div class="layui-input-block">
			<select name="isfirst" lay-filter="yiji">
					<option value="0">是</option>
					<option value="1">不是</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发布人:</label>
			<div class="layui-input-block">
				<select name="userid" id="users" lay-filter="yiji">
					<c:forEach items="${users }" var="p">
						<option value="${p.id }" >${p.realname }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发布时间:</label>
			<div class="layui-input-block">
				<input type="date" name="createdate" value="" class="layui-input newsName" lay-verify="required" placeholder="年/月/日">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态:</label>
			<div class="layui-input-block">
			<select name="status" lay-filter="yiji">
					<option value="0">上架</option>
					<option value="1">下架</option>
			</select>
			</div>
		</div>
		
		
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" type="submit" lay-filter="addNews">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
</body>

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
		
})
</script>
<script type="text/javascript">

var uploader = WebUploader.create({


    // swf文件路径
    swf:  '<%=path%>/js/webuploader-0.1.5/Uploader.swf',

    // 文件接收服务端。
    server: '<%=path%>/quickbuy/file.action',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',

    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false
  
});
var $list = $("#thelist");
// 当有文件添加进来的时候
uploader.on( 'fileQueued', function( file) {
	
    var $li = $(
            '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
            '</div>'
            ),
        $img = $li.find('img');


    // $list为容器jQuery实例
    $list.append( $li );

    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    uploader.makeThumb( file, function( error, src ) {
        if ( error ) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }

        $img.attr( 'src', src );
    }, thumbnailWidth, thumbnailHeight );
});
// 文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
    var $li = $( '#'+file.id ),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if ( !$percent.length ) {
        $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
    }

    $percent.css( 'width', percentage * 100 + '%' );
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on( 'uploadSuccess', function( file,response ) {
	alert("1111")
	var name = response.name;
	$("#url").val(name);
	alert(name)
    $( '#'+file.id ).addClass('upload-state-done');
});

// 文件上传失败，显示上传出错。
uploader.on( 'uploadError', function( file ) {
    var $li = $( '#'+file.id ),
        $error = $li.find('div.error');

    // 避免重复创建
    if ( !$error.length ) {
        $error = $('<div class="error"></div>').appendTo( $li );
    }

    $error.text('上传失败');
});

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on( 'uploadComplete', function( file ) {

    $( '#'+file.id ).find('.progress').remove();
});
// 文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
    var $li = $( '#'+file.id ),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if ( !$percent.length ) {
        $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
    }

    $percent.css( 'width', percentage * 100 + '%' );
});

function upload(){
uploader.upload();

}

</script>
</html>
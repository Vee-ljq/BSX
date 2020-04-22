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
	<title>添加用户</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=path %>/js/layui/layui/css/layui.css" media="all" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/js/webuploader-0.1.5/webuploader.css">
	<script type="text/javascript" src="<%=path%>/web/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/webuploader-0.1.5/webuploader.js"></script> 
 

</head>
<body class="childrenBody">
	<form class="layui-form" action="<%=path%>/cust/save.action" method="post" target="_parent">
		<div class="layui-form-item">
			<label class="layui-form-label">用户昵称</label>
			<div class="layui-input-block">
			
				<input type="hidden" name="id" id="id" value="${org.id }"/>
				<input type="text" name="nickname" value="${org.nickname }" class="layui-input newsName" lay-verify="required" placeholder="请输入用户昵称">
			</div>
		</div>
		<c:if test="${empty org.id }">
			<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" required="required" name="pwd" value="${org.pwd }" class="layui-input newsName" lay-verify="required"/>
			</div>
		</div>
		
		
		</c:if>
		
		<div class="layui-form-item">
			<label class="layui-form-label">头像</label>
			<c:if test="${empty org.url }">
				<img id="tx" src="<%=path%>/web/images/no-img_mid_.jpg" width="50px" height="50px"/>
			</c:if>
			<c:if test="${!empty org.url }">
				<img id="tx" src="<%=path%>/upload/${org.url}" width="50px" height="50px"/>
			</c:if>
			
			<div class="layui-input-block">
				<%-- <input type="file" accept="image/*"  name="url" value="${org.url }" class="layui-input newsName" lay-verify="required"/> --%>
			
			 <div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择头像</div>
        <input type="hidden" id="url" name="url" value="${org.url }">
        <button id="ctlBtn" type="button" class="btn btn-default" onclick="upload()">开始上传</button>
    </div>
</div>
		
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">真实姓名</label>
			<div class="layui-input-block">
				<input type="text"  name="realname" value="${org.realname }" class="layui-input newsName" lay-verify="required" placeholder="请输入真实姓名"/>
				
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
		    	<select name="sex" value="${org.sex}">
					<option value="0" <c:if test="${org.sex==0 }">selected</c:if>>男</option>
					<option value="1" <c:if test="${org.sex==1 }">selected</c:if>>女</option>
					<option value="2" <c:if test="${org.sex==2 }">selected</c:if>>保密</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">生日</label>
			<div class="layui-input-block">
				<input type="date"  name="birthday" value="${org.birthday }" class="layui-input newsName" lay-verify="required" placeholder="请输入生日日期"/>
				
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-block">
				<input type="text"   name="mobile" value="${org.mobile }" class="layui-input newsName" lay-verify="required" placeholder="请输入手机号"/>
				
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱地址</label>
			<div class="layui-input-block">
				<input type="text"  name="emain" value="${org.emain }" class="layui-input newsName" lay-verify="required" placeholder="请输入邮箱地址"/>
				
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">在用状态</label>
			<div class="layui-input-block">
		    	<select name="status" value="${org.status}">
					<option value="1" <c:if test="${org.status==1 }">selected</c:if>>上线</option>
					<option value="0" <c:if test="${org.status==0 }">selected</c:if>>下线</option>
				</select>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" type="submit" lay-filter="addNews">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
		</div>	
	</form>
	<script type="text/javascript" src="<%=path %>/js/layui/layui/layui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/layui/page/news/newsAdd.js"></script>
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
/* var formData = new FormData();
formData.append('id', ${org.id}); */


var uploader = WebUploader.create({
	
    // swf文件路径
    swf:  '<%=path%>/js/webuploader-0.1.5/Uploader.swf',
	/* data:formData, */
    // 文件接收服务端。
    server: '<%=path%>/cust/file.action',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',

    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false
  
});
var $list = $("#thelist");
// 当有文件添加进来的时候
uploader.on( 'fileQueued', function( file ) {
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
uploader.on( 'uploadSuccess', function(file,response) {
//response响应的是服务器返回的值
alert(JSON.stringify(response.name))
	var name = response.name;
	/* 给该id设置属性，填写服务器的绝对路径加上图片的名字 */
	$("#tx").attr("src","<%=path%>/upload/"+response.name);
    $( '#'+file.id ).addClass('upload-state-done');
    /* 给该id设置value值 */
    $("#url").val(name);
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
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ include file="common/meta.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<link href="${ctx}/css/login.css" rel="stylesheet">
		<style type="text/css">
		fi {
			width: 100%;
		}
		</style>
		<script >
		/*清楚表单*/
		function clearForm() {
			$("form").eq(0).form("clear");
		}
		
		/*ajax提交表单*/
		function submitForm() {
			var $loginForm = $("form").eq(0);
			
			$loginForm.form("submit",{
				url : "${ctx}/user/dologin.do",
				/*提交之前的验证*/
				onSubmit : function() {
					var validate = $(this).form("validate");
					if(!validate) {
						$.messager.alert({
							title : "警告",
							msg : "信息填写错误"
						});
					}
					/*需要返回验证结果，阻止表单提交*/
					return validate;
				},
				success : function (data) {
					var jsonData = $.parseJSON(data);
					if(jsonData.success) {
						//加载成功跳转另一个页面
						window.location.href="${ctx}/domain/index.do";
					} else {
						//给出提示警告
						$.messager.alert({
							title : "警告",
							msg : jsonData.msg
						});
					}
				}
			});
		}
		
		/*将登录框居中*/
		$(window).resize(function(){
			var $div = $("#login-div");
			var dw = $(window).width();
			var w = $div.outerWidth();
			var l = ( dw - w) / 2;
			var dh = $(window).height();
			var h = $div.outerHeight();
			var t = (dh - h) / 2;
			$div.css({
				position : "absolute",
				left : l,
				top : t
			})
		});
		
		$(document).ready(function(){
			
			$(window).resize();
			
		});
		
		//自定义校验器
		$.extend($.fn.validatebox.defaults.rules,{
			
		})
	</script>
	</head>
	<body>
		<div id="login-div" style="width: 100%; max-width: 400px;">
		<div class="easyui-panel" title="登录" style="width: 100%; max-width: 400px; padding: 30px 60px;">
			<form method="post" >
				<div style="margin-bottom: 20px;">
					<input class="fi easyui-textbox" name="user.loginName"  data-options="label:'用户名：',required:true"><br/>
				</div>
				<div style="margin-bottom: 20px;">
					<input class="fi easyui-textbox" type="password" name="user.password" data-options="label:'密码：',required:true"><br/>
				</div>
				<!-- <div>
					<input class="fi easyui-textbox" name="checkCode" data-options="label:'验证码：',required:true" >
				</div> -->
			</form>
			<div style="text-align: center; padding: 5px 3px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 40px;" onclick="submitForm()">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" style="width: 40px;" onclick="clearForm()">清除</a>
			</div>
		</div>
		</div>
	</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ include file="common/meta.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<link href="${ctx}/css/login.css" rel="stylesheet">
	</head>
	<script >
		$(function(){
			var $form = $("form").eq(0);
				//定义一个form表单
				/* $form.form("submit",{
					url : '${ctx}/user/dologin.do',
					//表单提交之前触发
					onSubmit : function() {
						var validateResult = $(this).form('enableValidation').form('validate');
						if(!validateResult) {
							$.messager.show({
								title : "提示信息",
								msg : "验证不通过，请重新填写数据"
							});
							return false;
						}
					},
					//表单提交成功触发
					success : function(data) {
						alert(data);
					}
				}); */
			$("#btn-submit").click(function(){
				//利用jqueryeasyui的表单验证
				var validateResult = $form.form("validate");
				alert(validateResult);
				if(validateResult) {
					$form.submit();
				}
			});
			/* $form.find("input").on("keyup",function(event){
				if(event.keyCode == 13) {
					$form.submit();
				}
			}); */
			
		});

		
		//自定义校验器
		$.extend($.fn.validatebox.defaults.rules,{
			
		})
	</script>
	<body>
		<div class="login-div" >
			<form method="post" action="${ctx}/user/dologin.do" width="400px" height="300px">
				用户名：<input type="text" name="user.loginName" class="easyui-validatebox" data-options="required:true"><br/>
				密&nbsp;&nbsp;&nbsp;码：<input type="password" name="user.password" class="easyui-validatebox" data-options="required:true"><br/>
				验证码：<input type="text" name="checkCode" class="easyui-validatebox" data-options="required:true" value=""><img title="点击刷新验证吗" src="${ctx}/checkCode.do" onclick="this.src='${ctx}/checkCode.do?'+Math.random()"><br/>

				<input type="button" value="提交" id="btn-submit"/>
				&nbsp;&nbsp;
				<input type="button" value="注册" />
			</form>
		</div>
	</body>
</html>
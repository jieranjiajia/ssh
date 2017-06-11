<%@ page contentType="text/html; charset=UTF-8" %>
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



	</script>
	<body>
		<div class="login-div" >
			<form action="${ctx}/user/dologin.do" method="post" width="400px" height="300px">
				用户名:<input type="text" name="user.name" class="easyui-validatebox" data-options="required:true"><br/>
				密&nbsp;&nbsp;&nbsp;码:<input type="text" name="user.password" class="easyui-validatebox" data-options="required:true"><br/>
				验证码:<input type="text" name="checkCode" value=""><img title="点击刷新验证吗" src="${ctx}/checkCode.do" onclick="this.src='${ctx}/checkCode.do?'+Math.random()"><br/>

				<input type="button" value="提交" />
				&nbsp;&nbsp;
				<input type="button" value="注册" />
			</form>
		</div>
	</body>
</html>
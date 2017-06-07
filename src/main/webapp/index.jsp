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
	<body>
		<div class="login-div">
			<form action="${ctx}/user/dologin.action" method="post">
				用户名:<input type="text" name="user.name"><br/>
				密    码:<input type="text" name="user.password"><br/>
				验证码:<input type="text" name=checkCode value=""><img title="点击刷新验证吗" src="${ctx}/checkCode.action" onclick="this.src='${ctx}/checkCode.action?'+Math.random()"><br/>
				<button type="button" value="提交" ></button>
				&nbsp;&nbsp;
				<button type="button" value="注册"></button>
			</form>
		</div>
	</body>
</html>
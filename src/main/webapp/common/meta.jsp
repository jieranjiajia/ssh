<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!-- 引入jquery -->
<script src="https://code.jquery.com/jquery-1.5.1.js"></script>
<!-- 引入jquery-easyui的设置 -->
<script src="${ctx}/js/jquery-easyui/jquery.easyui.min.js" ></script>
<!-- 引入语言环境 -->
<script src="${ctx}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入默认样式 -->
<link rel="stylesheet" href="${ctx}/js/jquery-easyui/themes/default/easyui.css" />
<!-- 引入默认的图标 -->
<link rel="stylesheet" href="${ctx}/js/jquery-easyui/themes/icons.css" />
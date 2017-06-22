<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!-- 引入jquery -->
<script src="https://code.jquery.com/jquery-1.8.1.js" charset="UTF-8"></script>
<!-- 引入jquery-easyui的设置 -->
<script src="${ctx}/js/jquery-easyui/jquery.easyui.min.js" charset="UTF-8"></script>
<!-- 引入语言环境 -->
<script src="${ctx}/js/jquery-easyui/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
<!-- 引入默认样式 -->
<link rel="stylesheet" href="${ctx}/js/jquery-easyui/themes/default/easyui.css" charset="UTF-8"/>
<!-- 引入默认的图标 -->
<link rel="stylesheet" href="${ctx}/js/jquery-easyui/themes/icon.css" />
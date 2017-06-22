<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/11
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/meta.jsp" %>
<html>
<head>
    <title>主菜单页</title>
    <link href="${ctx}/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/js/ztree/jquery.ztree.core.js" charset="UTF-8"></script>
    <script type="text/javascript">
    	var indexZtree;
    	/*zTree的初始化设置*/
    	var settings = {
    		callback : {
    			onClick : zTreeOnclick
    		},
    		data : {
    			simpleData : {
    				enable : true,
    				idKey : "id",
    				pIdKey : "pid",
    				rootPId : null
    			}
    		},
    		async : {
    			enable : true,
    			dataType : "json",
    			type : "GET",
    			url : "${ctx}/domain/indexZtree.do",
    		}
    	};
    	
    	function zTreeOnclick(event, treeid, treeNode) {
    		console.info(treeNode);
    	};
    	
    	$(function(){
    		indexZtree = $("#indexZtree");
    		var zTreeObj = $.fn.zTree.init(indexZtree,settings,[]);
    	});
    
    </script>
</head>
<body>

	登录成功，进入菜单页面
	<div>
		<ul id="indexZtree" class="ztree" style="width:260px; overflow:auto;"></ul>
	</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/11
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/meta.jsp" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
    			//onClick : zTreeOnclick
    		},
    		/*设置简单格式的显示*/
    		data : {
    			simpleData : {
    				enable : true,
    				idKey : "id",
    				pIdKey : "pid",
    				rootPId : null
    			},
    			key : {
    				url : "url"  
    			}
    		},
    		/*设置异步加载数据*/
    		async : {
    			enable : true,
    			dataType : "json",
    			type : "GET",
    			url : "${ctx}/domain/indexZtree.do",
    			dataFilter : function(treeId, parentNode, responseData) {
    				console.info(responseData);
    				if(responseData) {
    					$.each(responseData,function(index,obj){
    						//等于1时为按钮级别的，这里初始化时只初始化菜单级别的
    						if(obj.resourceType == '1') {
    							delete responseData[index];
    						} else {
    							obj.url = "${ctx}" + obj.url;
    						}
    					});
    				}
    				return responseData;
    			}
    		}
    	};   	
    	$(function(){
    		indexZtree = $("#indexZtree");
    		var zTreeObj = $.fn.zTree.init(indexZtree,settings,[]);
    	});
    
    </script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<!-- 头部 -->
	<div data-options="region:'north',split:true" style="height:100px;">
		<p align="right" style="margin-right: 40px;">
			<strong style="color: blue; font-size: 16px;">欢迎登录：</strong><i style="font-size: 18px;"><shiro:principal/></i>
		</p>
	</div>
	<div data-options="region:'west',split:true" style="width: 260px;">
		<ul id="indexZtree" class="ztree" style="width:220px; overflow:auto;"></ul>
	</div>
	<div data-options="region:'center',split:true"></div>
</body>
</html>

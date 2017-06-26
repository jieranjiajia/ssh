<%@ include file="/common/meta.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<!-- 个人觉得还是通过ajax异步加载比较好，更符合jqueryeasyui的风格 -->
<body>
	<table id="resource-table" >
	</table>
	<script type="text/javascript">
		$(function(){
			
			var $resourceTable = $("#resource-table");
			
			$resourceTable.datagrid({
				url : "${ctx}/resource/list.do",
				fitColumns : true,
				//定义表头
				columns : [[
				            {field : "id", title : "id", hidden : true},
				            {field : "pid", title : "pid", hidden : true},
				            {field : "name", title : "资源名称", align : "left"},
				            {field : "url", title : "资源路径", align : "left"},
				            {field : "resourceType", title : "资源级别",algein : "center", 
				            	formatter : function(value,row,index){
				            		if(value == "1") {
				            			return "按钮级别";
				            		} else {
				            			return "菜单级别";
				            		}
				            	}},
				            {field : "description", title : "资源描述", algin : "center"},
				            {field : "createTime", title : "创建时间", algin : "center"},
				            {field : "_operator",title : "操作",
				            	//定义操作删除按钮
				            	formatter : function(value, row, index){
				            		return "<span onclick=\"editResource("+index+")\">编辑</span>"
				            				+"&nbsp;&nbsp;&nbsp;<span onclick=\"deleteResource("+index+")\">删除</span>";
				            	}}]],
				
			});
			
		});
	</script>
</body>
</html>
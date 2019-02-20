<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>卡片管理</title>
<style type="text/css">
</style>


<link rel="stylesheet" href="${path}/static/css/zTree/myZTree.css">
<link rel="stylesheet" href="${path}/static/css/zTree/demo.css" type="text/css">
<link rel="stylesheet" href="${path}/static/css/zTree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${path}/static/js/zTree/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${path}/static/js/zTree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${path}/static/js/zTree/jquery.ztree.excheck.js"></script>

<script type="text/javascript">

/*
 *	 已经分配的菜单展示
 */
function allot(rid) {
	var setting = {
		check : {
			chkStyle: "checkbox",
			enable : true,
			
		},
	    async: {
	        enable: true,
		    url:"${path}/menu/allot.action",
			autoParam : [ "id", "name" ],
			contentType : "application/json;charset=utf-8",
			otherParam: { "role_id":rid},
			dataFilter : function filter(treeId, parentNode, childNodes) {
							if (!childNodes) return null;
							for (var i = 0, l = childNodes.length; i < l; i++) {
								childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
							}
							return childNodes;
						}
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : "0"
			}
		},
		callback : {
			onClick : function(treeId, treeNode) {
				var treeObj = $.fn.zTree.getZTreeObj(treeNode);
				var selectedNode = treeObj.getSelectedNodes()[0];
				$("#txtId").val(selectedNode.id);
				$("#txtAddress").val(selectedNode.name);
			}
		}
	//节点点击事件
	};
	return setting;
}

/*
 *	未分配的菜单展示
 */
 function unAllot(rid) {
	var setting={
			check : {
				chkStyle: "checkbox",
				enable : true,
				chkboxType: { "Y": "ps", "N": "ps" }
			},
		    async: {
		        enable: true,
			    url:"${path}/menu/unallot.action",
				autoParam : [ "id", "name" ],
				contentType : "application/json;charset=utf-8",
				otherParam: { "role_id":rid},
				dataFilter : function filter(treeId, parentNode, childNodes) {
								if (!childNodes) return null;
								for (var i = 0, l = childNodes.length; i < l; i++) {
									childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
								}
								return childNodes;
							}
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : "0"
				}
			},
			callback : {
				onClick : function (treeId, treeNode) {
					var treeObj = $.fn.zTree.getZTreeObj(treeNode);
					//var treeObj = $.fn.zTree.getZTreeObj("#alloted");
					var selectedNode = treeObj.getSelectedNodes()[0];
					$("#txtId").val(selectedNode.id);
					$("#txtAddress").val(selectedNode.name);
					
				}
			}//节点点击事件
		};
		return setting;
	}
var r_id;
	//获取角色时加载树
	function getRole(rid){
		
		$("#rId").val(rid);
		r_id=rid;

		var zTree1 = $.fn.zTree.init($("#alloted"), allot(rid));
		var zTree2 = $.fn.zTree.init($("#unallot"), unAllot(rid));
		
	}
	
	//获取选中未分配菜单的值	
	function getNodesId(){
		 var treeObj = $.fn.zTree.getZTreeObj("unallot"),
		 //获取树对象//被选中的节点的集合
		     nodes = treeObj.getCheckedNodes(); //获取输入框被勾选 或 未勾选的节点集合
		     var  ids="";
		     for(var i=0; i<nodes.length; i++){
		     ids += nodes[i].id + ","; //用逗号拼接id
		}
		     ids = ids.substring(0,(ids.length-1)); //截取最后一个逗号
			$("#get_id").val(ids);
			return ids;
	}
	
	
	//获取选中已分配菜单的值	
	function getMyNodesId(){
		 var treeObj = $.fn.zTree.getZTreeObj("alloted"),
		 //获取树对象//被选中的节点的集合
		     nodes = treeObj.getCheckedNodes(); //获取输入框被勾选 或 未勾选的节点集合
		     var  ids="";
		     for(var i=0; i<nodes.length; i++){
		     ids += nodes[i].id + ","; //用逗号拼接id
		}
		     ids = ids.substring(0,(ids.length-1)); //截取最后一个逗号
			$("#get_id").val(ids);
			return ids;
	}
	
	//处理点击添加事件
	function addMenu(){
		$.ajax({
			type: "POST",
			url: "${path}/menu/addmenu.action",
			contentType:"application/json;charset=utf-8",
			data:'{"role_id":'+r_id+',"mids":'+JSON.stringify(getNodesId())+'}',
			dataType:"text",
			success : function(data) {
				var treeObj = $.fn.zTree.getZTreeObj("alloted");
				treeObj.reAsyncChildNodes(null, "refresh");
				
				var treeObj = $.fn.zTree.getZTreeObj("unallot");
				treeObj.reAsyncChildNodes(null, "refresh");
				alert(data);
			},
			error:function(data){
				alert("网络异常！添加失败");
			}
		});
	}
	
	
	//处理点击移除事件
	function removeMenu(){
		$.ajax({
			type: "POST",
			url: "${path}/menu/removemenu.action",
			contentType:"application/json;charset=utf-8",
			data:'{"role_id":'+r_id+',"mids":'+JSON.stringify(getMyNodesId())+'}',
			dataType:"text",
			success : function(data) {
				var treeObj = $.fn.zTree.getZTreeObj("alloted");
				treeObj.reAsyncChildNodes(null, "refresh");
				
				var treeObj = $.fn.zTree.getZTreeObj("unallot");
				treeObj.reAsyncChildNodes(null, "refresh");
				alert("移除成功");
			},
			error:function(data){
				alert("删除失败");
			}
		});
	}
	
</script>

</head>

<body>

	<!-- 管理权限模块 -->
	<div id="menu_limit" style="display: block">


		<!-- 列出角色选项 -->
		<div id="role_select">
			<h1>角色</h1>
			<ul>
				<c:forEach items="${roleList}" var="r" >
						<li style="font-size:20px; margin-top:20px">
							<a style="text-decoration: none"
							href="javascript:void(0);" onmousedown="getRole('${r.role_id }');">
							${r.role_name }</a>
					
						</li>
				</c:forEach>
			</ul>
		</div>

		<!-- 已分配菜单显示 -->
		<div id="own_menu" class="zTreeDemoBackground left">
			<h1>已分配菜单</h1>
			<ul id="alloted" class="ztree" style="font-size: 28"></ul>
		</div>

		<!-- 配置菜单按钮 -->
		<div id="btn_select">
			<h1>选择按钮</h1>
			<input type="button" id="addLimit" class="limitbtn" onmousedown="addMenu();" value=" <添　加　" /><br />
			<input type="button" id="removeLimit" onmousedown="removeMenu()" class="limitbtn" value=" 移　除> " /><br /> 
		</div>

		<!-- 未分配的菜单 -->
		<div id="menu_select"" class="zTreeDemoBackground left">
			<h1>未分配菜单</h1>

			<ul id="unallot" class="ztree" style="font-size: 28"></ul>
		</div>

	</div>

</body>
</html>
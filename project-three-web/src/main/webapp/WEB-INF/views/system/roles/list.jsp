<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String roleid = request.getParameter("roleId");//用request得到 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Validate_sys.js"></script>
<title>用户列表</title>
<style>
	.td{
		text-align: center;
	}
	.roleclass{
		text-align: left
	}
</style>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/system/roles?roleId=<%=roleid%>">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          	<c:forEach items="${button_id}" var="b">
            <c:if test="${b.roleTMB.permission == 'roles:select'}">
          	<td width="100px">条件检索</td>
            <td width="900px">角色名称：<input type="text" name="rolename" style="width: 200px"/></td>
            <td>&nbsp;&nbsp;<input  type="submit" name="submit" value="查询" style="width:50px"/></td>
            </c:if>
            </c:forEach>
            <c:forEach items="${button_id}" var="b">
            <c:if test="${b.roleTMB.permission == 'roles:insert'}">
            <td>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/system/roles/insert?roleId=<%=roleid%>"><input  type="button" value="添加" style="width:50px"/></a></td>            
            </c:if>
            </c:forEach>
          </tr>
        </table>
	</form>
	<hr/>
	<table  border="1"  class="td" width="1200px" style="font-size: 8px;">
		<tr>
			<td width="50px;">序号</td>
			<td width="200px;">角色名称</td>
			<td width="200px;">描述</td>
			<td>管理用户</td>
			<td width="100px;">管理</td>
		</tr>
		<c:forEach items="${roles}" var="r" >
		<tr>
			<td>${r.id}</td>
			<td>${r.rolename}</td>
			<td>${r.counts}</td>
			<td class="roleclass">
				<c:forEach items="${userRole}" var="ru">
				<c:if test="${ru.roleId eq r.id}">
					${ru.users}
				</c:if>
				</c:forEach>
			</td>
			<td>
				<c:forEach items="${button_id}" var="b">
            	<c:if test="${b.roleTMB.permission == 'roles:update'}">
				<a href="${pageContext.request.contextPath}/system/roles/update/${r.id}?roleId=<%=roleid%>"><i></i>编辑</a>
				</c:if>
				</c:forEach>
				<c:forEach items="${button_id}" var="b">
            	<c:if test="${b.roleTMB.permission == 'roles:delete'}">
				<a href="${pageContext.request.contextPath}/system/roles/delete/${r.id}?roleId=<%=roleid%>" class="deleterole"><i></i>删除</a>
				</c:if>
				</c:forEach>
				<!-- hidden -->
				<input type="hidden" value="${r.rolename}"/>
				<c:forEach items="${userRole}" var="ru">
				<c:if test="${ru.roleId eq r.id}">
				<input type="hidden" value="${ru.users}"/>
				</c:if>
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
	</table>
	<table width="1200px;" style="font-size: 8px;" class="td">
		<tr>
		<td align="left">共${totalRecord}条数据|每页面记录${page.pageSize}条数据</td>
		<!-- 首页 -->
		<td width="35px;"><a href="${pageContext.request.contextPath}/system/roles?pn=0&ps=${page.pageSize}&roleId=<%=roleid%>">首页</a></td>
		<!-- 上一页 -->
		<td width="50px;">
		<a id="shangyiye" href="${pageContext.request.contextPath}/system/roles?pn=${bianPageShang}${jspurl}&ps=${page.pageSize}&roleId=<%=roleid%>">上一页
		<input id="pagePnShang" type="hidden" name="pn" value="${bianPageShang}"/>
		</a>
		</td>
		<!-- 页面的页数数字 -->
		<td align="center">
			<c:if test="${pageNo > 0}">
			<c:forEach begin="0" end="${pageNo-1}" step="1" var="pageIndex">
				<a <c:if test="${0 == pageIndex}">class="active"</c:if>
				href="${pageContext.request.contextPath}/system/roles?pn=${pageIndex}&ps=${page.pageSize}&roleId=<%=roleid%>">${pageIndex+1}</a>
			</c:forEach>
			</c:if>	
		</td>
		<!-- 下一页 -->
		<td width="50px;">
		<a id="xiayiye" href="${pageContext.request.contextPath}/system/roles?pn=${bianPageXia}${jspurl}&ps=${page.pageSize}&roleId=<%=roleid%>">
		<input id="pagePnXia" type="hidden" name="pn" value="${bianPageXia}"/>
		<input id="totalPage" type="hidden" name="pn" value="${pageNo}"/>下一页</a>
		</td>
		<!-- 末页 -->
		<td width="35px;"><a href="${pageContext.request.contextPath}/system/roles?pn=${pageNo-1}&ps=${page.pageSize}&roleId=<%=roleid%>">末页</a></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	//页面跳转
	$(function(){
		$("#page_ps_select").change(function(){
			window.location.href = '${pageContext.request.contextPath}/system/roles?ps='+$(this).val();
		});
	});
</script>
</html>
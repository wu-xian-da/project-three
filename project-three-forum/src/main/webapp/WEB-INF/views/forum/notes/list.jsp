<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1">
		<tr align="center">
			<td width="50px">序号</td>
			<td>标题</td>
			<td width="150px">所属模块</td>
			<td width="100px">状态</td>
			<td width="150px">发布时间</td>
			<td width="100px">操作管理</td>
		</tr>
		<c:forEach items="${membersallnotes}" var="man">
		<tr>
		<td align="center">${man.id}</td>
		<td>${man.theme}</td>
		<td>
			<c:forEach	items="${modulesall}" var="m">
				<c:if test="${m.id == man.parentmodules}">${m.name}--</c:if>
				<c:if test="${man.childsmodules == m.id}">${m.name}</c:if>
			</c:forEach>
		</td>
		<td align="center">${man.status.name}</td>
		<td align="center"><fmt:formatDate value="${man.releasetime}" pattern="yyyy-MM-dd HH:mm" type="date"/></td>
		<td align="center"><a href="${pageContext.request.contextPath}/forum/notes/update/${man.id}">编辑</a>|<a href="">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
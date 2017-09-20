<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<table height="50px" width="100%">
		<tr height="50px" valign="bottom">
		<td align="center"><a href="${pageContext.request.contextPath}/">首页</a></td>
		<c:forEach items="${modules}" var="m">
		<c:if test="${m.parentId == 0}">
		<td><a href="http://localhost:8888/main?modulesid=${m.id}">${m.name}</a></td>
		</c:if>
		</c:forEach>
		<td align="right">
			<a href="http://localhost:8888/log">登录</a>|<a href="http://localhost:8888/reg">注册</a>
		</td>
		</tr>
	</table>
	<hr/>
	<table width="100%">
		<c:forEach items="${allnotes}" var="an">
		<tr>
		<td width="50px">${an.id}</td>
		<td><a href="http://localhost:8888/forum/notes/selectnotes/${an.id}">${an.theme}</a></td>
		<td></td>
		<td width="150px"><fmt:formatDate value="${an.releasetime}" pattern="yyyy-MM-dd HH:mm" type="date"/></td>
		</tr>
		</c:forEach>
	</table>
</body>

</html>
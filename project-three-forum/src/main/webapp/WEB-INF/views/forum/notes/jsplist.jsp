<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询子模块</title>
</head>
<body>
	<table width="100%">
		<c:forEach items="${childsnotes}" var="an">
		<tr>
		<td width="50px">${an.id}</td>
		<td><a href="http://localhost:8888/forum/notes/selectnotes/${an.id}">${an.theme}</a></td>
		<td>
			<c:forEach	items="${modules}" var="m">
				<c:if test="${m.id == an.parentmodules}">${m.name}--</c:if>
				<c:if test="${m.id == an.childsmodules}">${m.name}</c:if>
			</c:forEach>
		</td>
		<td width="150px"><fmt:formatDate value="${an.releasetime}" pattern="yyyy-MM-dd HH:mm" type="date"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
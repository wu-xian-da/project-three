<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛内容</title>
</head>
<body>
	<table border="" cellspacing="0" width="100%">
		<c:forEach items="${notes}" var="n">
		<tr align="center">
		<td width="50px">${n.id}</td>
		<td align="left"><a href="http://localhost:8888/forum/notes/selectnotes/${n.id}">${n.theme}</a></td>
		<td width="150px"><fmt:formatDate value="${n.releasetime}" pattern="yyyy-MM-dd HH:mm" type="date" /></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>
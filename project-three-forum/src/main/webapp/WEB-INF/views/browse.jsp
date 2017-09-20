<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛内容页面</title>
</head>
<body>
	<table  border="" width="100%">
		<tr><td align="center"><h2>${notescontent.theme}</h2></td></tr>
		<tr><td align="center">发布时间--<fmt:formatDate value="${notescontent.releasetime}" pattern="yyyy-MM-dd HH:mm" type="date"/></td></tr>
		<tr><td>${notescontent.content}</td></tr>
		<tr><td align="center"><button type="button" onclick="javascript:history.back();">返回</button></td></tr>
	
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/member/members">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          	<td width="100px">条件检索</td>
            <td width="250px">账号：<input type="text" name="account" style="width: 150px"/></td>
            <td width="250px">姓名：<input type="text" name="username" style="width: 150px"/></td>
            <td align="right"><input  type="submit" value="查询" style="width:50px"/>&nbsp;&nbsp;</td>
          </tr>
        </table>

	</form>
	<hr>
	<table width="100%" border="1" style="font-size: 8px;">
		<tr align="center">
			<td width="50px">序号</td>
			<td>账号</td>
			<td>姓名</td>
			<td>邮箱</td>
			<td width="40px">性别</td>
			<td width="40px">年龄</td>
			<td width="100px">生日</td>
			<td>住址</td>
			<td width="100px">操作管理</td>
		</tr>
		<c:forEach items="${allmembers}" var="m">
			<tr align="center">
			<td>${m.id}</td>
			<td>${m.account}</td>
			<td>${m.username}</td>
			<td>${m.email}</td>
			<td>${m.gender.name}</td>
			<td>${m.age}</td>
			<td>${m.birthday}</td>
			<td>${m.address}</td>
			<td><a href="#">启用</a>|<a href="#">禁用</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
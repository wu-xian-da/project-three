<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String roleid = request.getParameter("roleid");//用request得到 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<style type="text/css">
	.leftsidebar_box dt{
		text-align: center;
		font-size: 25px;
	}
	
</style>

</head>

<body>

<div class="container">
	
	<div class="leftsidebar_box">
		<div class="line"></div>
		
		<dl class="syetem_management">
			<dt>
			<c:forEach items="${roletitle}" var="t">
			<c:if test="${t.titles == '[system]'}">
			<c:set value="${t.titles}" var="tt"></c:set>
			</c:if>
			</c:forEach>
			<c:if test="${tt == '[system]'}">
			系统管理
			</c:if>
			</dt>
			 
			<dd>
				<c:forEach items="${rolemenus}" var="m">
				<c:if test="${m.menus == '[users:list]'}">
				<c:set value="${m.menus}" var="ms"></c:set>
				</c:if>
				</c:forEach>
				<c:if test="${ms == '[users:list]'}">
				<a href="http://localhost:8080/system/users?roleId=<%=roleid%>" target="mainFrame">用户管理</a>
				</c:if>
			</dd>
			<dd>
				<c:forEach items="${rolemenus}" var="m">
				<c:if test="${m.menus == '[roles:list]'}">
				<c:set value="${m.menus}" var="ms"></c:set>
				</c:if>
				</c:forEach>
				<c:if test="${ms == '[roles:list]'}">
				<a href="http://localhost:8080/system/roles?roleId=<%=roleid%>" target="mainFrame">角色管理</a>
				</c:if>
			</dd>
			<dd>
				<c:forEach items="${rolemenus}" var="m">
				<c:if test="${m.menus == '[menus:list]'}">
				<c:set value="${m.menus}" var="ms"></c:set>
				</c:if>
				</c:forEach>
				<c:if test="${ms == '[menus:list]'}">
				<a href="http://localhost:8080/system/menus?roleId=<%=roleid%>" target="mainFrame">权限管理</a>
				</c:if>
			</dd>
		</dl>
		<dl>	
			<dt>
			<c:forEach items="${roletitle}" var="t">
			<c:if test="${t.titles == '[login]'}">
			<c:set value="${t.titles}" var="tt"></c:set>
			</c:if>
			</c:forEach>
			<c:if test="${tt == '[login]'}">
			系统日志
			</c:if>
			</dt>
			<dd>
				<c:forEach items="${rolemenus}" var="m">
				<c:if test="${m.menus == '[login:logins]'}">
				<c:set value="${m.menus}" var="ms"></c:set>
				</c:if>
				</c:forEach>
				<c:if test="${ms == '[login:logins]'}">
				<a href="http://localhost:8080/log/logins?roleId=<%=roleid%>" target="mainFrame">登录日志</a>
				</c:if>
			</dd>
			<dd>
				<c:forEach items="${rolemenus}" var="m">
				<c:if test="${m.menus == '[login:access]'}">
				<c:set value="${m.menus}" var="ms"></c:set>
				</c:if>
				</c:forEach>
				<c:if test="${ms == '[login:access]'}">
				<a href="http://localhost:8080/log/access?roleId=<%=roleid%>" target="mainFrame">访问日志</a>
				</c:if>
			</dd>
			
		</dl>
		
	</div>
	
</div>

<script src="http://localhost:8080/resources/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>
</body>
</html>

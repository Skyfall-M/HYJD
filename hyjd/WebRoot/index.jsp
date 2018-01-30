<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>SSH</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="SSH">

</head>

<body>
	添加user，如果姓名没有冲突，那么就添加到数据库，如果姓名冲突了就不能添加，返回失败页面
	<form action="add.action" method="get">
		用户名:<input type="text" name="user.username"><br />
		密码:<input type="password" name="user.userpassword"><br />
		信息:<input type="text" name="user.usermessage"><br />
		<input type="submit" value="注册"> <input type="reset"
			value="重置">
	</form>
	根据姓名查询，若不输入，则查询全部
	<form action="query.action" method="post">
		UserName： <input type="text" name="queryText" value="${searchText }" />
		<input type="submit" value="查询" />
	</form>

	<table width="70%" border="1px" align="center" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr bgcolor="#ff0">
				<th width="25%">编号</th>
				<th width="25%">姓名</th>
				<th width="25%">信息</th>
				<th width="25%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users }">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.usermessage}</td>
					<td><a href="edit.action?param=0&id=${user.id}">编辑</a> <a
						href="delete.action?id=${user.id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>

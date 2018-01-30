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
  	编辑User
    <form action="edit.action" method="get">
    ID:<input type="text" name="user.id" value="${user.id}" readonly="readonly"><br/>
    UserName:<input type="text" name="user.username" value="${user.username}"><br/>
    UserPassword:<input type="password" name="user.userpassword" value="${user.userpassword}"><br/>
    UserMessage:<input type="text" name="user.usermessage" value="${user.usermessage}"><br/>
    <input type="hidden" name="param" value="1"/>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    </form>
  </body>
</html>

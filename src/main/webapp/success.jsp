<%--
  Created by IntelliJ IDEA.
  User: Songx
  Date: 2018/3/10 0010
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    登录成功
<shiro:hasRole name="admin">
    欢迎admin登录啊按按<shiro:principal/>
</shiro:hasRole>
<shiro:hasPermission name="student:create">
    欢迎有student:create权限的人登录爱爱爱啊<shiro:principal/>
</shiro:hasPermission>
</body>
</html>

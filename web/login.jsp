<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/11/2018
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>

    <style>
        .errorMessage {
            color: red;
        }
    </style>
</head>
<body>
<s:form action="login" method="POST">
    <s:textfield label="Login ID" key="userId"/>
    <s:password label="Password" key="password"/>
    <s:submit value="Login"></s:submit>
</s:form>
</body>
</html>

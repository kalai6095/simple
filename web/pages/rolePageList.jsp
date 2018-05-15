<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/15/2018
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/import/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"><strong>RoleList</strong></div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>SL.No</th>
                    <th>Application</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>WebPage</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="roleInfolist" status="roleIdx" var="role">
                    <tr>
                        <td><s:property value="#roleIdx.index+1"/></td>
                        <td><s:property value="application"/></td>
                        <td><s:property value="name"/></td>
                        <td><s:property value="description"/></td>
                        <td><s:property value="resourceWebPage"/></td>
                        <td>
                            <a href="editRole?key=<s:property value="pkid"/>" type="button" class="btn btn-info" >Edit</a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="/import/jquery.min.js"></script>
<script src="/import/bootstrap.min.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/7/2018
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/import/bootstrap.min.css">
    <style>
        .label {
            color: black !important;
        }

        table > tbody > tr > td {
            padding: 5px 5px !important;
        }
    </style>
</head>
<body>

<fieldset>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <strong>Role Information</strong>
            </div>
            <div class="panel-body">
                <div class="col-md-12">
                    <s:form class="myform" action="saveRole" method="POST">
                        <s:hidden name="roleInfo.pkid"></s:hidden>
                        <s:textfield class="form-control" name="roleInfo.application" label="Application"/>

                        <s:textfield class="form-control" name="name" label="Name"/>
                        <s:textfield class="form-control" name="description" label="Description"/>
                        <s:textfield class="form-control" name="resourceWebPage" label="Resource Web Page"/>

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>SlNo.</th>
                                <th>Name</th>
                                <th>Read/update</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="subResources" status="sub" var="subres" >
                                <tr>
                                    <td><s:property value="#sub.index+1"/></td>
                                    <td>
                                        <s:textfield  cssClass="form-control" name="resourcename"
                                                     theme="simple"/>
                                    </td>
                                    <td>
                                        <s:set var="priIdx" value="1"/>
                                        <s:if test="showPermission==1 && priIdx==1">
                                            <s:checkbox name="isRead" value="true" theme="simple"/> Read
                                            <s:checkbox name="isUpdate" value="true" disabled="true" theme="simple"/>Update
                                        </s:if>
                                        <s:else>
                                            <s:checkbox name="isRead" value="true" theme="simple"/>Read
                                            <s:checkbox name="isUpdate" value="true" theme="simple"/>Update
                                        </s:else>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </table>
                        <s:submit value="Submit" cssClass="btn btn-sm btn-primary" theme="simple"></s:submit>
                        <s:reset cssClass="btn btn-sm btn-warning" theme="simple"></s:reset>
                    </s:form>
                </div>
            </div>
        </div>
    </div>

</fieldset>
<script src="/import/jquery.min.js"></script>
<script src="/import/bootstrap.min.js"></script>
</body>
</html>

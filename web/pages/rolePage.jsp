<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/7/2018
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="x" uri="/custom-tag"%>
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
                    <x:custom-tag cssClass="btn btn-sm btn-primary"></x:custom-tag>
                    <hr/>
                    new tag
                    <x:cust cssClass="btn btn-sm btn-warning" subrespermission="1" />

                    <s:form class="myform" action="saveRole" method="POST">
                        <s:hidden name="roleInfo.pkid"></s:hidden>
                        <s:textfield class="form-control" name="roleInfo.application" label="Application"/>

                        <s:textfield class="form-control" name="roleInfo.name" label="Name"/>
                        <s:textfield class="form-control" name="roleInfo.description" label="Description"/>
                        <s:textfield class="form-control" name="roleInfo.resourceWebPage" label="Resource Web Page"/>

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>SlNo.</th>
                                <th>Name</th>
                                <th>Read/update</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="roleInfo.subResources" status="sub" var="subres" >
                                <tr>
                                    <td><s:property value="#sub.index+1"/></td>
                                    <td>
                                        <s:textfield  cssClass="form-control" name="roleInfo.subResources[#sub.index].resourcename"
                                                     theme="simple"/>
                                        <s:property value="resourcename"/>name
                                    </td>
                                    <td>
                                        <s:set var="priIdx" value="1"/>
                                        <s:if test="showPermission==1 && priIdx==1">
                                            <s:checkbox name="roleInfo.subResources[#sub.index].isRead"  theme="simple"/> Read
                                            <s:checkbox name="roleInfo.subResources[#sub.index].isUpdate"  disabled="true" theme="simple"/>Update
                                        </s:if>
                                        <s:else>
                                            <s:checkbox name="roleInfo.subResources[#sub.index].isRead" theme="simple"/>Read
                                            <s:checkbox name="roleInfo.subResources[#sub.index].isUpdate" theme="simple"/>Update
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

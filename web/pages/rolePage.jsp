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
    <legend><strong>Role Information</strong></legend>
    <div class="col-md-6">
        <s:form class="myform" action="postTutorial" method="POST">
            ${roleInfo.subResources}
            <s:hidden name="roleInfo.pkid"></s:hidden>
            <s:textfield class="form-control" name="roleInfo.application" label="Application"/>

            <s:textfield class="form-control" name="roleInfo.name" label="Name"/>
            <s:textfield class="form-control" name="roleInfo.description" label="Description"/>
            <s:textfield class="form-control" name="roleInfo.resourceWebPage" label="Resource Web Page"/>
            <
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>SlNo.</th>
                    <th>Name</th>
                    <th>Read</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody>

                <s:iterator value="roleInfo.subResources" status="sub" var="subres">
                    <tr>
                        <TD>
                            <s:textfield name="#subres.resourcename" ></s:textfield>
                            <s:param name="#subres.resourcename"/>
                        </TD>
                        <TD>
                            <s:set var="priIdx" value="1"/>
                            <s:if test="roleInfo.showPermission==1 && priIdx==1">
                                <input name="#subres.isread"/>
                                <s:checkbox name="#subres.isRead"></s:checkbox>
                                <s:checkbox name="#subres.isUpdate" disabled="true"></s:checkbox>
                            </s:if>
                            <s:else>
                                <s:checkbox name="#subres.isRead"></s:checkbox>
                                <s:checkbox name="#subres.isUpdate"></s:checkbox>
                            </s:else>
                        </TD>
                        <TD>testing

                        </TD>
                        <TD><s:property value="isDirty"></s:property></TD>
                    </tr>
                </s:iterator>

                </tbody>
            </table>

            <table class="table table-bordered" border="0" cellspacing="0" cellpadding="1">
                <tr>
                    <th>Days of the week</th>
                    <th>Days of the week</th>
                    <th>Days of the week</th>
                </tr>

                <s:iterator begin="0" end="10"  status="rowstatus">
                    <tr>
                        <s:if test="#rowstatus.odd == true">
                            <td style="background: grey"><s:property/></td>
                            <td style="background: red"><s:property value="#rowstatus"/></td>
                            <td><s:textfield name="rowstatus"  /></td>
                        </s:if>
                        <s:else>
                            <td><s:property/></td>
                            <td><s:property value="#rowstatus"/></td>
                        </s:else>
                    </tr>
                </s:iterator>
            </table>

            <s:submit value="Submit"></s:submit>
        </s:form>
    </div>
</fieldset>
<script src="/import/jquery.min.js"></script>
<script src="/import/bootstrap.min.js"></script>
</body>
</html>

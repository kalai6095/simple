<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/14/2018
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Ticket Itinerary</title>
</head>
<body>
<h2>Ticket Itinerary</h2>
<div align="left">Your Ticket is booked with the following details.</div>
<table border="1">
    <tr>
        <td colspan=2>Journey Date : <s:property value="ticket.journeyDate"/></td>
        <td colspan=2>Booking Date : <s:property value="ticket.bookedOn"/></td>
    </tr>
    <tr>
        <td colspan=2>Bus Number : <s:property value="ticket.busNo"/></td>
        <td colspan=2>Bus Name : <s:property value="ticket.busName"/></td>
    </tr>

    <tr>
        <td colspan=2>From Station : <s:property value="ticket.fromStation"/></td>
        <td colspan=2>To Station : <s:property value="ticket.toStation"/></td>
    </tr>
    <tr>
        <td colspan=2>Fare : <s:property value="ticket.fare"/></td>
        <td colspan=2>Total Fare : <s:property value="ticket.totalFare"/></td>
    </tr>

    <tr>
        <td colspan=4 align="center">
            <h5>Passenger Details</h5>
        </td>
    </tr>

    <TR>
        <TD>S.No.</TD>
        <TD>Name</TD>
        <TD>Gender</TD>
        <TD>Age</TD>
    </TR>

    <s:iterator value="ticket.PassengerDetail" var="tickets">
        <tr>
            <td><s:property value="sno"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="gender"/></td>
            <td><s:property value="age"/></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>